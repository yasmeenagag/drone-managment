package com.musala.medicationservice.controller;

import com.musala.medicationservice.request.LoadMedicationsToDroneRequest;
import com.musala.medicationservice.response.BaseResponse;
import com.musala.medicationservice.response.LoadMedicationsToDroneResponse;
import com.musala.medicationservice.response.MedicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.musala.medicationservice.service.MedicationService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/medication")
public class MedicationController {

    @Autowired
    MedicationService medicationService;

    @PutMapping
    public ResponseEntity<BaseResponse<LoadMedicationsToDroneResponse>> loadMedicationsToDrone(@Valid @RequestBody LoadMedicationsToDroneRequest loadMedicationsToDroneRequest) {
        LoadMedicationsToDroneResponse loadMedicationsToDroneResponse = medicationService.loadMedicationsToDrone(loadMedicationsToDroneRequest);
        if (loadMedicationsToDroneResponse.getError() != null) {
            Map<String, String> errors = new HashMap<>();
            errors.put("Error", loadMedicationsToDroneResponse.getError());
            return new ResponseEntity<>(new BaseResponse<>(null, errors), HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(new BaseResponse<>(loadMedicationsToDroneResponse, null), HttpStatus.CREATED);

    }

    @GetMapping("/drone/{droneSerial}")
    public ResponseEntity<BaseResponse<List<MedicationResponse>>> getDroneMedications(@PathVariable String droneSerial) {
        List<MedicationResponse> medicationResponses = medicationService.getDroneMedications(droneSerial);
        return new ResponseEntity<>(new BaseResponse<>(medicationResponses, null), HttpStatus.OK);

    }

}
