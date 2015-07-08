package com.netbuilder.orange_gardens;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Customer 
{
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int customerID;
	@Column(name = "fname", nullable = false, length = 20)
	@NotNull
	@Size(min = 1, max = 20)
	private String fName;
	@Column(name = "sname", nullable = false, length = 45)
	@NotNull
	@Size(min = 1, max = 45)
	private String lName;
	@Column(name = "username", nullable = false, length = 25)
	@NotNull
	@Size(min = 6, max = 25)
	private String username;
	@Column(name = "password", nullable = false, length = 16)
	@NotNull
	@Size(min = 6, max = 16)
	private String password;
	@Column(name = "email_address", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String emailAddress;
	@Column(name = "is_blacklisted", nullable = false)
	@NotNull
	private boolean isBlackListed;
	
	public Customer(String fName, String lName, String username, String password, String emailAddress, boolean isBlackListed) 
	{
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.isBlackListed = isBlackListed;
	}
	
	public int getCustomerID()
	{
		return customerID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName)
	{
		this.fName = fName;
	}

	public String getlName()
	{
		return lName;
	}

	public void setlName(String lName) 
	{
		this.lName = lName;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmailAddress() 
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) 
	{
		this.emailAddress = emailAddress;
	}

	public boolean isBlackListed() 
	{
		return isBlackListed;
	}

	public void setBlackListed(boolean isBlackListed) 
	{
		this.isBlackListed = isBlackListed;
	}
}