package com.api.jitpay.user.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Serializable
{
    private UUID userId;

    private LocalDateTime createdOn;

    private String email;

    private String firstName;

    private String secondName;
}
