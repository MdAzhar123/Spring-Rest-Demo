package com.example.demo.filtering;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FiterController {


    //static filtering
    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("value1","value2","value3");
    }

    //
    //
    //Dynamic filtering

/*
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean=new SomeBean("v11,","v12","v13");
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

        FilterProvider filters=new SimpleFilterProvider().addFilter("someBeanFilter",filter);



        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBean);
        return mappingJacksonValue;
    }
*/



    @GetMapping("/filtering-list")

    public List<SomeBean> retrieveListSomebean(){
        return Arrays.asList(new SomeBean("v1","v2","v3"),new SomeBean("a1","a2","a3"));
    }


}
