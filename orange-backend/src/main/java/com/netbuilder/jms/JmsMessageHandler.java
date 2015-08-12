package com.netbuilder.jms;

import java.util.List;

import com.netbuilder.entities.Employee;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;
import com.netbuilder.util.LoginDetailsToolkit;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class JmsMessageHandler
{
	private List<String> employeeDetails;
	private byte[] salt = null, hashedPassword = null;
	private LoginDetails warehouseOperativeLogin;
	private Employee warehouseOperative;
	
	public JmsMessageHandler()
	{
		try
		{
			salt = LoginDetailsToolkit.generateSalt();
			hashedPassword = LoginDetailsToolkit.getHashedPassword("password", salt);
			warehouseOperativeLogin = new LoginDetails(22, "JSmith", "JSmith@nbg.co.uk", hashedPassword, salt);
			setWarehouseOperative(new Employee(warehouseOperativeLogin, EmployeeDepartment.WAREHOUSE, "John", "Smith", EmployeePermissions.WORKER));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<String> getEmployeeDetails()
	{
		return employeeDetails;
	}

	public void setEmployeeDetails(String employeeDetails) 
	{
		this.employeeDetails.add(employeeDetails);
	}

	public Employee getWarehouseOperative() 
	{
		return warehouseOperative;
	}

	public void setWarehouseOperative(Employee warehouseOperative) 
	{
		this.warehouseOperative = warehouseOperative;
	}
}