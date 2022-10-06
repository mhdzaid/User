package com.api.jitpay.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse
{
    private LocalDateTime createdOn;

    private String email;

    private String firstName;

    private String secondName;
}
