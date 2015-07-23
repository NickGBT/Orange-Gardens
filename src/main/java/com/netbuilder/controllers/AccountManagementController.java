package com.netbuilder.controllers;

import javax.inject.Inject;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.arraylist.AddressManagerAL;
import com.netbuilder.entity_managers.arraylist.CustomerManagerAL;
import com.netbuilder.entity_managers.arraylist.LoginDetailsManagerAL;
import com.netbuilder.entity_managers.arraylist.PaymentDetailsManagerAL;
import com.netbuilder.util.AccountManagement;
import com.netbuilder.util.UserId;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class AccountManagementController 
{
	private String errorMsg;
	@Inject
	private AccountManagement accountManagement;
	@Inject
	private LoginDetails loginDetails;
	@Inject
	private LoginDetailsManagerAL loginDetailsManager;
	@Inject
	private Customer customer;
	@Inject
	private CustomerManagerAL customerManager;
	@Inject
	private Address address;
	@Inject
	private AddressManagerAL addressManager;
	@Inject
	private PaymentDetails paymentDetails;
	@Inject
	private PaymentDetailsManagerAL paymentDetailsManager;
	
	public AccountManagementController()
	{
		loginDetails = loginDetailsManager.findByUserId(UserId.getUid());
		customer = customerManager.findByUserId(UserId.getUid());
		address = addressManager.findByUserId(UserId.getUid());
		paymentDetails = paymentDetailsManager.findCustomerPaymentDetails(UserId.getUid());
	}

	public void changeAddress(){
		
		address.setAddressLabel(accountManagement.getAddressLabel());
		address.setAddressLine1(accountManagement.getAddressLine1());
		address.setAddressLine2(accountManagement.getAddressLine2());
		address.setAddressLine3(accountManagement.getAddressLine3());	
		address.setCity(accountManagement.getCity());
		address.setCounty(accountManagement.getCounty());
		address.setPostcode(accountManagement.getPostcode());
		address.setBillingAddress(accountManagement.isBillingAddress());
		
	}
	
	public void changePayment(){
		
		paymentDetails.setCardType(accountManagement.getCardType());
		paymentDetails.setCardNumber(accountManagement.getCardNumber());
		paymentDetails.setExpiryDate(accountManagement.getCardExpiryDate());
		paymentDetails.setNameOnCard(accountManagement.getNameOnCard());
		
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