/**
 * 
 */
package com.infogain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.entity.Customer;
import java.lang.String;
import java.util.List;

/**
 * @author abhishek-singhal
 *
 */

@Repository
public interface CustomerDao extends JpaRepository<Customer, String>{
	public List<Customer> findByName(String name);
	
	public List<Customer> findByEmail(String email);
}
