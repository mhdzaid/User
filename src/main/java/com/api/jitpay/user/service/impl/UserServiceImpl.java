package com.api.jitpay.user.service.impl;

import com.api.jitpay.exception.UserFriendlyException;
import com.api.jitpay.user.dto.UserCreationRequest;
import com.api.jitpay.user.dto.UserResponse;
import com.api.jitpay.user.dto.UserUpdateRequest;
import com.api.jitpay.user.mapper.UserMapper;
import com.api.jitpay.user.model.User;
import com.api.jitpay.user.repository.UserRepository;
import com.api.jitpay.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService
{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponse createUser(UserCreationRequest request)
    {
        boolean userExists = userRepository.existsByEmail(request.getEmail());
        if(userExists)
        {
            throw new UserFriendlyException("User already exists");
        }
        User user = userMapper.userCreationRequestToUser(request);
        User userCreated = userRepository.save(user);
        UserResponse response = userMapper.userToUserResponse(userCreated);
        return response;
    }

    @Override
    public UserResponse updateUser(UserUpdateRequest request)
    {
        boolean userExists = userRepository.existsByEmail(request.getEmail());
        if(!userExists)
        {
            throw new UserFriendlyException("User doesn't already exists");
        }
        User userToUpdate = userMapper.userUpdateRequestToUser(request);
        User userUpdated = userRepository.save(userToUpdate);
        UserResponse response = userMapper.userToUserResponse(userUpdated);
        return response;
    }
}
