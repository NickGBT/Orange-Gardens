package com.netbuilder.controllers;

import javax.inject.Inject;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.util.LoginDetailsToolkit;
import com.netbuilder.util.RegistrationDetails;

/**
 * 
 * @author llew
 *
 */

public class RegistrationController
{
	//@Inject
	private RegistrationDetails registrationDetails;
	private String errorMsg;
	private Customer customer;
	private LoginDetails loginDetails;
	private Address address;
	private PaymentDetails payDetails;
	
	public String registerCustomer()
	{
		
		if(registrationDetails.checkAllUserEntries())
		{
			customer = new Customer(registrationDetails.getfName(), registrationDetails.getlName(),
					registrationDetails.getContactNumber() , registrationDetails.isBlackListed());
			
			byte[] salt = null;
			byte[] hashedPassword = null; 
			
			try {
				salt = LoginDetailsToolkit.generateSalt();
				hashedPassword = LoginDetailsToolkit.getHashedPassword(registrationDetails.getPassword(), salt);
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
			loginDetails = new LoginDetails(registrationDetails.getUsername(), loginDetails.getEmail(), hashedPassword, salt);
			address = new Address(loginDetails, registrationDetails.getAddressLabel(), registrationDetails.getAddressLine1(), 
					registrationDetails.getAddressLine2(), registrationDetails.getAddressLine3(), 
					registrationDetails.getCity(), registrationDetails.getCounty(), 
					registrationDetails.getPostcode(), registrationDetails.isBillingAddress());
			
			payDetails = new PaymentDetails(registrationDetails.getCardType(), registrationDetails.getCardNumber(),
					registrationDetails.getNameOnCard(), registrationDetails.getSecurityNumber(),
					registrationDetails.getExpiryDate(), loginDetails);
			
			return "account/uid";
		}
		else
		{
			errorMsg = "Invalid entries";
			return "RegisterCustomer";
		}
	}
}