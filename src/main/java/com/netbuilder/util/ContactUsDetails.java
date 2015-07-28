package com.netbuilder.util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * 
 * @author ngilbert
 *
 **/

@Named
@RequestScoped

public class ContactUsDetails {
	public String telephone;
	public String mailAddress1;
	public String mailAddress2;
	public String mailAddress3;
	public String mailAddress4;
	public String mailAddress5;
	public String email;
	
	public ContactUsDetails(String telephone, String mailAddress, String email){
		this.telephone = "04066457482";
		this.mailAddress1 = "NB Gardens";
		this.mailAddress2 =	"666 Gnarled close"; 
		this.mailAddress3 =	"Hell"; 
		this.mailAddress4 = "Staines";
		this.mailAddress5 = "ST00BL";
		this.email = "NBGardens@hotmail.com";
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
