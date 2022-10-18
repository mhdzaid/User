package com.api.user.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class UserProperties {

    private String locationReaderClient;
    private String userLatestLocationApi;
    private String userCreatePartitionApi;
    private String userDeletePartitionApi;
    private String userGetAllLocationsApi;

}
