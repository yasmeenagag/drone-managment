package com.musala.medicationservice.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class LoadMedicationsToDroneResponse {
    @JsonIgnore
    private String error;
    private boolean isSuccess;

    public LoadMedicationsToDroneResponse(String error) {
        this.error=error;
    }
    public LoadMedicationsToDroneResponse(boolean isSuccess) {
        this.isSuccess=isSuccess;
    }

}
