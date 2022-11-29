package com.musala.droneservice.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.musala.droneservice.entity.Drone;
import lombok.Data;

@Data
public class DroneResponse {


    private String serialNumber;
    private String model;
    private Long weightLimit;
    private Long batteryCapacity;
    private String state ;
    @JsonIgnore
    private String error;

    public DroneResponse(Drone drone) {
        this.serialNumber=drone.getSerialNumber();
        this.model=drone.getModel();
        this.weightLimit= drone.getWeightLimit();
        this.batteryCapacity=drone.getBatteryCapacity();
        this.state=drone.getState();

    }
    public DroneResponse(String error) {
        this.error=error;
    }
}
