package com.nihal.productManagement.service;

import com.nihal.productManagement.exceptions.ResourceAlreadyExistsExcpetion;
import com.nihal.productManagement.exceptions.ResourceNotFoundException;
import com.nihal.productManagement.model.Product;
import com.nihal.productManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product getProductById(String productId){
        Optional<Product> existingProduct = repository.findById(productId);
        if(!existingProduct.isPresent()){
            throw new ResourceNotFoundException("Product not found");
        }
        return existingProduct.get();
    }

    public Product addNewProduct(String productName){
        Optional<Product> existingProduct = repository.findByProductName(productName);
        if(existingProduct.isPresent()){
            throw new ResourceAlreadyExistsExcpetion("Product already Exists");
        }
        Product newProduct = new Product(productName);
        return  repository.save(newProduct);
    }

    public Product updateProduct(String id,String productName){
        Product currentProduct = getProductById(id);
        currentProduct.setProductName(productName);
        return  repository.save(currentProduct);
    }

    public void deleteProduct(String productId){
        Optional<Product> existingProduct = repository.findById(productId);
        if(existingProduct.isPresent()){
            repository.delete(existingProduct.get());
        }

    }
}
