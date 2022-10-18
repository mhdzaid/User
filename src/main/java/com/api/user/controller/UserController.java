package com.api.user.controller;

import com.api.user.client.UserLocationClient;
import com.api.user.dto.*;
import com.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    private final UserLocationClient userLocationClient;

    /**
     * Create User API
     * @param request
     * @return
     */
    @PostMapping("/api/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreationRequest request)
    {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Update User API
     * @param request
     * @return
     */
    @PutMapping("/api/user")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserUpdateRequest request)
    {
        UserResponse response = userService.updateUser(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Get User with current location
     * @param userId
     * @return
     */
    @GetMapping("/api/user/{userId}")
    public ResponseEntity<UserLatestLocationResponse> getUserLocation(@PathVariable String userId)
    {
        UserLatestLocationResponse response = userService.getUserLocation(UUID.fromString(userId));
        return ResponseEntity.ok(response);
    }

    /**
     * Get All User locations
     * @param userId
     * @return
     */
    @GetMapping("/api/user/{userId}/location")
    public ResponseEntity<UserLocationsResponse> getAllLocationsOfUser(@PathVariable String userId,
                                                                       @RequestParam("page") Integer page,
                                                                       @RequestParam("size") Integer size,
                                                                       @RequestParam("startDate") String startDate,
                                                                       @RequestParam("endDate") String endDate)
    {
        UserLocationsResponse response = userLocationClient.getUserLocationResponse(UUID.fromString(userId),
                LocalDateTime.parse(startDate), LocalDateTime.parse(endDate), page, size);
        return ResponseEntity.ok().body(response);
    }
}
