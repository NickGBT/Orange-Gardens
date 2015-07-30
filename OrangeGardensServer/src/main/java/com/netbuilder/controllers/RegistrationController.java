package com.netbuilder.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
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

@ManagedBean(name = "registrationDetailsController")
@RequestScoped
public class RegistrationController
{
	@ManagedProperty(value="#{registrationDetails}")
	private RegistrationDetails registrationDetails;
	private String errorMsg;
	private Customer customer;
	private LoginDetails loginDetails;
	private Address address;
	private PaymentDetails payDetails;
	
	public String registerCustomer()
	{
		System.out.println("Worked ");
		
		System.out.println(registrationDetails.getfName());
		System.out.println(registrationDetails.getlName());
		System.out.println(registrationDetails.getEmail());
		
		if(registrationDetails.checkAllUserEntries())
		{
			System.out.println("setting up customer");
			customer = new Customer(registrationDetails.getfName(), registrationDetails.getlName(),
					registrationDetails.getContactNumber() , registrationDetails.isBlackListed());
			System.out.println(registrationDetails.getfName() + " " + registrationDetails.getlName() + " " + 
					registrationDetails.getContactNumber() + " " +  registrationDetails.isBlackListed());
			byte[] salt = null;
			byte[] hashedPassword = null; 
			
			System.out.println("Setting up hash");
			try {
				salt = LoginDetailsToolkit.generateSalt();
				hashedPassword = LoginDetailsToolkit.getHashedPassword(registrationDetails.getPassword(), salt);
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
			System.out.println("Setting up login det");
			loginDetails = new LoginDetails(registrationDetails.getUsername(), registrationDetails.getEmail(), hashedPassword, salt);
			address = new Address(loginDetails, registrationDetails.getAddressLabel(), registrationDetails.getAddressLine1(), 
					registrationDetails.getAddressLine2(), registrationDetails.getAddressLine3(), 
					registrationDetails.getCity(), registrationDetails.getCounty(), 
					registrationDetails.getPostcode(), registrationDetails.isBillingAddress());
			
			System.out.println("Setting up pay det");
			payDetails = new PaymentDetails(registrationDetails.getCardType(), registrationDetails.getCardNumber(),
					registrationDetails.getNameOnCard(), registrationDetails.getSecurityNumber(),
					registrationDetails.getExpiryDate(), loginDetails);
			
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
}