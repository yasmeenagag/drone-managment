package com.musala.droneservice.response;

import com.musala.droneservice.entity.Drone;
import lombok.Data;

import java.util.Optional;

@Data
public class DroneBatteryResponse {

    private Long batteryCapacity;

    public DroneBatteryResponse(Optional<Drone> droneOptional) {
        if (droneOptional.isPresent())
            this.batteryCapacity = droneOptional.get().getBatteryCapacity();
        else this.batteryCapacity = -1L;

    }

}
