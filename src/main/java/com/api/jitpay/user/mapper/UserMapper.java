package com.api.jitpay.user.mapper;

import com.api.jitpay.user.dto.UserCreationRequest;
import com.api.jitpay.user.dto.UserResponse;
import com.api.jitpay.user.dto.UserUpdateRequest;
import com.api.jitpay.user.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    UserResponse userToUserResponse(User user);

    User userCreationRequestToUser(UserCreationRequest request);

    User userUpdateRequestToUser(UserUpdateRequest request);
}
