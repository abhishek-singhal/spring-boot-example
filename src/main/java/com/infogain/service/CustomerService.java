/**
 * 
 */
package com.infogain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.dao.CustomerDao;
import com.infogain.entity.Customer;

/**
 * @author abhishek-singhal
 *
 */

@Service
public class CustomerService {
	
	private CustomerDao customerDao;

	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	public List<Customer> listAll() {
		return customerDao.findAll();
	}
	
	public Customer saveCustomer(Customer theCustomer) {
		return customerDao.save(theCustomer);
	}
	
	public Customer findCustomerById(String id) {
		return customerDao.findById(id).get();
	}
	
	public void deleteCustomer(String id) {
		customerDao.deleteById(id);
	}
	
	public List<Customer> findByEmail(String email) {
		return customerDao.findByEmail(email);
	}
	
	public List<Customer> findByName(String name) {
		return customerDao.findByName(name);
	}
}
