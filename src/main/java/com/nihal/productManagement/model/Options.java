package com.nihal.productManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Options")
public class Options {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "option_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    @JsonIgnore
    private Product product;

    @OneToMany(mappedBy = "options",cascade = CascadeType.REMOVE)
    private Set<OptionValues> optionValuesSet;

    private String optionName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Set<OptionValues> getOptionValuesSet() {
        return optionValuesSet;
    }

    public void setOptionValuesSet(Set<OptionValues> optionValuesSet) {
        this.optionValuesSet = optionValuesSet;
    }
}
