package com.nihal.productManagement.service;

import com.nihal.productManagement.exceptions.ResourceNotFoundException;
import com.nihal.productManagement.model.OptionValues;
import com.nihal.productManagement.model.Options;
import com.nihal.productManagement.model.Product;
import com.nihal.productManagement.repository.OptionValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class OptionValueService {

    @Autowired
    private OptionValueRepository repository;

    @Autowired
    private OptionService optionService;

    public OptionValues getOptionValueById(String optionValueId){
        Optional<OptionValues> existingOptionValue = repository.findById(optionValueId);
        if(!existingOptionValue.isPresent()){
            throw new ResourceNotFoundException("Option does not exist");
        }
        return existingOptionValue.get();
    }

    public OptionValues addNewOptionValue(String optionId,String optionValueName){
        Options existingOption = optionService.getOptionById(optionId);
        OptionValues newOptionValue = new OptionValues();
        newOptionValue.setOption(existingOption);
        newOptionValue.setOptionValueName(optionValueName);
        return  repository.save(newOptionValue);
    }

    public OptionValues updateOption(String optionValueId,String optionValueName){
        OptionValues currentOptionValue = getOptionValueById(optionValueId);
        currentOptionValue.setOptionValueName(optionValueName);
        return  repository.save(currentOptionValue);
    }

    public void deleteOptionValue(String optionValueId){
        OptionValues existingOptionValue = getOptionValueById(optionValueId);
        repository.delete(existingOptionValue);
    }

}
