package com.java_intern.cruddemo.service;

import com.java_intern.cruddemo.dto.PagingDto;
import com.java_intern.cruddemo.dto.UserDto;
import com.java_intern.cruddemo.entity.Paging;
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
    public PagingDto<UserDto> getAll(Paging paging) {
        int offset = (paging.getCurrentPage() - 1) * paging.getPageSize();
        paging.setOffset(offset);

        List<UserDto> userDtos = userMapper.getAllUsers(paging);
        long total = userMapper.countUsers();

        paging.setData(userDtos);
        paging.setTotal(total);

        PagingDto pagingDto = new PagingDto();
        pagingDto.setCurrentPage(paging.getCurrentPage());
        pagingDto.setPageSize(paging.getPageSize());
        pagingDto.setTotal(paging.getTotal());
        pagingDto.setData(paging.getData());
        return pagingDto;
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
