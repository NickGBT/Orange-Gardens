package com.netbuilder.util;

import java.io.Serializable;
//import javax.faces.bean.SessionScoped;
import javax.enterprise.context.SessionScoped;

/**
 * 
 * @author JustinMabbutt llew
 *
 */
@SessionScoped
public class UserId implements Serializable {

	private static final long serialVersionUID = 387704063221232446L;
	private int customerUid, employeeUid;
	private String username;

	public void setUid(int customerUid) {
		this.customerUid = customerUid;
	}

	public int getUid() {
		return customerUid;
	}

	public int getEmployeeUid() {
		return employeeUid;
	}

	public void setEmployeeUid(int employeeUid) {
		this.employeeUid = employeeUid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserId getUserId() {
		return this;
	}
}