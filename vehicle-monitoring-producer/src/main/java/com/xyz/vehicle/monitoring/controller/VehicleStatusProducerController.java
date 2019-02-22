package com.xyz.vehicle.monitoring.controller;


import com.xyz.vehicle.monitoring.dto.CurrentVehicleStatusData;
import com.xyz.vehicle.monitoring.facade.VehicleStatusProducerFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by vinodjagwani on 21/01/19.
 */
@Slf4j
@RestController
@RequestMapping("/v1.0/vehicles")
public class VehicleStatusProducerController {


    @Autowired
    private VehicleStatusProducerFacade vehicleStatusProducerFacade;


    @RequestMapping(value = "/status/send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> sendCurrentVehicleStatus(@Valid @RequestBody final CurrentVehicleStatusData data) {
        log.info("Vehicle status for customer {}", data);
        vehicleStatusProducerFacade.sendCurrentVehicleStatus(data);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
