package com.xyz.vehicle.monitoring.service.impl;

import com.xyz.vehicle.monitoring.constant.Constants;
import com.xyz.vehicle.monitoring.dto.CurrentVehicleStatusData;
import com.xyz.vehicle.monitoring.service.VehicleStatusProducerService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vinodjagwani on 21/01/19.
 */
@Service
public class VehicleStatusProducerServiceImpl implements VehicleStatusProducerService {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void sendCurrentVehicleStatus(final CurrentVehicleStatusData data) {
        rabbitTemplate.convertAndSend(Constants.QUEUE_VEHICLE_STATUS, data);
    }

}
