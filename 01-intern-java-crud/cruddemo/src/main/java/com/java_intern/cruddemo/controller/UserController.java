package com.java_intern.cruddemo.controller;

import com.java_intern.cruddemo.dto.PagingDto;
import com.java_intern.cruddemo.dto.UserDto;
import com.java_intern.cruddemo.entity.Paging;
import com.java_intern.cruddemo.entity.User;
import com.java_intern.cruddemo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
@PackagePrivate
public class UserController {
    final UserService userService;
    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getOne(id));
    }
    @PostMapping("/paging")
    public ResponseEntity<PagingDto<UserDto>> getAll(@RequestBody Paging paging) {
        PagingDto<UserDto> response = userService.getAll(paging);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
