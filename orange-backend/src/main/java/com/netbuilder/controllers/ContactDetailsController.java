package com.netbuilder.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.netbuilder.util.ContactUsDetails;
import com.netbuilder.util.TestData;

/**
 * 
 * @author ngilbert
 *
 **/

@ManagedBean(name = "contactUsDetailsController")
@RequestScoped
public class ContactDetailsController {
	// @Inject
	@ManagedProperty(value = "#{testData}")
	private TestData testData;

	private ContactUsDetails contactUsDetails;

	/*
	 * @author jtaylor
	 */
	public ContactUsDetails getContactUsDetails() {
		contactUsDetails = testData.getContactUs();
		return contactUsDetails;
	}

	public TestData getTestData() {
		return testData;
	}

	public void setTestData(TestData testData) {
		this.testData = testData;
	}

}
