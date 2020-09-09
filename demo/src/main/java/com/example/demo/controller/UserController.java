package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserDao userDao;





    @GetMapping("/users")
    public List<User> getUsers(){

        return userDao.findAll();
    }



    @GetMapping("/users/{id}")
    //@pathvariable indicates the value entered in url
    //localhost:8089/users/3



    //here we will get data of one user only.

    public User getUser(@PathVariable int id)

    {
        User user=userDao.findOne(id);

        if(user==null)
            throw new UserNotFound(id+" User not found");




        return user;
    }







//HATEOAS- enables us to easily add links to method
    //now we are using Hateoas so will get data of one user and a link to getUsers() from which we can see all the users.
/*
    public EntityModel<User> getUser(@PathVariable int id)

    {
        User user=userDao.findOne(id);

        if(user==null)
            throw new UserNotFound(id+" User not found");

        //"all-users", SERVER_PATH +"/users"
        //getUsers
        // from spring boot 2 Resource changed to EntityModel

        EntityModel<User> entityModel= new EntityModel<User>(user);

        //This will enable us to create links from method
        ControllerLinkBuilder controllerLinkBuilder= ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getUsers());

        entityModel.add(controllerLinkBuilder.withRel("all-users"));


        return entityModel;
    }

*/







    @PostMapping("/users")

    //@RequestBody maps the json entered value to parameters of User class

    public ResponseEntity<Object> create(@Valid @RequestBody User user){

        User savedUser= userDao.save(user);

        //want to return the current url and created status

        //users/{id}
        URI location=
        ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

      return   ResponseEntity.created(location).build();

    }


    // we use response entity to show detail about HTTP response . Body and Status code will be displayed in client server(PostMan)
    //After post request.


    /*@PostMapping("/users" )

    public ResponseEntity<Object> create(@Valid @RequestBody User user){
        return new ResponseEntity<>(userDao.save(user), HttpStatus.OK);
    }*/




//If we won't use response status then we will not get message body displayed in Postman


/*@PostMapping("/users")

public void create(@RequestBody User user){
    userDao.save(user);
}*/



    @DeleteMapping("/users/{id}")

    //@pathvariable indicates the value entered in url
    //localhost:8089/users/3

    public void removeUser( @PathVariable int id)

    {
        User user=userDao.delete(id);
        if(user==null)
            throw new UserNotFound(id+" User not found");

    }





}
