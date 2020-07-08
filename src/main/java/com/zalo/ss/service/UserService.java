package com.zalo.ss.service;

import java.util.List;

import com.zalo.ss.model.User;
import com.zalo.ss.model.UserDto;

public interface UserService {

    User save(UserDto user);

    List<User> findAll();

    void delete(long id);

    User findOne(String username);

    User findById(Long id);
    
    User getCurrent();
}