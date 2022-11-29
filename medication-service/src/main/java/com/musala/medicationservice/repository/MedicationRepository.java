package com.musala.medicationservice.repository;

import com.musala.medicationservice.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, String> {

    @Override
    Optional<Medication> findById(String code);

    @Query(nativeQuery = true, value = "select sum(weight) from medication where code in (:medicationsCodes) ")
    Long medicationsWeight(@Param("medicationsCodes") List<String> medicationsCodes);


    List<Medication> findAllByDroneSerialNumber(String droneSerial);
    

    

}

