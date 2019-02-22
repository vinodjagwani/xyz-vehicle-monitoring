package com.xyz.vehicle.monitoring.listener;


import com.xyz.vehicle.monitoring.constant.Constants;
import com.xyz.vehicle.monitoring.dto.CurrentVehicleStatusData;
import com.xyz.vehicle.monitoring.entity.redis.CurrentVehicleStatusEntity;
import com.xyz.vehicle.monitoring.service.redis.CurrentVehicleStatusService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@Component
public class VehicleMonitorMessageListener {


    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @Autowired
    private CurrentVehicleStatusService currentVehicleStatusService;


    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = Constants.QUEUE_VEHICLE_STATUS, durable = "true"),
                    exchange = @Exchange(value = Constants.EXCHANGE_VEHICLE_STATUS, type = ExchangeTypes.FANOUT)))
    public void processVehicleStatusData(final CurrentVehicleStatusData data) {
        CurrentVehicleStatusEntity entity = getCurrentVehicleStatusEntity(data);
        currentVehicleStatusService.createOrUpdate(entity);
        messagingTemplate.convertAndSend(Constants.WEB_SOCKET_TOPIC, entity);
    }


    private CurrentVehicleStatusEntity getCurrentVehicleStatusEntity(final CurrentVehicleStatusData data) {
        CurrentVehicleStatusEntity entity = new CurrentVehicleStatusEntity();
        entity.setCustomerId(data.getCustomerId());
        entity.setStatus(data.isStatus());
        entity.setVehicleId(data.getVehicleId());
        return entity;
    }


}
