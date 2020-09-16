package com.usersappointment.service;



import com.usersappointment.entity.Users;
import com.usersappointment.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    //read all users

    public List<Users> getUsers() {

        List<Users> usersList = new ArrayList<>();

        repository.findAll()
                .forEach(user -> {
                    usersList.add(user);
                });

        return usersList;

    }

    //read by Id

    public Users getUserbyID(Integer userId) {

        return repository.findOne(userId);
    }

    //read by name

    public Users getUserbyName(String userName) {
        return repository.findByName(userName);
    }

    //create a new user

    public Users createUser(Users user) {
        return repository.save(user);
    }

    //update a existing user

    public Users updateUser(Users user) {
        Users existingUser = repository.findOne(user.getId());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setTime(user.getTime());
        existingUser.setDate(user.getDate());
        return repository.save(existingUser);

    }

    //delete user by Id
    public String deletebyId(Integer userId) {

        repository.delete(userId);
        return "UserId:" + userId +" Deleted Successfully";
    }
}
