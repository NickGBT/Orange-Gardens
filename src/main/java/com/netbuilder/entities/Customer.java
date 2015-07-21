package com.netbuilder.entities;

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
public class Customer {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int userId;
	@Column(name = "fname", nullable = false, length = 20)
	@NotNull
	@Size(min = 1, max = 20)
	private String fName;
	@Column(name = "sname", nullable = false, length = 45)
	@NotNull
	@Size(min = 1, max = 45)
	private String lName;
	@Column(name = "is_blacklisted", nullable = false)
	@NotNull
	private boolean isBlackListed;

	public Customer(String fName, String lName, boolean isBlackListed) 
	{
		this.fName = fName;
		this.lName = lName;
		this.isBlackListed = isBlackListed;
	}
	
	public int getUserId()
	{
		return userId;
	}
	
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getfName()
	{
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

	public boolean isBlackListed()
	{
		return isBlackListed;
	}

	public void setBlackListed(boolean isBlackListed)
	{
		this.isBlackListed = isBlackListed;
	}
}