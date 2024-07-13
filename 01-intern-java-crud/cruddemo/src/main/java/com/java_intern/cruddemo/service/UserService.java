package com.java_intern.cruddemo.service;

import com.java_intern.cruddemo.dto.UserDto;
import com.java_intern.cruddemo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserDto getOne(Long id);
    List<UserDto> getAll();
    UserDto createUser(User user);
    UserDto  updateUser(Long id , User user);
    String deleteUser(Long id);
}
