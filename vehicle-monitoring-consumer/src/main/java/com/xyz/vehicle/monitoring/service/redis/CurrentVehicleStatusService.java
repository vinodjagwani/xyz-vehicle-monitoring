package com.xyz.vehicle.monitoring.service.redis;


import com.xyz.vehicle.monitoring.entity.redis.CurrentVehicleStatusEntity;

/**
 * Created by vinodjagwani on 22/01/19.
 */
public interface CurrentVehicleStatusService {

    void createOrUpdate(final CurrentVehicleStatusEntity entity);

    CurrentVehicleStatusEntity findOne(final Long vehicleId);
}
