/**
 * 
 */
package com.infogain.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infogain.entity.Car;
import com.infogain.service.CarService;

/**
 * @author abhishek-singhal
 *
 */

@Controller
@RequestMapping(path="/car")
public class CarController {

	private CarService carService;
	
	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@GetMapping(path="/list/{id}")
	public String listAll(@PathVariable("id") String id, Model model) {
		List<Car> carList = carService.listCar(id);
		model.addAttribute("carList", carList);
		model.addAttribute("customerId", id);
		return "car/listAll";
	}
	
	@GetMapping(path="/add/{id}")
	public String addCarForm(@PathVariable("id") String id, Model model) {
		Car theCar = new Car();
		model.addAttribute("car", theCar);
		model.addAttribute("customerId", id);
		return "car/addCar";
	}
	
	@PostMapping(path="/add/{id}")
	public String addCar(@PathVariable("id") String id, @Valid @ModelAttribute("car") Car theCar, BindingResult theBindingResult, Model model) {
		if(theBindingResult.hasErrors()) {
			model.addAttribute("customerId", id);
			//model.addAttribute("car", new Car());
			return "car/addCar";
		}else {
			carService.addCar(id, theCar);
			return "redirect:/customer/"+id;
		}
	}
}
