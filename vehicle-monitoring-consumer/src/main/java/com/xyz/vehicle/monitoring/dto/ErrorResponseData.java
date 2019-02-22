package com.xyz.vehicle.monitoring.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@Data
public class ErrorResponseData {

    private String code;

    private String message;

    private List<ErrorFieldData> errors = new ArrayList<>();

}
