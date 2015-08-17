package com.netbuilder.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	@ManyToOne
	@Id
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull
	private LoginDetails customer;
	@Column(name = "fname", nullable = false, length = 20)
	@NotNull
	@Size(min = 1, max = 20)
	private String fName;
	@Column(name = "lname", nullable = false, length = 45)
	@NotNull
	@Size(min = 1, max = 45)
	private String lName;
	@Column(name = "contact_number", nullable = false)
	@NotNull
	private String contactNumber;
	@Column(name = "is_blacklisted", nullable = false)
	@NotNull
	private boolean isBlackListed;

	public Customer(String fName, String lName, String contactNumber,
			boolean isBlackListed) {
		this.fName = fName;
		this.lName = lName;
		this.contactNumber = contactNumber;
		this.isBlackListed = isBlackListed;
	}
	
	public Customer(){}
	
	public Customer(LoginDetails customer, String fName, String lName, String contactNumber, boolean isBlackListed)
	{
		this.customer = customer;
		this.fName = fName;
		this.lName = lName;
		this.contactNumber = contactNumber;
		this.isBlackListed = isBlackListed;
	}
	
	public LoginDetails getCustomer() {
		return customer;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public boolean isBlackListed() {
		return isBlackListed;
	}

	public void setBlackListed(boolean isBlackListed) {
		this.isBlackListed = isBlackListed;
	}

	public void setContactNumber(String contactNum) {
		this.contactNumber = contactNum;
	}

	public String getContactNumber() {
		return contactNumber;
	}
}