package com.xyz.vehicle.monitoring.service.redis.impl;

import com.xyz.vehicle.monitoring.entity.redis.CurrentVehicleStatusEntity;
import com.xyz.vehicle.monitoring.repository.redis.CurrentVehicleStatusRepository;
import com.xyz.vehicle.monitoring.service.redis.CurrentVehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@Service
public class CurrentVehicleStatusServiceImpl implements CurrentVehicleStatusService {


    @Autowired
    private CurrentVehicleStatusRepository currentVehicleStatusRepository;


    @Override
    public void createOrUpdate(final CurrentVehicleStatusEntity entity) {
        currentVehicleStatusRepository.createOrUpdate(entity);

    }

    @Override
    public CurrentVehicleStatusEntity findOne(final Long vehicleId) {
        return currentVehicleStatusRepository.findOne(vehicleId);
    }
}
