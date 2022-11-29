package com.musala.droneservice.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DroneMedicationsResponse {
    @JsonIgnore
    private String error;
    private List<MedicationResponse> medicationResponseList;

    public DroneMedicationsResponse(List<MedicationResponse> medicationResponseList) {
        this.medicationResponseList = medicationResponseList;
    }

    public DroneMedicationsResponse(String error) {
        this.error = error;
    }

}
