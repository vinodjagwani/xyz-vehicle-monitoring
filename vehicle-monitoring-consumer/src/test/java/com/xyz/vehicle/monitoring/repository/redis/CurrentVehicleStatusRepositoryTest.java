package com.xyz.vehicle.monitoring.repository.redis;


import com.xyz.vehicle.monitoring.entity.redis.CurrentVehicleStatusEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@SpringBootTest()
@RunWith(SpringRunner.class)
public class CurrentVehicleStatusRepositoryTest {


    @Autowired
    private RedisTemplate<Long, Object> redisTemplate;

    @Autowired
    private CurrentVehicleStatusRepository currentVehicleStatusRepository;


    @Test
    public void createOrUpdateTest() {
        final CurrentVehicleStatusEntity entity = getCurrentVehicleStatusEntity();
        currentVehicleStatusRepository.createOrUpdate(entity);
        Assert.assertNotNull(redisTemplate.opsForValue().get(entity.getVehicleId()));
        redisTemplate.delete(entity.getVehicleId());
    }

    private CurrentVehicleStatusEntity getCurrentVehicleStatusEntity() {
        CurrentVehicleStatusEntity entity = new CurrentVehicleStatusEntity();
        entity.setCustomerId(1L);
        entity.setVehicleId(1L);
        entity.setStatus(true);
        return entity;
    }

}
