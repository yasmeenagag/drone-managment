package com.musala.droneservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drone")
@Data
public class Drone {

    @Id
    @Column(name= "serial_number" )
    private String serialNumber;

    @Column(name= "model" )
    private String model;

    @Column(name= "weight_limit" )
    private Long weightLimit;

    @Column(name= "battery_capacity" )
    private Long batteryCapacity;

    @Column(name= "state " )
    private String state ;


}
