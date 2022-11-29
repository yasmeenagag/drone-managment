package com.musala.droneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@EnableFeignClients("com.musala.droneservice.feignclient")
public class DroneServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DroneServiceApplication.class, args);
    }

}
