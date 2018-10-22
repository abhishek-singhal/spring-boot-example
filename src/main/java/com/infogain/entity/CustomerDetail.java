/**
 * 
 */
package com.infogain.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author abhishek-singhal
 *
 */

@Entity
public class CustomerDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;
	
	private String spouseName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String profession;

	@NotNull(message = "is required")
	@Pattern(regexp = "^AD[a-zA-Z0-9]{3}", message = "Invalid Adhaar. Adhaar should be of type: ADXXX")
	private String aadhaar;
	
	@NotNull(message = "is required")
	private Date dob;

public CustomerDetail() {
		
	}

	public CustomerDetail(String spouseName, String profession, String aadhaar, String dob) {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		this.spouseName = spouseName;
		this.profession = profession;
		this.aadhaar = aadhaar;
		try {
			this.dob = df.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getDob() {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		if(dob == null) {
			return "";
		}
		return df.format(dob);
	}

	public void setDob(String dob) {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		try {
			this.dob = df.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
