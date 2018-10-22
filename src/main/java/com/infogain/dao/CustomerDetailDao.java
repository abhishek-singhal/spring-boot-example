/**
 * 
 */
package com.infogain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.entity.CustomerDetail;

/**
 * @author abhishek-singhal
 *
 */

@Repository
public interface CustomerDetailDao extends JpaRepository<CustomerDetail, String>{

}
