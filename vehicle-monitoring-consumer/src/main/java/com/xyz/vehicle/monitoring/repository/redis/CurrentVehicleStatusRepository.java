package com.xyz.vehicle.monitoring.repository.redis;


import com.xyz.vehicle.monitoring.entity.redis.CurrentVehicleStatusEntity;

/**
 * Created by vinodjagwani on 22/01/19.
 */
public interface CurrentVehicleStatusRepository extends RedisRepository<CurrentVehicleStatusEntity, Long> {
}
