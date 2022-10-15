package com.api.user.client;

import com.api.user.dto.LocationDTO;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserLocationClient
{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Value("${application.location-reader-client}")
    private String locationReaderClientId;

    public LocationDTO getLatestUserLocation(UUID userId)
    {
        List<InstanceInfo> instanceInfoList = getInstances(locationReaderClientId);
        List<LocationDTO> locationDTOList = new ArrayList<>();
        for(InstanceInfo instanceInfo: instanceInfoList)
        {
            String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" +userId +"/location/_latest";
            LocationDTO locationDTO = restTemplate.getForObject(url, LocationDTO.class);
            locationDTOList.add(locationDTO);
        }

        return locationDTOList.size() > 0 ? locationDTOList.get(0) : null;
    }

    public void createUserLocationPartition(UUID userId)
    {
        List<InstanceInfo> instanceInfoList = getInstances(locationReaderClientId);
        for(InstanceInfo instanceInfo: instanceInfoList)
        {
            String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" +userId +"/location/partition";
            restTemplate.postForEntity(url, null, String.class);
        }
    }

    public void deleteUserLocationPartition(UUID userId)
    {
        List<InstanceInfo> instanceInfoList = getInstances(locationReaderClientId);
        for(InstanceInfo instanceInfo: instanceInfoList)
        {
            String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" +userId +"/location/partition";
            restTemplate.delete(url);
        }
    }

    private List<InstanceInfo> getInstances(String instanceId)
    {
        Application application = eurekaClient.getApplication(instanceId);
        return application.getInstances();
    }

}
