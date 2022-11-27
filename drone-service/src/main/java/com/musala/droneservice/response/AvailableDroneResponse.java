package com.musala.droneservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AvailableDroneResponse {
    List<DroneResponse> availableDrones;

}
