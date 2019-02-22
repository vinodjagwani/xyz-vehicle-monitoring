package com.xyz.vehicle.monitoring.service;


import com.xyz.vehicle.monitoring.dto.CurrentVehicleStatusData;

/**
 * Created by vinodjagwani on 21/01/19.
 */
public interface VehicleStatusProducerService {

    void sendCurrentVehicleStatus(final CurrentVehicleStatusData data);

}
