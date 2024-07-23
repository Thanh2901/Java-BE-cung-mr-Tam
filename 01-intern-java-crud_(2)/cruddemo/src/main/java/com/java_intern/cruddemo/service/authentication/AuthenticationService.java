package com.java_intern.cruddemo.service.authentication;

import com.java_intern.cruddemo.dto.request.AuthenticationRequest;

public interface AuthenticationService {
    boolean authentication(AuthenticationRequest request);
}
