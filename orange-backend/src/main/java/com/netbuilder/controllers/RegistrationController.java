package com.netbuilder.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.AddressManager;
import com.netbuilder.entity_managers.interfaces.CustomerManager;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.enums.CardType;
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
public class RegistrationController {
	@ManagedProperty(value = "#{registrationDetails}")
	private RegistrationDetails registrationDetails;

	@ManagedProperty(value = "#{userDetails}")
	private UserDetails userDetails;

	@Inject
	private LoginDetailsManager loginDetailsManager;

	@Inject
	private PaymentDetailsManager paymentDetailsManager;

	@Inject
	private AddressManager addressManager;
	
	@Inject
	private CustomerManager customerManager;

	private Customer customer;
	private LoginDetails loginDetails;
	private Address address;
	private PaymentDetails payDetails;
	private static final Logger logger = LogManager.getLogger();

	public String registerCustomer() {

		if (registrationDetails.checkAllUserEntries()) {
			byte[] salt = null;
			byte[] hashedPassword = null;

			try {
				salt = LoginDetailsToolkit.generateSalt();
				hashedPassword = LoginDetailsToolkit.getHashedPassword(
						registrationDetails.getPassword(), salt);
			} catch (Exception e) {
				logger.error("Exception thrown, consult stack trace");
				e.printStackTrace();
			}
			System.out.println("Hashed Pass : " + hashedPassword);
			
			loginDetails = new LoginDetails(registrationDetails.getUsername(),
					registrationDetails.getEmail(), hashedPassword, salt);
			
			loginDetailsManager.persistLoginDetails(loginDetails);

			customer = new Customer(loginDetails, 
					registrationDetails.getfName(),
					registrationDetails.getlName(),
					registrationDetails.getContactNumber(),
					registrationDetails.isBlackListed());
			
			customerManager.persistCustomer(customer);
			
			address = new Address(loginDetails,
					registrationDetails.getAddressLabel(),
					registrationDetails.getAddressLine1(),
					registrationDetails.getAddressLine2(),
					registrationDetails.getAddressLine3(),
					registrationDetails.getCity(),
					registrationDetails.getCounty(),
					registrationDetails.getPostcode(),
					registrationDetails.isBillingAddress());

			payDetails = new PaymentDetails(registrationDetails.getCardType(),
					registrationDetails.getCardNumber(),
					registrationDetails.getNameOnCard(),
					registrationDetails.getExpiryDate(), loginDetails);

			addressManager.persistAddress(address);
			paymentDetailsManager.persistPaymentDetails(payDetails);

			return "customerlogin.xhtml";
		} else {
			System.out.println("Invalid");
			logger.info("Invalid registration entries");
			return "registercustomer.xhtml";
		}
	}

	public void setRegistrationDetails(RegistrationDetails registrationDetails) {
		this.registrationDetails = registrationDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public CardType[] getEnumValues(){
		return CardType.values();
	}
}