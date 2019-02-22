package com.xyz.vehicle.monitoring;

import com.xyz.vehicle.monitoring.dto.CurrentVehicleStatusData;

public class AbstractVehicleStatusTest {


    public CurrentVehicleStatusData getCurrentVehicleStatusData() {
        CurrentVehicleStatusData data = new CurrentVehicleStatusData();
        data.setCustomerId(1L);
        data.setVehicleId(1L);
        data.setStatus(true);
        return data;
    }
}
