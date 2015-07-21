package com.netbuilder.util;

import java.util.ArrayList;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.netbuilder.entities.Customer;
import com.netbuilder.enums.CardType;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Named
@RequestScoped
public class RegistrationDetails 
{
	private String username;
	private String fName;
	private String lName;
	private String email;
	private boolean isBlackListed = false;
	
	private String addressLabel;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String county;
	private String postcode;
	private boolean isBillingAddress;
	
	private CardType cardType;
	private String cardNumber;
	private String nameOnCard;
	private int securityNumber;
	private Date expiryDate;
	
	ArrayList<Object> data = new ArrayList<Object>();
	
	public RegistrationDetails(String username, String fName, String lName, String email, String addressLabel,
			String addressLine1, String addressLine2, String addressLine3, String city, String county, String postcode,
			boolean isBillingAddress, CardType cardType, String cardNumber, String nameOnCard, int securityNumber,
			Date expiryDate) {
		this.username = username; data.add(username);
		this.fName = fName; data.add(fName);
		this.lName = lName; data.add(lName);
		this.email = email; data.add(email);
		this.addressLabel = addressLabel; data.add(addressLabel);
		this.addressLine1 = addressLine1; data.add(addressLine1);
		this.addressLine2 = addressLine2; data.add(addressLine2);
		this.addressLine3 = addressLine3; data.add(addressLine3);
		this.city = city; data.add(city);
		this.county = county; data.add(county);
		this.postcode = postcode; data.add(postcode);
		this.isBillingAddress = isBillingAddress; data.add(isBillingAddress);
		this.cardType = cardType; data.add(cardType);
		this.cardNumber = cardNumber; data.add(cardNumber);
		this.nameOnCard = nameOnCard; data.add(nameOnCard);
		this.securityNumber = securityNumber; data.add(securityNumber);
		this.expiryDate = expiryDate; data.add(expiryDate);
	}
	
	public boolean checkAllUserEntries()
	{
		for(Object o : data)
		{
			if(o == null)
			{
				return false;
			}
		}
		return true;
	}
	
	public void registerCustomer()
	{
		
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
	
	public int getSecurityNumber()
	{
		return securityNumber;
	}
	
	public void setSecurityNumber(int securityNumber)
	{
		this.securityNumber = securityNumber;
	}
	
	public Date getExpiryDate()
	{
		return expiryDate;
	}
	
	public void setExpiryDate(Date expiryDate) 
	{
		this.expiryDate = expiryDate;
	}
}