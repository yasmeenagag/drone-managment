package com.musala.droneservice.feignclient;

import com.musala.droneservice.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "api-gateway", path = "/medication-service/api/medication")
public interface MedicationFeignClient {

    @GetMapping(value = "/drone/{droneSerial}")
    ResponseEntity<BaseResponse> getMedicationsByDrone(@PathVariable String droneSerial);

}
