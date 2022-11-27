package com.musala.droneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DroneServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DroneServiceApplication.class, args);
    }

}
