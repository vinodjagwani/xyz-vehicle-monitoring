package com.xyz.vehicle.monitoring.repository.mysql;


import com.xyz.vehicle.monitoring.entity.mysql.CustomerEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by vinodjagwani on 22/01/19.
 */
public interface CustomerRepository extends PagingAndSortingRepository<CustomerEntity, Long>, QuerydslPredicateExecutor<CustomerEntity> {
}
