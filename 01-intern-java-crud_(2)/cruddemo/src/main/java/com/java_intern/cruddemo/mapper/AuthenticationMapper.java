package com.java_intern.cruddemo.mapper;

import com.java_intern.cruddemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface AuthenticationMapper {
    Optional<User> findByUsername(@Param("username") String username);
}
