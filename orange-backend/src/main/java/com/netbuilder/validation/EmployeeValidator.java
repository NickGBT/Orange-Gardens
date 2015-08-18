package com.netbuilder.validation;

import com.netbuilder.entities.Employee;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class EmployeeValidator
{
	public boolean validateEmployee(Employee toBeValidated)
	{
		if(toBeValidated.getDepartment().getClass().isEnum())
		{
			if(toBeValidated.getPermission().getClass().isEnum())
			{
				if(toBeValidated.getfName().length() > 1 && toBeValidated.getfName().length() < 20)
				{
					if(toBeValidated.getlName().length() > 1 && toBeValidated.getlName().length() < 45)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}