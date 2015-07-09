package com.netbuilder.entity_managers.database;

import java.util.ArrayList;

import com.netbuilder.entities.Employee;
import com.netbuilder.entity_managers.interfaces.EmployeeManager;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;

public class EmployeeManagerDB implements EmployeeManager {

	public void persistEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	public void persistEmployees(ArrayList<Employee> employees) {
		// TODO Auto-generated method stub

	}

	public Employee getEmployeeById(int employeeId) {
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
