package com.nihal.productManagement.controller;

import com.nihal.productManagement.model.Product;
import com.nihal.productManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/all")
    public ResponseEntity<?> getAllProducts(){
        List<Product> products =  productService.getAllProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PostMapping("/product/add")
    public ResponseEntity<?> addNewProduct(@RequestBody Map<String,String> productName){
       Product newProduct = productService.addNewProduct(productName.get("productName"));
       return  new ResponseEntity(newProduct,HttpStatus.OK);
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable String productId,@RequestBody Map<String,String> productName){
        Product updatedProduct = productService.updateProduct(productId,productName.get("productName"));
        return new ResponseEntity(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId){
        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
