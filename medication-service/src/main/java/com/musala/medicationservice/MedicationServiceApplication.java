package com.musala.medicationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.musala.medicationservice.feignclients")
@EnableEurekaClient
public class MedicationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicationServiceApplication.class, args);
	}

}
