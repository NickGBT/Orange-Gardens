package com.netbuilder.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
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
import com.netbuilder.util.AccountManagement;
import com.netbuilder.util.LoginDetailsToolkit;
import com.netbuilder.util.UserId;

/**
 * 
 * @author JustinMabbutt
 *
 */
@ManagedBean(name = "accountManagementController")
@RequestScoped
public class AccountManagementController {

	@Inject
	private AccountManagement accountManagement;
	// @Inject
	private LoginDetails loginDetails;
	@Inject
	private LoginDetailsManager loginDetailsManager;
	// @Inject
	private Customer customer;
	@Inject
	private CustomerManager customerManager;
	// @Inject
	private Address address;
	@Inject
	private AddressManager addressManager;
	// @Inject
	private PaymentDetails paymentDetails;
	@Inject
	private PaymentDetailsManager paymentDetailsManager;
	@Inject
	private UserId userId;
	
	private static final Logger logger = LogManager.getLogger();

	/**
	 * Change address to user input
	 * @return the customer account page
	 */
	public String changeAddress() {
		if (address != null) {
			address.setAddressLabel(accountManagement.getAddressLabel());
			address.setAddressLine2(accountManagement.getAddressLine2());
			address.setAddressLine3(accountManagement.getAddressLine3());
			address.setCity(accountManagement.getCity());
			address.setCounty(accountManagement.getCounty());
			address.setPostcode(accountManagement.getPostcode());
			address.setBillingAddress(accountManagement.isBillingAddress());
			return "customeraccount.xhtml";
		} else {
			return "customeraccount.xhtml";
		}
	}

	public void changePayment() {
		paymentDetails.setCardType(accountManagement.getCardType());
		paymentDetails.setCardNumber(accountManagement.getCardNumber());
		paymentDetails.setExpiryDate(accountManagement.getCardExpiryDate());
		paymentDetails.setNameOnCard(accountManagement.getNameOnCard());
	}

	public LoginDetails getLoginDetails() {
		loginDetails = loginDetailsManager.findByUserId(userId.getUid());
		return loginDetails;
	}

	public Customer getCustomer() {
		loginDetails = loginDetailsManager.findByUserId(userId.getUid());
		customer = customerManager.findByUser(loginDetails);
		return customer;
	}

	public Address getAddress() {
		loginDetails = loginDetailsManager.findByUserId(userId.getUid());
		address = addressManager.findByUserId(loginDetails);
		return address;
	}

	public PaymentDetails getPaymentDetails() {
		loginDetails = loginDetailsManager.findByUserId(userId.getUid());
		paymentDetails = paymentDetailsManager.findCustomerPaymentDetails(loginDetails);
		return paymentDetails;
	}

	/**
	 * 
	 * @author jtaylor
	 * 
	 */
	public String changePassword() {
		if (loginDetails != null) {
			byte[] salt = null;
			try {
				salt = LoginDetailsToolkit.generateSalt();
			} catch (NoSuchAlgorithmException e) {
				logger.error("No algorithm found", salt);
				e.printStackTrace();
			}
			try {
				loginDetails.setNewPasswordAndSalt(LoginDetailsToolkit.getHashedPassword(accountManagement.getPassword(), salt), salt);
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				logger.error("Invalid key specification");
				e.printStackTrace();
			}
			return "customeraccount.xhtml";
		} else {
			return "customeraccount.xhtml";
		}
	}
	
	public CardType[] getEnumValues(){
		return CardType.values();
	}
}