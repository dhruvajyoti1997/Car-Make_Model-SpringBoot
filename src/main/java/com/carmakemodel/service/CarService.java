package com.carmakemodel.service;

import java.util.List;

import com.carmakemodel.entity.Car;
import com.carmakemodel.repository.CarRepository;

public interface CarService {

	//we make the service layer as loosly coupled for the dependency injection
	//we had used interface
	
  List<Car> getCarDetails ();
  
  public default  Car saveCarDetails(Car car) {
	// TODO Auto-generated method stub
	return car;
}
  public default Car updateCarDetails(Car car ) {
	  return car; 
  }
  
  Car getCarById(Long id);
  
  Car updateVehiclebyId(Car car);
  
}
