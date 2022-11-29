package com.musala.medicationservice.service;

import com.musala.medicationservice.entity.Medication;
import com.musala.medicationservice.feignclients.DroneFeignClient;
import com.musala.medicationservice.repository.MedicationRepository;
import com.musala.medicationservice.request.LoadMedicationsToDroneRequest;
import com.musala.medicationservice.response.DroneResponse;
import com.musala.medicationservice.response.LoadMedicationsToDroneResponse;
import com.musala.medicationservice.response.MedicationResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationService {

    final MedicationRepository medicationRepository;

    final DroneFeignClient droneFeignClient;

    final CommonService commonService;

    public MedicationService(DroneFeignClient droneFeignClient, MedicationRepository medicationRepository, CommonService commonService) {
        this.droneFeignClient = droneFeignClient;
        this.medicationRepository = medicationRepository;
        this.commonService = commonService;
    }


    public LoadMedicationsToDroneResponse loadMedicationsToDrone(LoadMedicationsToDroneRequest loadMedicationsToDroneRequest) {
        DroneResponse droneBySerial = commonService.getDroneBySerial(loadMedicationsToDroneRequest.getDroneSerial());
        if (droneBySerial != null && droneBySerial.getSerialNumber() != null) {
            List<String> medicationCodes = loadMedicationsToDroneRequest.getMedicationCodes();
            Long medicationsTotalWeight = medicationRepository.medicationsWeight(medicationCodes);

            for (String medicationCode : medicationCodes) {
                if (!medicationRepository.findById(medicationCode).isPresent()) {
                    return new LoadMedicationsToDroneResponse("Invalid Medication Code ::" + medicationCode);
                }
            }
            if (medicationsTotalWeight > droneBySerial.getWeightLimit()) {
                return new LoadMedicationsToDroneResponse("Cannot Load medications to drone :: max weight reached!");
            }
            for (String medicationCode : medicationCodes) {
                Medication medication = medicationRepository.findById(medicationCode).get();
                medication.setDroneSerialNumber(droneBySerial.getSerialNumber());
                medicationRepository.save(medication);
            }

        } else
            return new LoadMedicationsToDroneResponse("Drone does not exist");
        return new LoadMedicationsToDroneResponse(true);
    }

    public List<MedicationResponse> getDroneMedications(String droneSerial) {
        return medicationRepository.findAllByDroneSerialNumber(droneSerial).stream()
                .map(e -> {
                    return new MedicationResponse(e);
                }).collect(Collectors.toList());

    }

}
