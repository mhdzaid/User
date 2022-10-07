package com.api.jitpay.user.service;

import com.api.jitpay.user.dto.UserCreationRequest;
import com.api.jitpay.user.dto.UserResponse;
import com.api.jitpay.user.dto.UserUpdateRequest;
import com.api.jitpay.user.model.User;

import java.util.UUID;

public interface UserService
{
    UserResponse createUser(UserCreationRequest request);

    UserResponse updateUser(UserUpdateRequest request);

    User getUser(UUID userId);
}
