package com.netbuilder.controllers;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.arraylist.AddressManagerAL;
import com.netbuilder.entity_managers.arraylist.CustomerManagerAL;
import com.netbuilder.entity_managers.arraylist.LoginDetailsManagerAL;
import com.netbuilder.entity_managers.arraylist.PaymentDetailsManagerAL;
import com.netbuilder.util.AccountManagement;
import com.netbuilder.util.CustomerUserId;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class AccountManagementController 
{
	private String errorMsg;
	private AccountManagement accountManagement;
	private LoginDetails loginDetails;
	private LoginDetailsManagerAL loginDetailsManager;
	private Customer customer;
	private CustomerManagerAL customerManager;
	private Address address;
	private AddressManagerAL addressManager;
	private PaymentDetails paymentDetails;
	private PaymentDetailsManagerAL paymentDetailsManager;
	
	public AccountManagementController()
	{
		loginDetails = loginDetailsManager.findByUserId(CustomerUserId.getUid());
		customer = customerManager.findByUserId(CustomerUserId.getUid());
		address = addressManager.findByUserId(CustomerUserId.getUid());
		paymentDetails = paymentDetailsManager.findCustomerPaymentDetails(CustomerUserId.getUid());
	}
	
	public LoginDetails getLoginDetails()
	{
		return loginDetails;
	}

	public Customer getCustomer() 
	{
		return customer;
	}

	public Address getAddress() 
	{
		return address;
	}

	public PaymentDetails getPaymentDetails() 
	{
		return paymentDetails;
	}
	
	public String changeFName()
	{
		if(accountManagement.getfName() != null)
		{
			customer.setfName(accountManagement.getfName());
			return "account/uid";
		}
		else
		{
			errorMsg = "Invalid Change";
			return "account/uid";
		}
	}
	
	public String changeLName()
	{
		if(accountManagement.getlName() != null)
		{
			customer.setlName(accountManagement.getlName());
			return "account/uid";
		}
		else
		{
			errorMsg = "Invalid Change";
			return "account/uid";
		}
	}
	
	public String changeEmail()
	{
		if(accountManagement.getEmail() != null)
		{
			loginDetails.setEmail(accountManagement.getEmail());
			return "account/uid";
		}
		else
		{
			errorMsg = "Invalid Change";
			return "account/uid";
		}
	}
	
	public String changeContactNo()
	{
		if(accountManagement.getContactNo() != null)
		{
			customer.setContactNumber(accountManagement.getContactNo());
			return "account/uid";
		}
		else
		{
			errorMsg = "Invalid Change";
			return "account/uid";
		}
	}
	
	public String changeUsername()
	{
		if(accountManagement.getUsername() != null)
		{
			loginDetails.setUsername(accountManagement.getUsername());
			return "account/uid";
		}
		else
		{
			errorMsg = "Invalid Change";
			return "account/uid";
		}
	}
	
	public String changePaymentMethod()
	{
		if(accountManagement.getCardType() != null)
		{
			paymentDetails.setCardType((accountManagement.getCardType()));
			return "account/uid";
		}
		else
		{
			errorMsg = "Invalid Change";
			return "account/uid";
		}
	}
}