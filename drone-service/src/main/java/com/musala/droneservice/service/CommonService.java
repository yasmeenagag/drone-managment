package com.musala.droneservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musala.droneservice.feignclient.MedicationFeignClient;
import com.musala.droneservice.response.BaseResponse;
import com.musala.droneservice.response.DroneMedicationsResponse;
import com.musala.droneservice.response.MedicationResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {

    Logger logger = LoggerFactory.getLogger(CommonService.class);
    long count = 1;

    final
    MedicationFeignClient medicationFeignClient;

    public CommonService(MedicationFeignClient medicationFeignClient) {
        this.medicationFeignClient = medicationFeignClient;
    }

    @CircuitBreaker(name = "medicationService", fallbackMethod = "fallbackGetMedicationsByDroneSerial")
    public DroneMedicationsResponse getMedicationsByDroneSerial(String droneSerial) {
        logger.info("count = " + count);
        count++;
        ResponseEntity<BaseResponse> medicationsByDrone = medicationFeignClient.getMedicationsByDrone(droneSerial);
        BaseResponse baseResponse = medicationsByDrone.getBody();
        if (baseResponse != null) {
            ObjectMapper mapper= new ObjectMapper();

            List<MedicationResponse> medicationResponseList = mapper.convertValue(
                    baseResponse.getBusinessResponse(),
                    new TypeReference<List<MedicationResponse>>() { });
            return new DroneMedicationsResponse(medicationResponseList);
        }
        return null;
    }

    public DroneMedicationsResponse fallbackGetMedicationsByDroneSerial(String droneSerial, Throwable th) {
        logger.error("Error = " + th);
        return new DroneMedicationsResponse();
    }

}
