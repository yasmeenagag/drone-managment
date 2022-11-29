package com.musala.droneservice.response;

import lombok.Data;

@Data
public class MedicationResponse {
    private String droneSerialNumber;
    private String name;
    private long weight;
    private String image;
    private String code;
}
