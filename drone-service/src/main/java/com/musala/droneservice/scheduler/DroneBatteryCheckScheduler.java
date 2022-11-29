package com.musala.droneservice.scheduler;

import com.musala.droneservice.service.DroneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DroneBatteryCheckScheduler {


    Logger logger = LoggerFactory.getLogger(DroneBatteryCheckScheduler.class);

    private final DroneService droneService;

    public DroneBatteryCheckScheduler(DroneService droneService) {
        this.droneService = droneService;
    }

    @Scheduled(cron = "${every.minute.cron.expression}")
    public void checkLowBatteryDrones() {
        logger.info("Current time is :: " + LocalDateTime.now());
        droneService.getAllLowBatteryDrones().forEach(
                droneResponse -> {
                    logger.info("Drone with Serial :: "+ droneResponse.getSerialNumber() +" has low battery capacity  ::" + droneResponse.getBatteryCapacity());
                }
        );
    }
}
