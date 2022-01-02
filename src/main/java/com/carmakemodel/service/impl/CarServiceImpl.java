package com.carmakemodel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmakemodel.entity.Car;
import com.carmakemodel.repository.CarRepository;
import com.carmakemodel.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepo; //to access the car repository
	//we will use the constructor injetion
	
	public CarServiceImpl(CarRepository carRepo) {
		super();
		this.carRepo = carRepo;
	}
	@Override
	public List<Car> getCarDetails() {
		// TODO Auto-generated method stub
		return carRepo.findAll();
	}
	@Override
	public Car saveCarDetails(Car car) {
		// TODO Auto-generated method stub
		return carRepo.save(car);
	}
	

	

	
	

}
