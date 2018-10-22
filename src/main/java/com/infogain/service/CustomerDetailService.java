package com.infogain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.dao.CustomerDao;
import com.infogain.dao.CustomerDetailDao;
import com.infogain.entity.Customer;
import com.infogain.entity.CustomerDetail;

@Service
public class CustomerDetailService {
	private CustomerDetailDao customerDetailDao;
	private  CustomerDao customerDao;
	
	@Autowired
	public void setCustomerDetailDao(CustomerDetailDao customerDetailDao) {
		this.customerDetailDao = customerDetailDao;
	}
	
	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public CustomerDetail findCustomerDetail(String id) {
		return customerDao.findById(id).get().getCustomerDetail();
	}
	
	public void updateCustomerDetail(String id, CustomerDetail theCustomerDetail) {
		Customer theCustomer = customerDao.findById(id).get();
		theCustomer.setCustomerDetail(theCustomerDetail);
		customerDao.save(theCustomer);
	}
	
	public void deleteCustomerDetail(String id) {
		Customer theCustomer = customerDao.findById(id).get();
		CustomerDetail theCustomerDetail = theCustomer.getCustomerDetail();
		theCustomer.setCustomerDetail(null);
		customerDao.save(theCustomer);
		customerDetailDao.delete(theCustomerDetail);
	}
}
