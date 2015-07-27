package com.netbuilder.util;

import javax.ejb.Stateful;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class UserId 
{
	private static int customerUid, employeeUid;
	
	public static void setUid(int customerUid)
	{
		UserId.customerUid = customerUid;
	}
	
	public static int getUid()
	{
		return customerUid;
	}

	public static int getEmployeeUid() 
	{
		return employeeUid;
	}

	public static void setEmployeeUid(int employeeUid)
	{
		UserId.employeeUid = employeeUid;
	}
}