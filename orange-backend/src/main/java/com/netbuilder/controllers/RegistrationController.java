package com.netbuilder.controllers;

import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.util.LoginDetailsToolkit;
import com.netbuilder.util.RegistrationDetails;
import com.netbuilder.util.UserDetails;

/**
 * 
 * @author llew
 *
 */

@ManagedBean(name = "registrationDetailsController")
@RequestScoped
public class RegistrationController
{
	@ManagedProperty(value="#{registrationDetails}")
	private RegistrationDetails registrationDetails;
	
	@ManagedProperty(value="#{userDetails}")
	private UserDetails userDetails;
	
	@Inject
	private LoginDetailsManager loginDetailsManager;
	
	private String errorMsg;
	private Customer customer;
	private LoginDetails loginDetails;
	private Address address;
	private PaymentDetails payDetails;
	
	private Random rand;
	
	public String registerCustomer()
	{
		rand = new Random();
		System.out.println("Worked ");

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
			System.out.println("Hashed Pass : " + hashedPassword);
			loginDetails = new LoginDetails(registrationDetails.getUsername(), registrationDetails.getEmail(), hashedPassword, salt);
			address = new Address(loginDetails, registrationDetails.getAddressLabel(), registrationDetails.getAddressLine1(), 
					registrationDetails.getAddressLine2(), registrationDetails.getAddressLine3(), 
					registrationDetails.getCity(), registrationDetails.getCounty(), 
					registrationDetails.getPostcode(), registrationDetails.isBillingAddress());
			
			payDetails = new PaymentDetails(registrationDetails.getCardType(), registrationDetails.getCardNumber(),
					registrationDetails.getNameOnCard(), registrationDetails.getSecurityNumber(),
					registrationDetails.getExpiryDate(), loginDetails);
			
			loginDetailsManager.persistLoginDetails(loginDetails);		
			
			return "account/uid";
		}
		else
		{
			System.out.println("Invalid");
			errorMsg = "Invalid entries";
			return "RegisterCustomer";
		}
		
		
	}

	public void setRegistrationDetails(RegistrationDetails registrationDetails) {
		this.registrationDetails = registrationDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
}