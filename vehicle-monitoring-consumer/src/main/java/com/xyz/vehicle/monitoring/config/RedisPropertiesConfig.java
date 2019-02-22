package com.xyz.vehicle.monitoring.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@Data
@ConfigurationProperties(prefix = "redis")
public class RedisPropertiesConfig {

    private String host;

    private Integer port;

    private Integer node;

    private String auth;

    private String master;


}
