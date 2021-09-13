package com.nihal.productManagement.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    public Product(){

    }

    public Product(String productName){
        this.productName = productName;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "product_id")
    private String id;

    private String productName;

    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private Set<Options> productOptions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<Options> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(Set<Options> productOptions) {
        this.productOptions = productOptions;
    }
}
