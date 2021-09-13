package com.nihal.productManagement.repository;

import com.nihal.productManagement.model.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Options,String> {
}
