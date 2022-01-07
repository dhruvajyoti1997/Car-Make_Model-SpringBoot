package com.carmakemodel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.carmakemodel.entity.Car;
import com.carmakemodel.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService servicedetails;
	@RequestMapping(path = "/processform", method = RequestMethod.GET)
	public String handleCarFormDetails( Model model) {
		
		model.addAttribute("carList" , servicedetails.getCarDetails());
		return "carDetails";
		
	}
	
	@RequestMapping(path = "/processform/AddCar", method = RequestMethod.GET)
	public String addCarDetails(Model model) {
				
		Car car = new Car();
		
		model.addAttribute("car",car);
		
		return "AddCarDetails";
		
	}
	
	@PostMapping("/processform")
	public String saveCarDetails(@Valid @ModelAttribute("car") Car car , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return"AddCarDetails";
		}
		
		servicedetails.saveCarDetails(car);
		return "redirect:/processform";
		
	}
	
	@RequestMapping(path ="/processform/edit/{id}" , method = RequestMethod.GET)
	public String editVehicleDetails(@PathVariable Long id, Model model) {
	
		model.addAttribute("editdetails", servicedetails.getCarById(id));
		return "editDetails";
		
	}
	
	@PostMapping("/processform/{id}")
	public String updateVehicleById(@PathVariable Long id,
			@ModelAttribute("car") Car car,
			Model model) {
		
		// get student from database by id
		Car existingCar = servicedetails.getCarById(id);
		existingCar.setId(id);
		existingCar.setMake(car.getMake());
		existingCar.setModel(car.getModel());
		
		// save updated student object
		servicedetails.updateVehiclebyId(existingCar);
		return "redirect:/processform"; 
		}
}
