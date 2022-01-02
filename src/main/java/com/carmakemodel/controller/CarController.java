package com.carmakemodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String saveCarDetails(@ModelAttribute("car") Car car) {
		
		servicedetails.saveCarDetails(car);
		return "redirect:/processform";
		
	}
}
