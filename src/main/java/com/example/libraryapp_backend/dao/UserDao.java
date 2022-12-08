package com.example.libraryapp_backend.dao;

import com.example.libraryapp_backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Integer> {
}
