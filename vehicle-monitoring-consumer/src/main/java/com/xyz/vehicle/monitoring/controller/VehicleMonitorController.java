package com.xyz.vehicle.monitoring.controller;


import com.querydsl.core.types.Predicate;
import com.xyz.vehicle.monitoring.entity.mysql.VehicleEntity;
import com.xyz.vehicle.monitoring.service.mysql.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@Slf4j
@RestController
@RequestMapping("/v1.0")
public class VehicleMonitorController {


    @Autowired
    private VehicleService vehicleService;


    @RequestMapping(value = "/vehicles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<?>> getAllVehicleStatus(@QuerydslPredicate(root = VehicleEntity.class) Predicate predicate, @SortDefault.SortDefaults
            ({@SortDefault(sort = "vehicleId", direction = Sort.Direction.DESC)}) Pageable pageable) {
        log.info("Get all vehicle status along with their customer info with: {} ", predicate);
        return new ResponseEntity<>(vehicleService.findAll(predicate, pageable), HttpStatus.OK);
    }
}
