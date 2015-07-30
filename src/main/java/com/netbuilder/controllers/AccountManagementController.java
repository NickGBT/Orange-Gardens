package com.netbuilder.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.inject.Inject;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.AddressManager;
import com.netbuilder.entity_managers.interfaces.CustomerManager;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.util.AccountManagement;
import com.netbuilder.util.LoginDetailsToolkit;
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
	//@Inject
	private LoginDetails loginDetails;
	@Inject
	private LoginDetailsManager loginDetailsManager;
	//@Inject
	private Customer customer;
	@Inject
	private CustomerManager customerManager;
	//@Inject
	private Address address;
	@Inject
	private AddressManager addressManager;
	//@Inject
	private PaymentDetails paymentDetails;
	@Inject
	private PaymentDetailsManager paymentDetailsManager;
	
	public AccountManagementController()
	{
		loginDetails = loginDetailsManager.findByUserId(UserId.getUid());
		customer = customerManager.findByUserId(UserId.getUid());
		address = addressManager.findByUserId(UserId.getUid());
		paymentDetails = paymentDetailsManager.findCustomerPaymentDetails(UserId.getUid());
	}

	public String changeAddress()
	{
		if (address != null)
		{
			address.setAddressLabel(accountManagement.getAddressLabel());
			address.setAddressLine2(accountManagement.getAddressLine2());
			address.setAddressLine3(accountManagement.getAddressLine3());	
			address.setCity(accountManagement.getCity());
			address.setCounty(accountManagement.getCounty());
			address.setPostcode(accountManagement.getPostcode());
			address.setBillingAddress(accountManagement.isBillingAddress());
			return "account/uid";
		}
		else
		{
			errorMsg = "Invalid Change";
			return "account/uid";
		}
	}
	
	public void changePayment()
	{
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
	
	/*
	 * 
	 * @author jtaylor
	 * 
	 */
	public String changePassword()
	{
		if(loginDetails != null)
		{
			byte[] salt = null;
			try {
				salt = LoginDetailsToolkit.generateSalt();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				loginDetails.setNewPasswordAndSalt(LoginDetailsToolkit.getHashedPassword(accountManagement.getPassword(), salt), salt);
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "account/uid";
		}
		else
		{
			errorMsg = "Invalid Change";
			return "account/uid";
		}
	}
	 
}