package com.api.jitpay.user.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest
{
    private String createdOn;

    private String email;

    private String firstName;

    private String secondName;
}
