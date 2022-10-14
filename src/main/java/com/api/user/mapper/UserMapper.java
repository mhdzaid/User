package com.api.user.mapper;

import com.api.user.dto.UserCreationRequest;
import com.api.user.dto.UserResponse;
import com.api.user.model.User;
import com.api.user.dto.UserUpdateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    UserResponse userToUserResponse(User user);

    User userCreationRequestToUser(UserCreationRequest request);

    User userUpdateRequestToUser(UserUpdateRequest request);
}
