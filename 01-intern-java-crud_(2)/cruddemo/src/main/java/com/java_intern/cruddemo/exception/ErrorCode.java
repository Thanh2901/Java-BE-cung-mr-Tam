package com.java_intern.cruddemo.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public enum ErrorCode {
    UNCATEGORIZED_SQL(9999, "uncategorized sql"),
    INVALID_KEY(1005, "invalid key"),
    USER_NOT_EXISTED(1006, "user is not existed"),
    USER_EXISTS(1004, "user have already existed"),
    PASSWORD_EXISTS(1003, "password already existed"),
    USERNAME_INVALID(1002, "username must be at least 3 characters"),
    PASSWORD_INVALID(1001, "password must be at least 8 characters"),
    ;
    int errorCode;
    String message;
}
