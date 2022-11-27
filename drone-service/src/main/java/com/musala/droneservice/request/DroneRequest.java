package com.musala.droneservice.request;


import com.musala.droneservice.constant.DroneModelEnum;
import com.musala.droneservice.constant.DroneStateEnum;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class DroneRequest {

    @NotBlank(message = "serialNumber is mandatory")
    @Size(min = 1, max = 100, message = "serialNumber must be less then 100 char")
    private String serialNumber;

    @NotNull(message = "model is mandatory")
    private DroneModelEnum model;

    @NotNull(message = "message is mandatory")
    @Min(1)
    @Max(500)
    private Long weightLimit;

    @NotNull(message = "batteryCapacity is mandatory")
    @Min(1)
    @Max(100)
    private Long batteryCapacity;

    @NotNull(message = "state is mandatory")
    private DroneStateEnum state;


}
