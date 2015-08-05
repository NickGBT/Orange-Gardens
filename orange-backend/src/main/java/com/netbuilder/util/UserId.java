package com.netbuilder.util;

import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 * @author JustinMabbutt llew
 *
 */
@SessionScoped
public class UserId 
{
	private int customerUid, employeeUid;
	private String username = "";
	
	public void setUid(int customerUid)
	{
		this.customerUid = customerUid;
	}
	
	public int getUid()
	{
		return customerUid;
	}

	public int getEmployeeUid() 
	{
		return employeeUid;
	}

	public void setEmployeeUid(int employeeUid)
	{
		this.employeeUid = employeeUid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public UserId getUserId(){
		return this;
	}
	
	
}