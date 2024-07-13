package com.java_intern.cruddemo.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String email;
    private String username;
    private String password;
    private String created_at;
    private String updated_at;
}
