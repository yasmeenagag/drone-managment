package com.musala.medicationservice.response;

import com.musala.medicationservice.entity.Medication;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class MedicationResponse {
    private String droneSerialNumber;
    private String name;
    private long weight;
    private String image;
    private String code;

    public MedicationResponse(Medication e) {
      this.code=e.getCode();
      this.name=e.getName();
      this.weight=e.getWeight();
      this.image=e.getImage();
      this.droneSerialNumber=e.getDroneSerialNumber();
    }

}
