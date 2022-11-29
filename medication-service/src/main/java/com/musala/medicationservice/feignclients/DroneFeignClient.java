package com.musala.medicationservice.feignclients;

import com.musala.medicationservice.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "api-gateway", path = "/drone-service/api/drone")
public interface DroneFeignClient {

    @GetMapping(value = "/{droneSerial}")
    ResponseEntity<BaseResponse> getBySerial(@PathVariable String droneSerial);

}
