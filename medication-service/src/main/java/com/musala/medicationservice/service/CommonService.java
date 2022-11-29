package com.musala.medicationservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musala.medicationservice.feignclients.DroneFeignClient;
import com.musala.medicationservice.response.BaseResponse;
import com.musala.medicationservice.response.DroneResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    Logger logger = LoggerFactory.getLogger(CommonService.class);
    long count = 1;

    @Autowired
    DroneFeignClient droneFeignClient;

    @CircuitBreaker(name = "droneSerivce", fallbackMethod = "fallbackGetDroneBySerial")
    public DroneResponse getDroneBySerial(String droneSerial) {
        logger.info("count = " + count);
        count++;
        ResponseEntity<BaseResponse> droneFeignClientBySerial = droneFeignClient.getBySerial(droneSerial);
        BaseResponse baseResponse = droneFeignClientBySerial.getBody();
        if (baseResponse != null) {
            ObjectMapper mapper= new ObjectMapper();
            return mapper.convertValue(baseResponse.getBusinessResponse(), DroneResponse.class);
        }
        return null;
    }

    public DroneResponse fallbackGetDroneBySerial(String droneSerial, Throwable th) {
        logger.error("Error = " + th);
        return new DroneResponse();
    }

}
