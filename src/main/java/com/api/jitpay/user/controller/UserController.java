package com.api.jitpay.user.controller;

import com.api.jitpay.user.dto.UserCreationRequest;
import com.api.jitpay.user.dto.UserResponse;
import com.api.jitpay.user.dto.UserUpdateRequest;
import com.api.jitpay.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreationRequest request)
    {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/api/user")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserUpdateRequest request)
    {
        UserResponse response = userService.updateUser(request);
        return ResponseEntity.ok(response);
    }
}
