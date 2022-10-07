package com.api.jitpay.location.service;

import com.api.jitpay.location.dto.LocationCreationRequest;

public interface LocationService
{
    void createLocation(LocationCreationRequest request);
}
