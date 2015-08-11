package com.netbuilder.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

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

	private String errorMsg;
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
			errorMsg = "Invalid Change";
			return "account/uid";
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
		//loginDetails = testData.getCustomerLogin();
		return loginDetails;
	}

	public Customer getCustomer() {
		customer = customerManager.findByUsername(userId.getUsername());
		//customer = testData.getCustomer();
		return customer;
	}

	public Address getAddress() {
		address = addressManager.findByUserId(userId.getUid());
		//address = testData.getAddress();
		return address;
	}

	public PaymentDetails getPaymentDetails() {
		paymentDetailsManager.findCustomerPaymentDetails(userId.getUid());
		//paymentDetails = testData.getPaymentDetails();
		return paymentDetails;
	}

	/*
	 * 
	 * @author jtaylor
	 */
	public String changePassword() {
		if (loginDetails != null) {
			byte[] salt = null;
			try {
				salt = LoginDetailsToolkit.generateSalt();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			try {
				loginDetails.setNewPasswordAndSalt(
						LoginDetailsToolkit.getHashedPassword(
								accountManagement.getPassword(), salt), salt);
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				e.printStackTrace();
			}
			return "account/uid";
		} else {
			errorMsg = "Invalid Change";
			return "account/uid";
		}
	}
	
	public CardType[] getEnumValues(){
		return CardType.values();
	}
}