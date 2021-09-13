package com.nihal.productManagement.controller;

import com.nihal.productManagement.model.Options;
import com.nihal.productManagement.model.Product;
import com.nihal.productManagement.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OptionController {

    @Autowired
    private OptionService optionService;

    @PostMapping("/option/add/{productId}")
    public ResponseEntity<?> addNewProduct(@PathVariable String productId,@RequestBody Map<String,String> optionName){
        Options newOptions = optionService.addNewOption(productId,optionName.get("optionName"));
        return  new ResponseEntity(newOptions, HttpStatus.OK);
    }

    @PutMapping("/option/{optionId}")
    public ResponseEntity<?> updateProduct(@PathVariable String optionId, @RequestBody Map<String,String> optionName){
        Options updateOption = optionService.updateOption(optionId,optionName.get("optionName"));
        return new ResponseEntity(updateOption,HttpStatus.OK);
    }

    @DeleteMapping("/option/{optionId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String optionId){
        optionService.deleteOption(optionId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
