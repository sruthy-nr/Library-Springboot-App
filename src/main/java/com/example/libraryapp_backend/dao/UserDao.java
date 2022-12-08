package com.example.libraryapp_backend.dao;

import com.example.libraryapp_backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer> {

    @Query(value = "SELECT `id`, `aadhaar`, `address`, `cpassword`, `dob`, `email`, `name`, `password`, `phone`, `pincode`, `username` FROM `user` WHERE `username`= :uname  AND `password`= :pswd",nativeQuery = true)
    public List<User> userLogin(@Param("uname") String uname, @Param("pswd") String pswd);
}
