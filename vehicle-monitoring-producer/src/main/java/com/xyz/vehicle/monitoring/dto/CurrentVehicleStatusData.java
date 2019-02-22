package com.xyz.vehicle.monitoring.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by vinodjagwani on 21/01/19.
 */
@Data
public class CurrentVehicleStatusData implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long vehicleId;

    @NotNull
    private Long customerId;

    @NotNull
    private Boolean status;

}
