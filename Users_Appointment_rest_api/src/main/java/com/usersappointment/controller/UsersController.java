package com.usersappointment.controller;


import com.usersappointment.entity.Users;
import com.usersappointment.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api")
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService service;

    //read all users

    @GetMapping(value = "/users")
    public List<Users> getUsers(){

        logger.info("read all users");

        return service.getUsers();


    }


    // read by id

    @GetMapping(value = "/user/id/{id}")
    public Users getUserById(@PathVariable("id") Integer userId){

        if((service.getUserbyID(userId))==null){
            logger.error("User Not Found");
            throw new UserNotFoundException("id: "+ userId);
        }

        logger.info("read user by ID");
        return service.getUserbyID(userId);
    }

    // read by name

    @GetMapping(value = "/user/name/{name}")
    public Users getUserByName(@PathVariable("name") String userName){

        if((service.getUserbyName(userName))==null){
            logger.error("User Not Found");
            throw new UserNotFoundException("name: "+ userName);
        }
        logger.info("read user by name");
        return service.getUserbyName(userName);
    }


    //create user

    @PostMapping(value = "/user")
    public Users createUser(@RequestHeader String authentication,@RequestBody Users user){

        logger.info("Create User");
        return service.createUser(user);
    }

    //update user

    @PutMapping(value = "/user")
    public Users updateUser(@RequestHeader String authentication,@RequestBody Users user){
        logger.info("Update User");
        return service.updateUser(user);
    }

    //delete by id

    @DeleteMapping(value ="/user/{id}")
    public String deleteById(@PathVariable("id") Integer userId){

        logger.info("Delete User");
        return service.deletebyId(userId);

    }

    @GetMapping(value = "/invalid")
    public String invalid(){
        logger.warn("invalid url");
        return "You are not authorized";

    }

    @Value("classpath:data/data.json")
    private Resource resourceFile;

    @GetMapping(value = "/logindetails")
    Resource loginDetails() {
        return resourceFile;
    }

}
