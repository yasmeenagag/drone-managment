package com.musala.medicationservice.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Map;

@Data
public class DroneResponse {

    private String serialNumber;
    private String model;
    private Long weightLimit;
    private Long batteryCapacity;
    private String state;
    @JsonIgnore
    private Map errors;

}
