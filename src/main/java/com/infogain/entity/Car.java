/**
 * 
 */
package com.infogain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author abhishek-singhal
 *
 */

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String carName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String model;

	public Car(String carName, String model) {
		this.carName = carName;
		this.model = model;
	}

	public Car() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
