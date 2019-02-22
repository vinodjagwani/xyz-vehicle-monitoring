package com.xyz.vehicle.monitoring.facade;


import com.xyz.vehicle.monitoring.AbstractVehicleStatusTest;
import com.xyz.vehicle.monitoring.dto.CurrentVehicleStatusData;
import com.xyz.vehicle.monitoring.facade.impl.VehicleStatusProducerFacadeImpl;
import com.xyz.vehicle.monitoring.service.VehicleStatusProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by vinodjagwani on 21/01/19.
 */

@RunWith(MockitoJUnitRunner.class)
public class VehicleStatusProducerFacadeTest extends AbstractVehicleStatusTest {


    @Mock
    private VehicleStatusProducerService vehicleStatusProducerService;

    @InjectMocks
    private VehicleStatusProducerFacadeImpl vehicleStatusProducerFacade;


    @Test
    public void sendCurrentVehicleStatusTest() {
        doNothing().when(vehicleStatusProducerService).sendCurrentVehicleStatus(any(CurrentVehicleStatusData.class));
        final CurrentVehicleStatusData data = getCurrentVehicleStatusData();
        vehicleStatusProducerFacade.sendCurrentVehicleStatus(data);
        verify(vehicleStatusProducerService, times(1)).sendCurrentVehicleStatus(any(CurrentVehicleStatusData.class));
    }

}
