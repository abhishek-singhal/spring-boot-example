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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infogain.entity.Car;
import com.infogain.entity.Customer;
import com.infogain.service.CarService;
import com.infogain.service.CustomerService;

/**
 * @author abhishek-singhal
 *
 */

@Controller
@RequestMapping(path="/customer")
public class CustomerController {
	private CustomerService customerService;
	private CarService carService;
	
	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(path="/all", method=RequestMethod.GET)
	public String listAll(Model model) {
		 List<Customer> customers = customerService.listAll();
		 model.addAttribute("customers", customers);
		 return "customerList";
	}
	
	@RequestMapping(path="/create", method=RequestMethod.GET)
	public String createCustomerForm(Model model) {
		Customer newCustomer = new Customer();
		model.addAttribute("customer", newCustomer);
		return "createCustomer";
	}
	
	@RequestMapping(path="/create", method=RequestMethod.POST)
	public String createCustomer(@Valid @ModelAttribute("customer") Customer newCustomer, BindingResult theBindingResult, Model model) {
		System.out.println(newCustomer.toString());
		if(theBindingResult.hasErrors()) {
			return "createCustomer";
		}else {
			model.addAttribute("customer", newCustomer);
			customerService.saveCustomer(newCustomer);
			return "savedCustomer";
		}
	}
	
	@RequestMapping(path="/update/{id}", method=RequestMethod.GET)
	public String updateCustomerForm(@PathVariable("id") String id, Model model) {
		Customer theCustomer = customerService.findCustomerById(id);
		model.addAttribute("customer", theCustomer);
		return "updateCustomer";
	}
	
	@RequestMapping(path="/update", method=RequestMethod.PUT)
	public String updateCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult, Model model) {
		if(theBindingResult.hasErrors()) {
			return "updateCustomer";
		}else {
			customerService.saveCustomer(theCustomer);
			model.addAttribute("customer", theCustomer);
			return "updatedCustomer";
		}
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public String getCustomer(@PathVariable("id") String id, Model model, @RequestParam(name="action", required=false) String button) {
		Customer theCustomer = customerService.findCustomerById(id);
		model.addAttribute("customer", theCustomer);
		model.addAttribute("customerDetail", false);
		model.addAttribute("car", false);
		if(button != null && button.equals("Show Customer Details")) {
			model.addAttribute("customerDetail", true);
		}
		if(button != null && button.equals("Show Cars")) {
			List<Car> carList = carService.listCar(id);
			model.addAttribute("car", true);
			model.addAttribute("carList", carList);
		}
		return "showCustomer";
	}
	
	@RequestMapping(path="/delete/{id}", method=RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable("id") String id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/all";
	}
	
	@RequestMapping(path="/search", method=RequestMethod.GET)
	public String searchForm() {
		return "searchCustomerForm";
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public String searchCustomer(@RequestParam("action") String button,@RequestParam("input") String input, Model model) {
		if(button.equals("Search By Name")) {
			List<Customer> customerList= customerService.findByName(input);
			model.addAttribute("customers", customerList);
		}else if(button.equals("Search By Email")) {
			List<Customer> customerList= customerService.findByEmail(input);
			model.addAttribute("customers", customerList);
		}
		return "customerList";
	}
}
