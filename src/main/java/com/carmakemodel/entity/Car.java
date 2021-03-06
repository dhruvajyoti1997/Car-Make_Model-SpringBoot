package com.carmakemodel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity

@Table(name = "car")
public class Car {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "car_make" , nullable = false)
	@NotBlank(message = "Enter Car Make")
	private String make;
	@Column(name = "car_model", nullable = false)
	@NotBlank(message = "Enter Car Model")
	@Length(min = 2, message = "Model should be minimum 4 characters")
	private String model;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Car(Long id, String make, String model) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + "]";
	}
	
}
