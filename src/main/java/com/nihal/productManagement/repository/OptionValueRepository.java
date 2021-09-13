package com.nihal.productManagement.repository;

import com.nihal.productManagement.model.OptionValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionValueRepository extends JpaRepository<OptionValues,String> {
}
