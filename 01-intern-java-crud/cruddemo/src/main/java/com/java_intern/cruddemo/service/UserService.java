package com.java_intern.cruddemo.service;

import com.java_intern.cruddemo.dto.PagingDto;
import com.java_intern.cruddemo.dto.UserDto;
import com.java_intern.cruddemo.entity.Paging;
import com.java_intern.cruddemo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserDto getOne(Long id);
    PagingDto<UserDto> getAll(Paging paging);
    UserDto createUser(User user);
    UserDto  updateUser(Long id , User user);
    String deleteUser(Long id);
}
