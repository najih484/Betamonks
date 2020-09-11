package com.usersappointment.controller;


import com.usersappointment.entity.Users;
import com.usersappointment.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api")
public class UsersController {

    @Autowired
    private UsersService service;

    //read all users

    @GetMapping(value = "/users")
    public List<Users> getUsers(){

        return service.getUsers();

    }


    // read by id

    @GetMapping(value = "/user/id/{id}")
    public Users getUserById(@PathVariable("id") Integer userId){
        return service.getUserbyID(userId);
    }

    // read by name

    @GetMapping(value = "/user/name/{name}")
    public Users getUserByName(@PathVariable("name") String userName){
        return service.getUserbyName(userName);
    }


    //create user

    @PostMapping(value = "/user")
    public Users createUser(@RequestBody Users user){
        return service.createUser(user);
    }

    //update user

    @PutMapping(value = "/user")
    public Users updateUser(@RequestBody Users user){
        return service.updateUser(user);
    }

    //delete by id

    @DeleteMapping(value ="/user/{id}")
    public String deleteById(@PathVariable("id") Integer userId){
        return service.deletebyId(userId);
    }

}
