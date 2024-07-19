package com.java_intern.cruddemo.mapper;

import com.java_intern.cruddemo.dto.PagingDto;
import com.java_intern.cruddemo.dto.UserDto;
import com.java_intern.cruddemo.entity.Paging;
import com.java_intern.cruddemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface UserMapper {
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers(@Param("getPaging") Paging paging);
    long countUsers();
    UserDto addUser(User user);
    UserDto updateUser(Long id , User user);
    UserDto deleteUser(Long id);
}

