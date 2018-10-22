/**
 * 
 */
package com.infogain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.dao.CustomerDao;
import com.infogain.entity.Car;
import com.infogain.entity.Customer;

/**
 * @author abhishek-singhal
 *
 */

@Service
public class CarService {
	private CustomerDao customerDao;

	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public List<Car> listCar(String customerId){
		return customerDao.findById(customerId).get().getCars();
	}
	
	public void addCar(String customerId, Car theCar) {
		Customer theCustomer = customerDao.findById(customerId).get();
		theCustomer.addCar(theCar);
		customerDao.save(theCustomer);
	}
	
}
