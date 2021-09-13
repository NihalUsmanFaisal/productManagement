package com.nihal.productManagement.controller;

import com.nihal.productManagement.model.OptionValues;
import com.nihal.productManagement.model.Product;
import com.nihal.productManagement.service.OptionValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OptionValueController {

    @Autowired
    private OptionValueService optionValueService;

    @PostMapping("/optionvalue/{optionId}")
    public ResponseEntity<?> addNewProduct(@PathVariable String optionId,@RequestBody String optionValueName){
        OptionValues newOptionValue = optionValueService.addNewOptionValue(optionId,optionValueName);
        return  new ResponseEntity(newOptionValue, HttpStatus.OK);
    }

    @PutMapping("/optionValue/{optionValueId}")
    public ResponseEntity<?> updateProduct(@PathVariable String optionValueId, @RequestBody String optionValueName){
        OptionValues updatedOption = optionValueService.updateOption(optionValueId,optionValueName);
        return new ResponseEntity(updatedOption,HttpStatus.OK);
    }

    @DeleteMapping("/optionValue/{optionValueId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String optionValueId){
        optionValueService.deleteOptionValue(optionValueId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
