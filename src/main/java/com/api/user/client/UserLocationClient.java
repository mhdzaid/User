package com.api.user.client;

import com.api.user.dto.LocationDTO;
import com.api.user.dto.UserLocationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserLocationClient
{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.location-reader-client}")
    private String locationReaderClientId;

    public LocationDTO getLatestUserLocation(UUID userId)
    {
        String url = "http://" + locationReaderClientId + "/api/user/" +userId +"/location/_latest";
        LocationDTO locationDTO = restTemplate.getForObject(url, LocationDTO.class);
        return locationDTO;
    }

    public void createUserLocationPartition(UUID userId)
    {
        String url = "http://" + locationReaderClientId + "/api/user/" +userId +"/location/partition";
        restTemplate.postForEntity(url, null, String.class);
    }

    public void deleteUserLocationPartition(UUID userId)
    {

        String url = "http://" + locationReaderClientId + "/api/user/" +userId +"/location/partition";
        restTemplate.delete(url);

    }

    public UserLocationsResponse getUserLocationResponse(UUID userId, LocalDateTime parse, LocalDateTime parse1, Integer page, Integer size)
    {
        String url = "http://" + locationReaderClientId + "/api/user/" +userId +"/location?page="+page+"&size="+size+"&startDate="+parse.toString()+"&endDate="+parse1.toString();
        UserLocationsResponse response = restTemplate.getForObject(url, UserLocationsResponse.class);
        return response;
    }
}
