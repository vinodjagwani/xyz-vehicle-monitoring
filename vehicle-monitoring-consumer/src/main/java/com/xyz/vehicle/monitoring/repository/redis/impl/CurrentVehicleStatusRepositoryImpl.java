package com.xyz.vehicle.monitoring.repository.redis.impl;

import com.xyz.vehicle.monitoring.constant.Constants;
import com.xyz.vehicle.monitoring.entity.redis.CurrentVehicleStatusEntity;
import com.xyz.vehicle.monitoring.repository.redis.CurrentVehicleStatusRepository;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by vinodjagwani on 22/01/19.
 */
public class CurrentVehicleStatusRepositoryImpl implements CurrentVehicleStatusRepository {


    private RedisTemplate<Long, CurrentVehicleStatusEntity> redisTemplate;


    public CurrentVehicleStatusRepositoryImpl(final RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @Override
    public CurrentVehicleStatusEntity findOne(final Long id) {
        return redisTemplate.opsForValue().get(id);
    }

    @Override
    public void createOrUpdate(final CurrentVehicleStatusEntity entity) {
        redisTemplate.opsForValue().set(entity.getVehicleId(), entity, Constants.TIME_TO_LIVE, TimeUnit.SECONDS);
    }

}
