package com.xyz.vehicle.monitoring.service.mysql;

import com.querydsl.core.types.Predicate;
import com.xyz.vehicle.monitoring.entity.mysql.VehicleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by vinodjagwani on 22/01/19.
 */
public interface VehicleService {


    Page<VehicleEntity> findAll(final Predicate predicate, final Pageable pageable);
}
