package com.netbuilder.orange_gardens;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class Address 
{
	private int customerID;
	private int addressLabel;
	private int orderID;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String county;
	private String postcode;
	private String country;
	private boolean isBillingAddress;
	
	public int getCustomerID()
	{
		return customerID;
	}
	
	public int getAddressLabel()
	{
		return addressLabel;
	}
	
	public int getOrderID()
	{
		return orderID;
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

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}

	public boolean isBillingAddress()
	{
		return isBillingAddress;
	}

	public void setBillingAddress(boolean isBillingAddress)
	{
		this.isBillingAddress = isBillingAddress;
	}
}