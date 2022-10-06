package com.api.jitpay.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest
{
    private String userId;

    private String createdOn;

    private String email;

    private String firstName;

    private String secondName;
}
