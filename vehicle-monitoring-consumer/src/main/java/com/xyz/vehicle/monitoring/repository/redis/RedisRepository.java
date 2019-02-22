package com.xyz.vehicle.monitoring.repository.redis;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@NoRepositoryBean
public interface RedisRepository<E, ID extends Serializable> {


    E findOne(final ID id);

    //void delete(final ID id);

    //List<E> findAll();

    void createOrUpdate(final E entity);

    //List<E> findAll(final List<Long> vehicleIds);

}
