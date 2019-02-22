package com.xyz.vehicle.monitoring.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@Data
public class CurrentVehicleStatusData implements Serializable {

    private static final long serialVersionUID = 4297020996490362658L;

    private Long vehicleId;

    private Long customerId;

    private boolean status;

}
