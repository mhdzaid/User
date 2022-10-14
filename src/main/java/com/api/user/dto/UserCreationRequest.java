package com.api.user.dto;

import lombok.*;

import java.io.Serializable;

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
