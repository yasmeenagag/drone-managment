package com.musala.medicationservice.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class LoadMedicationsToDroneRequest {

    @NotBlank
    private String droneSerial;
    @NotNull
    private List<String> medicationCodes ;

}
