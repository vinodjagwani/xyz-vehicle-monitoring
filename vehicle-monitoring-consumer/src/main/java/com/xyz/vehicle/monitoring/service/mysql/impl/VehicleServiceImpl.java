package com.xyz.vehicle.monitoring.service.mysql.impl;

import com.querydsl.core.types.Predicate;
import com.xyz.vehicle.monitoring.entity.mysql.VehicleEntity;
import com.xyz.vehicle.monitoring.entity.redis.CurrentVehicleStatusEntity;
import com.xyz.vehicle.monitoring.repository.mysql.VehicleRepository;
import com.xyz.vehicle.monitoring.service.mysql.VehicleService;
import com.xyz.vehicle.monitoring.service.redis.CurrentVehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class VehicleServiceImpl implements VehicleService {


    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CurrentVehicleStatusService currentVehicleStatusService;


    @Override
    public Page<VehicleEntity> findAll(final Predicate predicate, final Pageable pageable) {
        final Page<VehicleEntity> entities = vehicleRepository.findAll(predicate, pageable);
        for (VehicleEntity entity : entities) {
            final CurrentVehicleStatusEntity vehicleStatus = currentVehicleStatusService.findOne(entity.getVehicleId());
            entity.setStatus(vehicleStatus != null && vehicleStatus.isStatus());
        }
        return entities;
    }
}
