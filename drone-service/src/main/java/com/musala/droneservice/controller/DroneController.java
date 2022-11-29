package com.musala.droneservice.controller;

import com.musala.droneservice.request.DroneRequest;
import com.musala.droneservice.response.*;
import com.musala.droneservice.service.DroneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (droneBatteryResponse.getBatteryCapacity() == -1) {
            return new ResponseEntity<>(new BaseResponse<>(null, null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new BaseResponse<>(droneBatteryResponse, null), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<BaseResponse<AvailableDroneResponse>> getAllAvailableDrones() {
        List<DroneResponse> availableDrones = droneService.getAllAvailableDrones();
        return new ResponseEntity<>(new BaseResponse<>(new AvailableDroneResponse(availableDrones), null), HttpStatus.OK);
    }

    @GetMapping("/{droneSerial}")
    public ResponseEntity<BaseResponse<DroneResponse>> checkDroneAvailabilityForLoading(@PathVariable String droneSerial) {
        DroneResponse droneResponse = droneService.checkDroneAvailabilityForLoading(droneSerial);
        if (droneResponse != null) {
            if (droneResponse.getError() == null)
                return new ResponseEntity<>(new BaseResponse<>(droneResponse, null), HttpStatus.OK);
            else {
                Map<String, String> errors = new HashMap<>();
                errors.put("Error", droneResponse.getError());
                return new ResponseEntity<>(new BaseResponse<>(null, errors), HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(new BaseResponse<>(null, null), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{droneSerial}/medication")
    public ResponseEntity<BaseResponse<DroneMedicationsResponse>> getDroneMedications(@PathVariable String droneSerial) {
        DroneMedicationsResponse droneMedicationsResponse = droneService.getDroneMedications(droneSerial);
        if (droneMedicationsResponse != null) {
            if (droneMedicationsResponse.getError() == null)
                return new ResponseEntity<>(new BaseResponse<>(droneMedicationsResponse, null), HttpStatus.OK);
            else {
                Map<String, String> errors = new HashMap<>();
                errors.put("Error", droneMedicationsResponse.getError());
                return new ResponseEntity<>(new BaseResponse<>(null, errors), HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(new BaseResponse<>(null, null), HttpStatus.NOT_FOUND);
        }

    }


}
