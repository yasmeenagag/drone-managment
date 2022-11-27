package com.musala.droneservice.controller;

import com.musala.droneservice.request.DroneRequest;
import com.musala.droneservice.response.AvailableDroneResponse;
import com.musala.droneservice.response.BaseResponse;
import com.musala.droneservice.response.DroneBatteryResponse;
import com.musala.droneservice.response.DroneResponse;
import com.musala.droneservice.service.DroneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/drone")
@Validated
public class DroneController {

    final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }


    @PostMapping
    public ResponseEntity<BaseResponse<DroneResponse>> registerDrone(@Valid @RequestBody DroneRequest registerDroneRequest) {
        return new ResponseEntity<>(new BaseResponse<>(droneService.registerDrone(null, registerDroneRequest), null), HttpStatus.CREATED);

    }

    @GetMapping("/battery/{droneSerial}")
    public ResponseEntity<BaseResponse<DroneBatteryResponse>> checkDroneBattery(@PathVariable String droneSerial) {
        DroneBatteryResponse droneBatteryResponse = droneService.checkDroneBattery(droneSerial);
        if (droneBatteryResponse.getBatteryCapacity()==-1) {
          return  new ResponseEntity<>(new BaseResponse<>(null, null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new BaseResponse<>(droneBatteryResponse, null), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<BaseResponse<AvailableDroneResponse>> getAllAvailableDrones() {
        List<DroneResponse> availableDrones = droneService.getAllAvailableDrones();
        return new ResponseEntity<>(new BaseResponse<>(new AvailableDroneResponse(availableDrones), null), HttpStatus.OK);
    }

}
