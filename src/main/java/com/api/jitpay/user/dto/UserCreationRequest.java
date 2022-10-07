package com.api.jitpay.user.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest implements Serializable
{
    private String createdOn;

    private String email;

    private String firstName;

    private String secondName;
}
