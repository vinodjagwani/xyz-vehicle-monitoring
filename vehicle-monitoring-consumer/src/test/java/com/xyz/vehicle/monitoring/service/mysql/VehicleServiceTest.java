package com.xyz.vehicle.monitoring.service.mysql;

import com.querydsl.core.types.Predicate;
import com.xyz.vehicle.monitoring.entity.mysql.QVehicleEntity;
import com.xyz.vehicle.monitoring.entity.mysql.VehicleEntity;
import com.xyz.vehicle.monitoring.repository.mysql.VehicleRepository;
import com.xyz.vehicle.monitoring.service.mysql.impl.VehicleServiceImpl;
import com.xyz.vehicle.monitoring.service.redis.CurrentVehicleStatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {


    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private CurrentVehicleStatusService currentVehicleStatusService;

    @InjectMocks
    private VehicleServiceImpl vehicleService;


    @Test
    public void sendCurrentVehicleStatusTest() {
        final Predicate predicate = QVehicleEntity.vehicleEntity.vehicleId.eq(100L);
        PageRequest page = PageRequest.of(0, 1);
        final VehicleEntity vehicleEntity1 = getVehicleEntity();
        final VehicleEntity vehicleEntity2 = getVehicleEntity();
        final List<VehicleEntity> vehicleEntityList = Arrays.asList(vehicleEntity1, vehicleEntity2);
        when(vehicleRepository.findAll(any(Predicate.class), any(PageRequest.class))).thenReturn(new PageImpl(vehicleEntityList));
        vehicleService.findAll(predicate, page);
        verify(vehicleRepository, times(1)).findAll(predicate, page);
        verify(currentVehicleStatusService, times(2)).findOne(any(Long.class));

    }

    private VehicleEntity getVehicleEntity() {
        VehicleEntity entity = new VehicleEntity();
        entity.setVehicleId(100L);
        entity.setCreatedTime(new Date());
        entity.setStatus(true);
        return entity;
    }

}
