package com.xyz.vehicle.monitoring.entity.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@Data
@RedisHash
@NoArgsConstructor
@AllArgsConstructor
public class CurrentVehicleStatusEntity implements Serializable {


    private static final long serialVersionUID = 4497026996490363658L;

    private Long vehicleId;

    private Long customerId;

    private boolean status;


}
