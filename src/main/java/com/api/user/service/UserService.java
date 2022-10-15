package com.api.user.service;

import com.api.user.dto.UserCreationRequest;
import com.api.user.dto.UserLatestLocationResponse;
import com.api.user.dto.UserResponse;
import com.api.user.model.User;
import com.api.user.dto.UserUpdateRequest;

import java.util.UUID;

public interface UserService
{
    UserResponse createUser(UserCreationRequest request);

    UserResponse updateUser(UserUpdateRequest request);

    User getUser(UUID userId);

    UserLatestLocationResponse getUserLocation(UUID userId);
}
