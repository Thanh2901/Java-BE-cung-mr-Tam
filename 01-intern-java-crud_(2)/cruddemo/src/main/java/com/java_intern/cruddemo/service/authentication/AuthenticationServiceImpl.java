package com.java_intern.cruddemo.service.authentication;

import com.java_intern.cruddemo.dto.request.AuthenticationRequest;
import com.java_intern.cruddemo.exception.AppException;
import com.java_intern.cruddemo.exception.ErrorCode;
import com.java_intern.cruddemo.mapper.AuthenticationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationMapper authenticationMapper;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
    @Override
    public boolean authentication(AuthenticationRequest request) {
        var user = authenticationMapper.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
