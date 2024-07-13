package com.java_intern.cruddemo.dto;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String email;
    private String password;
}
