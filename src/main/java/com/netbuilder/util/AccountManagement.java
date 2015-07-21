package com.netbuilder.util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.netbuilder.enums.CardType;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Named
@RequestScoped
public class AccountManagement 
{
	private String fName, lName, email, contactNo, username;
	private CardType cardType;
	
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getContactNo()
	{
		return contactNo;
	}

	public void setContactNo(String contactNo)
	{
		this.contactNo = contactNo;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public CardType getCardType() 
	{
		return cardType;
	}

	public void setCardType(CardType cardType) 
	{
		this.cardType = cardType;
	}
}