package com.api.jitpay.location.mapper;

import com.api.jitpay.location.dto.LocationCreationRequest;
import com.api.jitpay.location.model.Location;
import com.api.jitpay.user.dto.UserResponse;
import com.api.jitpay.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper
{
    Location locationRequestToLocation(LocationCreationRequest locationCreationRequest);
}