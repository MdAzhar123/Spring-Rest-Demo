package com.example.demo.versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonVersioningController {

//http://localhost:8080/api/person/param/?version=1
    @GetMapping(value = "/person/param",params = "version=1")

    public Person param1(){
        return new Person("Kahn");
    }

//http://localhost:8080/api/person/param/?version=2
    @GetMapping(value = "/person/param",params = "version=2")

    public Person1 param2(){
        return new Person1(new Name("Neuer","Lahm"));
    }


}
