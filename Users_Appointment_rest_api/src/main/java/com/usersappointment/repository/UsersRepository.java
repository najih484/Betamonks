package com.usersappointment.repository;

import com.usersappointment.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users,Integer> {
    Users findByName(String userName);
}
