package com.api.jitpay.user.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest
{
    private LocalDateTime createdOn;

    private String email;

    private String firstName;

    private String secondName;
}
