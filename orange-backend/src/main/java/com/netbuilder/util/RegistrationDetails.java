package com.netbuilder.util;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.netbuilder.controllers.RegistrationController;
import com.netbuilder.enums.CardType;

/**
 * 
 * @author JustinMabbutt
 *
 */
@ManagedBean(name = "registrationDetails")
@RequestScoped
public class RegistrationDetails {
	RegistrationController controller;
	// Customer
	private String fName;
	private String lName;
	private String contactNumber;
	private boolean isBlackListed = false;

	// LoginDetails
	private String username;
	private String email;
	private String password;
	private String confirmPassword;

	// Address
	private String addressLabel;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String county;
	private String postcode;
	private boolean isBillingAddress;

	// PaymentDetails
	private CardType cardType;
	private String cardNumber;
	private String nameOnCard;
	private String expiryDate;

	ArrayList<Object> data = new ArrayList<Object>();

	public RegistrationDetails(){}

	public void Register(String username, String password, String fName,
			String lName, String contactNumber, String email,
			String addressLabel, String addressLine1, String addressLine2,
			String addressLine3, String city, String county, String postcode,
			boolean isBillingAddress, CardType cardType, String cardNumber,
			String nameOnCard, String expiryDate) {
		this.fName = fName;
		data.add(fName);
		this.lName = lName;
		data.add(lName);
		this.contactNumber = contactNumber;
		data.add(contactNumber);
		this.isBillingAddress = isBillingAddress;
		data.add(isBillingAddress);
		this.username = username;
		data.add(username);
		this.email = email;
		data.add(email);
		this.setPassword(password);
		data.add(password);
		this.addressLabel = addressLabel;
		data.add(addressLabel);
		this.addressLine1 = addressLine1;
		data.add(addressLine1);
		this.addressLine2 = addressLine2;
		data.add(addressLine2);
		this.addressLine3 = addressLine3;
		data.add(addressLine3);
		this.city = city;
		data.add(city);
		this.county = county;
		data.add(county);
		this.postcode = postcode;
		data.add(postcode);
		this.cardType = cardType;
		data.add(cardType);
		this.cardNumber = cardNumber;
		data.add(cardNumber);
		this.nameOnCard = nameOnCard;
		data.add(nameOnCard);
		this.expiryDate = expiryDate;
		data.add(expiryDate);
	}
	
	/**
	 * 
	 * @author JustinMabbutt
	 *
	 */
	public void validatePassword(FacesContext context, UIComponent toValidate, Object value)
	{     
        String confirm = (String)value;     
        UIInput passComp = (UIInput)toValidate.getAttributes().get("passwordComponent");     
        String password = (String)passComp.getValue();     
        if (!password.equals(confirm)) 
        {     
        	FacesMessage message = new FacesMessage("Password and Confirm Password Should match");     
            throw new ValidatorException(message);     
        }
	} 

	public boolean checkAllUserEntries()
	{
		for (Object o : data) {
			if (o == null) {
				return false;
			}
		}
		return true;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

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

	public String getAddressLabel() 
	{
		return addressLabel;
	}

	public void setAddressLabel(String addressLabel)
	{
		this.addressLabel = addressLabel;
	}

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() 
	{
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) 
	{
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() 
	{
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) 
	{
		this.addressLine3 = addressLine3;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCounty() 
	{
		return county;
	}

	public void setCounty(String county)
	{
		this.county = county;
	}

	public String getPostcode()
	{
		return postcode;
	}

	public void setPostcode(String postcode) 
	{
		this.postcode = postcode;
	}

	public boolean isBillingAddress()
	{
		return isBillingAddress;
	}

	public void setBillingAddress(boolean isBillingAddress)
	{
		this.isBillingAddress = isBillingAddress;
	}

	public CardType getCardType()
	{
		return cardType;
	}

	public void setCardType(CardType cardType) 
	{
		this.cardType = cardType;
	}

	public String getCardNumber() 
	{
		return cardNumber;
	}

	public void setCardNumber(String cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard()
	{
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard)
	{
		this.nameOnCard = nameOnCard;
	}

	public String getExpiryDate()
	{
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate)
	{
		this.expiryDate = expiryDate;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isBlackListed() 
	{
		return isBlackListed;
	}

	public void setBlackListed(boolean isBlackListed)
	{
		this.isBlackListed = isBlackListed;
	}

	public void setContactNumber(String contactNum)
	{
		this.contactNumber = contactNum;
	}

	public String getContactNumber() 
	{
		return contactNumber;
	}

	public void printString()
	{
		System.out.println(fName);
		System.out.println(lName);
	}

	public String getConfirmPassword()
	{
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}
}