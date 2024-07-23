package com.java_intern.cruddemo.service.user;

import com.java_intern.cruddemo.dto.response.PagingResponse;
import com.java_intern.cruddemo.dto.request.UserRequest;
import com.java_intern.cruddemo.dto.request.PagingRequest;
import com.java_intern.cruddemo.dto.response.UserResponse;
import com.java_intern.cruddemo.entity.Paging;
import com.java_intern.cruddemo.entity.User;
import com.java_intern.cruddemo.exception.AppException;
import com.java_intern.cruddemo.exception.ErrorCode;
import com.java_intern.cruddemo.mapper.UserMapper;
import com.java_intern.cruddemo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    private UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    private Paging<User> toPaging(PagingRequest<User> request) {
        int offset = (request.getCurrentPage() - 1) * request.getPageSize();
        request.setOffset(offset);

        List<User> users = userMapper.getAllUsers(request);
        long total = userMapper.countUsers();

        return Paging.<User>builder()
                .pageSize(request.getPageSize())
                .offset(request.getOffset())
                .currentPage(request.getCurrentPage())
                .total(total)
                .data(users)
                .build();
    }

    private PagingResponse<User> toPagingResponse(Paging<User> paging) {
        return PagingResponse.<User>builder()
                .pageSize(paging.getPageSize())
                .currentPage(paging.getCurrentPage())
                .total(paging.getTotal())
                .data(paging.getData())
                .build();
    }

    @Override
    public UserResponse getOne(Long id) {
        User user = userMapper.getUserById(id);
        return toUserResponse(user);
    }

    @Override
    public PagingResponse<User> getAll(PagingRequest request) {
        Paging<User> paging = toPaging(request);
        return toPagingResponse(paging);
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        if(userMapper.existsByUsername(request.getUsername())) throw new AppException(ErrorCode.USER_EXISTS);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encodedPassword);

        User user = userMapper.addUser(request);
        return toUserResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        if(userMapper.existsPassword(request.getPassword())) throw new AppException(ErrorCode.PASSWORD_EXISTS);
        User user =  userMapper.updateUser(id, request);
        return toUserResponse(user);
    }

    @Override
    public String deleteUser(Long id) {
        userMapper.deleteUser(id);
        return "User has been deleted";
    }
}
