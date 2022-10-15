package com.api.user.service.impl;

import com.api.user.client.UserLocationClient;
import com.api.user.dto.*;
import com.api.user.exception.UserFriendlyException;
import com.api.user.model.User;
import com.api.user.mapper.UserMapper;
import com.api.user.repository.UserRepository;
import com.api.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService
{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final UserLocationClient userLocationClient;
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
        userLocationClient.createUserLocationPartition(user.getUserId());
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

    @Override
    public User getUser(UUID userId) {
        Optional<User> user =  userRepository.findById(userId);
        if(user.isPresent())
        {
            return user.get();
        }
        throw new UserFriendlyException("User of this Id doesn't exit");
    }

    @Override
    public UserLatestLocationResponse getUserLocation(UUID userId)
    {
        User user = getUser(userId);
        LocationDTO locationDTO = userLocationClient.getLatestUserLocation(userId);
        return userMapper.createUserLocationResponse(user, locationDTO);
    }
}
