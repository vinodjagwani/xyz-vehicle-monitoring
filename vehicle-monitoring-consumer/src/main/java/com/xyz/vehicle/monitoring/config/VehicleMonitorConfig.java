package com.xyz.vehicle.monitoring.config;


import com.xyz.vehicle.monitoring.repository.redis.CurrentVehicleStatusRepository;
import com.xyz.vehicle.monitoring.repository.redis.impl.CurrentVehicleStatusRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@Configuration
public class VehicleMonitorConfig {


    @Autowired
    private RedisTemplate<Long, Object> redisTemplate;

    @Bean
    public CurrentVehicleStatusRepository currentVehicleStatusRepository() {
        return new CurrentVehicleStatusRepositoryImpl(redisTemplate);
    }


}

