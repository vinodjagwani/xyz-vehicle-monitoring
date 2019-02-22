package com.xyz.vehicle.monitoring.facade;


import com.xyz.vehicle.monitoring.dto.CurrentVehicleStatusData;

/**
 * Created by vinodjagwani on 21/01/19.
 */

public interface VehicleStatusProducerFacade {

    void sendCurrentVehicleStatus(final CurrentVehicleStatusData data);
}
