package com.example.demo.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

//static filtering
@JsonIgnoreProperties(value = {"field1","field3"})

@Data
@AllArgsConstructor
public class SomeBean {

    private String field1;
    private String field2;

    //we dont want to show this in response
    //Instead of JSonIgnore wecan use JsonIgnoreProperties
    //static filtering
    /*@JsonIgnore*/

    
    private String field3;

}
