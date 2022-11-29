package com.musala.medicationservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medication")
@Data
public class Medication {

	@Column(name = "drone_serail_number")
	private String  droneSerialNumber;

	@Column(name = "name")
	private String  name;

	@Column(name = "weight")
	private long  weight;

	@Column(name = "image")
	private String  image;

	@Id
	@Column(name = "code")
	private String  code;



}
