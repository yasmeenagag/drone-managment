package com.musala.droneservice.repository;

import com.musala.droneservice.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, String> {

    Optional<Drone> findById(String droneSerial);

    List<Drone> findAllByStateEqualsIgnoreCaseAndBatteryCapacityGreaterThan(String DroneStateEnum, long batteryCapacity);

    List<Drone> findAllByBatteryCapacityLessThan(long batteryCapacity);

}
