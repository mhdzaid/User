package com.api.user.mapper;

import com.api.user.dto.*;
import com.api.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    UserResponse userToUserResponse(User user);

    User userCreationRequestToUser(UserCreationRequest request);

    User userUpdateRequestToUser(UserUpdateRequest request);

    UserLatestLocationResponse createUserLocationResponse(User user, LocationDTO locationDTO);
}
