package com.java_intern.cruddemo.controller;

import com.java_intern.cruddemo.dto.request.AuthenticationRequest;
import com.java_intern.cruddemo.dto.response.ApiResponse;
import com.java_intern.cruddemo.dto.response.AuthenticationResponse;
import com.java_intern.cruddemo.service.authentication.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    @PostMapping("/log-in")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        boolean result = authenticationService.authentication(request);
        ApiResponse apiResponse = new ApiResponse();
        if(result==true) apiResponse.setMessage("log in success");
        else apiResponse.setMessage("log in failed");
        apiResponse.setResult(AuthenticationResponse.builder().authenticate(result).build());
        return apiResponse;
    }
}
