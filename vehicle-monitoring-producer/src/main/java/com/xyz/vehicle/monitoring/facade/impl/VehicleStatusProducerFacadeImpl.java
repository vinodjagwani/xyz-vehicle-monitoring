package com.xyz.vehicle.monitoring.facade.impl;

import com.xyz.vehicle.monitoring.dto.CurrentVehicleStatusData;
import com.xyz.vehicle.monitoring.facade.VehicleStatusProducerFacade;
import com.xyz.vehicle.monitoring.service.VehicleStatusProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by vinodjagwani on 21/01/19.
 */
@Slf4j
@Service
public class VehicleStatusProducerFacadeImpl implements VehicleStatusProducerFacade {


    @Autowired
    private VehicleStatusProducerService vehicleStatusProducerService;


    @Override
    public void sendCurrentVehicleStatus(final CurrentVehicleStatusData data) {
        vehicleStatusProducerService.sendCurrentVehicleStatus(data);
    }


    @Scheduled(fixedRate = 63000)
    public void sendCurrentVehicleStatusInMin() {
        CurrentVehicleStatusData data = new CurrentVehicleStatusData();
        long id = ThreadLocalRandom.current().nextLong(15);
        for (long i = id; i < 15; i++) {
            data.setVehicleId(i);
            data.setCustomerId(i);
            data.setStatus(true);
            vehicleStatusProducerService.sendCurrentVehicleStatus(data);
        }
    }
}
