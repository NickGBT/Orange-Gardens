package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import com.netbuilder.entities.Employee;
import com.netbuilder.entity_managers.interfaces.EmployeeManager;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;

/**
 * 
 * @author mwatson
 *
 */

public class EmployeeManagerAL implements EmployeeManager {

	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public void persistEmployee(Employee employee) {
		employees.add(employee);
		
	}

	public void persistEmployees(ArrayList<Employee> employees) {
		this.employees.addAll(employees);
		
	}

	public Employee getEmployeeById(int EmployeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Employee> getEmployeesBySurname(String surname) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Employee> getEmployeesByForename(String forename) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Employee> getEmployeesByNames(String forename, String surname) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Employee> getEmployeesByDepartment(EmployeeDepartment department) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Employee> getEmployeesByRole(EmployeeDepartment department, EmployeePermissions position) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	public void removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	
	
}
