package com.carmakemodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carmakemodel.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

	//jpa repo is by default annoted with repo so need to annotate again
	
	
}
