package com.xyz.vehicle.monitoring.repository.mysql;


import com.xyz.vehicle.monitoring.entity.mysql.CustomerEntity;
import com.xyz.vehicle.monitoring.entity.mysql.VehicleEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.Optional;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class VehicleRepositoryTest {


    @Autowired
    private VehicleRepository vehicleRepository;


    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void createVehicleTest() {
        final Optional<CustomerEntity> customerEntity = customerRepository.findById(1000L);
        final VehicleEntity entity = getVehicleEntity();
        entity.setCustomerEntity(customerEntity.get());
        vehicleRepository.save(entity);
        Assert.assertNotNull(vehicleRepository.findById(entity.getVehicleId()));
    }

    private VehicleEntity getVehicleEntity() {
        VehicleEntity entity = new VehicleEntity();
        entity.setVehicleId(100L);
        entity.setRegistrationNo("ABCD");
        entity.setCreatedTime(new Date());
        entity.setStatus(true);
        return entity;
    }


}
