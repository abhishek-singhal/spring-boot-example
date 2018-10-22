/**
 * 
 */
package com.infogain.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infogain.entity.CustomerDetail;
import com.infogain.service.CustomerDetailService;

/**
 * @author abhishek-singhal
 *
 */

@Controller
@RequestMapping(path="/customerDetail")
public class CustomerDetailController {

private CustomerDetailService customerDetailService;
	
	@Autowired
	public void setCustomerDetailService(CustomerDetailService customerDetailService) {
		this.customerDetailService = customerDetailService;
	}

	@RequestMapping(path="/update/{id}", method=RequestMethod.GET)
	public String updateCustomerDetailForm(@PathVariable("id") String id, Model model) {
		CustomerDetail theCustomerDetail = customerDetailService.findCustomerDetail(id);
		if(theCustomerDetail == null) {
			theCustomerDetail = new CustomerDetail();
		}
		model.addAttribute("customerDetail", theCustomerDetail);
		model.addAttribute("customerId", id);
		return "customerDetail/updateForm";
	}
	
	@RequestMapping(path="/update/{id}", method=RequestMethod.POST)
	public String updateCustomerDetail(@PathVariable("id") String id, @Valid @ModelAttribute("customerDetail") CustomerDetail theCustomerDetail, BindingResult theBindingResult, Model model) {
		if(theBindingResult.hasErrors()) {
//			theCustomerDetail = customerDetailService.findCustomerDetail(id);
//			if(theCustomerDetail == null) {
//				theCustomerDetail = new CustomerDetail();
//			}
//			model.addAttribute("customerDetail", theCustomerDetail);
			model.addAttribute("customerId", id);
			return "customerDetail/updateForm";
		}else {
			customerDetailService.updateCustomerDetail(id, theCustomerDetail);
			return "redirect:/customer/"+id;
		}
		
	}
	
	@RequestMapping(path="/delete/{id}", method=RequestMethod.DELETE)
	public String deleteCustomerDetail(@PathVariable("id") String id) {
		customerDetailService.deleteCustomerDetail(id);
		return "redirect:/customer/"+id;
	}
}
