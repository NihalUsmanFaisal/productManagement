package com.nihal.productManagement.service;

import com.nihal.productManagement.exceptions.ResourceAlreadyExistsExcpetion;
import com.nihal.productManagement.exceptions.ResourceNotFoundException;
import com.nihal.productManagement.model.Options;
import com.nihal.productManagement.model.Product;
import com.nihal.productManagement.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OptionService {

    @Autowired
    private OptionRepository repository;

    @Autowired
    private ProductService productService;

    public Options getOptionById(String optionId){
        Optional<Options> existingOption = repository.findById(optionId);
        if(!existingOption.isPresent()){
            throw new ResourceNotFoundException("Option does not exist");
        }
        return existingOption.get();
    }

    public Options addNewOption(String productId,String optionName){
        Product existingProduct = productService.getProductById(productId);
        Options newOption = new Options();
        newOption.setOptionName(optionName);
        newOption.setProduct(existingProduct);
        return  repository.save(newOption);
    }

    public Options updateOption(String optionId,String optionName){
        Options currentOption = getOptionById(optionId);
        currentOption.setOptionName(optionName);
        return  repository.save(currentOption);
    }

    public void deleteOption(String optionId){
        Options existingOption = getOptionById(optionId);
        repository.delete(existingOption);
    }
}
