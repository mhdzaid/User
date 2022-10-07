package com.api.jitpay.location.controller;

import com.api.jitpay.location.dto.LocationCreationRequest;
import com.api.jitpay.location.service.LocationService;
import com.api.jitpay.user.dto.UserCreationRequest;
import com.api.jitpay.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LocationController
{
    private final LocationService locationService;

    @PostMapping("/api/user/{userId}/location")
    public ResponseEntity<UserResponse> createUser(@PathVariable String userId, @RequestBody LocationCreationRequest request)
    {
        locationService.createLocation(request);
        return ResponseEntity.ok().build();
    }
}