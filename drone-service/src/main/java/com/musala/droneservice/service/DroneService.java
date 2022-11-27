package com.musala.droneservice.service;

import com.musala.droneservice.constant.DroneStateEnum;
import com.musala.droneservice.entity.Drone;
import com.musala.droneservice.repository.DroneRepository;
import com.musala.droneservice.request.DroneRequest;
import com.musala.droneservice.response.DroneBatteryResponse;
import com.musala.droneservice.response.DroneResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DroneService {

    final
    DroneRepository droneRepository;
    @Value("${drone.min-allowed-battery}")
    private Long minAllowedBattery;

    public DroneService(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    public DroneResponse registerDrone(MultipartFile image, DroneRequest registerDroneRequest) {

        Drone drone = new Drone();
        // drone.setImage();
        drone.setBatteryCapacity(registerDroneRequest.getBatteryCapacity());
        drone.setModel(registerDroneRequest.getModel().name());
        drone.setState(registerDroneRequest.getState().name());
        drone.setSerialNumber(registerDroneRequest.getSerialNumber());
        drone.setWeightLimit(registerDroneRequest.getWeightLimit());
        return new DroneResponse(droneRepository.save(drone));
    }

    // get drone battery capacity if drone exist, otherwise return -1
    public DroneBatteryResponse checkDroneBattery(String droneSerial) {
        return new DroneBatteryResponse(droneRepository.findById(droneSerial));
    }

    public List<DroneResponse> getAllAvailableDrones() {

        return  droneRepository.findAllByStateEqualsIgnoreCaseAndBatteryCapacityGreaterThan
                (DroneStateEnum.IDLE.name(), minAllowedBattery).stream()
                .map(DroneResponse::new).collect(Collectors.toList());

    }

}
