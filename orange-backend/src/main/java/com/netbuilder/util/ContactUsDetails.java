package com.netbuilder.util;

/**
 * 
 * @author ngilbert
 *
 **/

public class ContactUsDetails {
	public String telephone;
	public String mailAddress1;
	public String mailAddress2;
	public String mailAddress3;
	public String mailAddress4;
	public String mailAddress5;
	public String email;
	
	public ContactUsDetails(String telephone, String mailAddress1, String mailAddress2, String mailAddress3, String mailAddress4, String mailAddress5, String email){
		this.telephone = telephone;
		this.mailAddress1 = mailAddress1;
		this.mailAddress2 =	mailAddress2; 
		this.mailAddress3 =	mailAddress3; 
		this.mailAddress4 = mailAddress4;
		this.mailAddress5 = mailAddress5;
		this.email = email;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public String getMailAddress1() {
		return mailAddress1;
	}

	public String getMailAddress2() {
		return mailAddress2;
	}

	public String getMailAddress3() {
		return mailAddress3;
	}

	public String getMailAddress4() {
		return mailAddress4;
	}

	public String getMailAddress5() {
		return mailAddress5;
	}

	public String getEmail() {
		return email;
	}

}
