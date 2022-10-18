package com.api.user.mapper;

import com.api.user.dto.*;
import com.api.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    UserResponse userToUserResponse(User user);

    User userCreationRequestToUser(UserCreationRequest request);

    User userUpdateRequestToUser(UserUpdateRequest request);

    @Mapping(target="location.latitude", source="location.latitude")
    @Mapping(target="location.longitude", source="location.longitude")
    UserLatestLocationResponse createUserLocationResponse(User user, LocationDTO location);
}
