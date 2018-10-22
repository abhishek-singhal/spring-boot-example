/**
 * 
 */
package com.infogain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.entity.Car;

/**
 * @author abhishek-singhal
 *
 */

@Repository
public interface CarDao extends JpaRepository<Car, String>{

}
