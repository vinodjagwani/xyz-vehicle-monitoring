package com.xyz.vehicle.monitoring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorFieldData implements Serializable {

    private String code;

    private String param;

    private String message;
}
