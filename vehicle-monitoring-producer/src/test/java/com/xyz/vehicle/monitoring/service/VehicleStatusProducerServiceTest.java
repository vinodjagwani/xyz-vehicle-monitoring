package com.xyz.vehicle.monitoring.service;


import com.xyz.vehicle.monitoring.AbstractVehicleStatusTest;
import com.xyz.vehicle.monitoring.dto.CurrentVehicleStatusData;
import com.xyz.vehicle.monitoring.service.impl.VehicleStatusProducerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class VehicleStatusProducerServiceTest extends AbstractVehicleStatusTest {


    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private VehicleStatusProducerServiceImpl vehicleStatusProducerService;


    @Test
    public void sendCurrentVehicleStatusTest() {
        doNothing().when(rabbitTemplate).convertAndSend(any(String.class), any(CurrentVehicleStatusData.class));
        final CurrentVehicleStatusData data = getCurrentVehicleStatusData();
        vehicleStatusProducerService.sendCurrentVehicleStatus(data);
        verify(rabbitTemplate, times(1)).convertAndSend(any(String.class), any(CurrentVehicleStatusData.class));
    }

}
