package com.java_intern.cruddemo.service;

import com.java_intern.cruddemo.dto.UserDto;
import com.java_intern.cruddemo.entity.User;
import com.java_intern.cruddemo.exception.GlobalExceptionHandling;
import com.java_intern.cruddemo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    final UserMapper userMapper;
    @Override
    public UserDto getOne(Long id) {
        UserDto user = userMapper.getUserById(id);
        if (user == null) {
            throw new GlobalExceptionHandling.NotFoundResource("User not found");
        }
        return user;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> userDtos = userMapper.getAllUsers();
        return userDtos;
    }

    @Override
    public UserDto createUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public UserDto updateUser(Long id, User user) {
        return userMapper.updateUser(id, user);
    }

    @Override
    public String deleteUser(Long id) {
        userMapper.deleteUser(id);
        return "User has been deleted";
    }

}
