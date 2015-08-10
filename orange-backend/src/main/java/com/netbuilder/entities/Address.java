package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Entity
@Table(name = "address")
public class Address {
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull
	private LoginDetails customer;
	@Id
	@Column(name = "address_label", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String addressLabel;
	@Column(name = "line1", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String addressLine1;
	@Column(name = "line2", nullable = true, length = 45)
	@Null
	@Size(min = 2, max = 45)
	private String addressLine2;
	@Column(name = "line3", nullable = true, length = 45)
	@Null
	@Size(min = 2, max = 45)
	private String addressLine3;
	@Column(name = "city", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String city;
	@Column(name = "county", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String county;
	@Column(name = "postcode", nullable = false, length = 45)
	@NotNull
	@Size(min = 6, max = 8)
	private String postcode;
	@Column(name = "is_billing_address", nullable = false)
	@NotNull
	private boolean isBillingAddress;

	public Address(LoginDetails customer, String addressLabel,
			String addressLine1, String addressLine2, String addressLine3,
			String city, String county, String postcode,
			boolean isBillingAddress) {
		this.customer = customer;
		this.addressLabel = addressLabel;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.city = city;
		this.county = county;
		this.postcode = postcode;
		this.isBillingAddress = isBillingAddress;
	}

	public LoginDetails getCustomer() {
		return customer;
	}

	public String getAddressLabel() {
		return addressLabel;
	}

	public void setAddressLabel(String addressLabel) {
		this.addressLabel = addressLabel;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public boolean isBillingAddress() {
		return isBillingAddress;
	}

	public void setBillingAddress(boolean isBillingAddress) {
		this.isBillingAddress = isBillingAddress;
	}
}