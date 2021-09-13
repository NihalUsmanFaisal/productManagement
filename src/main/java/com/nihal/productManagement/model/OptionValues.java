package com.nihal.productManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "option_value")
public class OptionValues {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "option_value_id")
    private String id;

    private String optionValueName;

    @ManyToOne
    @JoinColumn(name = "option_id",nullable = false)
    @JsonIgnore
    private Options options;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOptionValueName() {
        return optionValueName;
    }

    public void setOptionValueName(String optionValueName) {
        this.optionValueName = optionValueName;
    }

    public Options getOption() {
        return options;
    }

    public void setOption(Options option) {
        this.options = option;
    }
}
