package com.nihal.productManagement.repository;

import com.nihal.productManagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    public Optional<Product> findByProductName(String productName);
}
