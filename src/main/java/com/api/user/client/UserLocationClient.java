package com.api.user.client;

import com.api.user.dto.LocationDTO;
import com.api.user.dto.UserLocationsResponse;
import com.api.user.util.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserLocationClient
{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserProperties userProperties;

    /**
     * API call to location-reader microservice to get latest user location
     * @param userId
     * @return
     */
    public LocationDTO getLatestUserLocation(UUID userId)
    {
        String url = MessageFormat.format(userProperties.getUserLatestLocationApi(), userProperties.getLocationReaderClient(), userId);
        LocationDTO locationDTO = restTemplate.getForObject(url, LocationDTO.class);
        return locationDTO;
    }

    /**
     * API call to location-reader microservice to create partition when a user is created
     * @param userId
     */
    public void createUserLocationPartition(UUID userId)
    {
        String url = MessageFormat.format(userProperties.getUserCreatePartitionApi(), userProperties.getLocationReaderClient(), userId);
        restTemplate.postForEntity(url, null, String.class);
    }

    /**
     * API call to location-reader microservice to delete partition when a user is deleted
     * @param userId
     */
    public void deleteUserLocationPartition(UUID userId)
    {
        String url = MessageFormat.format(userProperties.getUserDeletePartitionApi(), userProperties.getLocationReaderClient(), userId);
        restTemplate.delete(url);

    }

    /**
     * API call to location-reader microservice to get all locations of user in a time frame
     * @param userId
     * @param startDate
     * @param endDate
     * @param page
     * @param size
     * @return Paginated response
     */
    public UserLocationsResponse getUserLocationResponse(UUID userId, LocalDateTime startDate, LocalDateTime endDate, Integer page, Integer size)
    {
        String url = MessageFormat.format(userProperties.getUserGetAllLocationsApi(), userProperties.getLocationReaderClient(), userId, page, size, startDate, endDate);
        UserLocationsResponse response = restTemplate.getForObject(url, UserLocationsResponse.class);
        return response;
    }
}
