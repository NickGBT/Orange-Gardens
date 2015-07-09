package com.netbuilder.entity_managers.interfaces;

import java.util.ArrayList;

import com.netbuilder.entities.Employee;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;
/**
 * 
 * @author Alexander Neil
 *
 */
public interface EmployeeManager {
	
	//CREATE
	public void persistEmployee(Employee employee);
	public void persistEmployees(ArrayList<Employee> employees);
	
	//READ
	public Employee getEmployeeById(int EmployeeId);
	public ArrayList<Employee> getEmployeesBySurname(String surname);
	public ArrayList<Employee> getEmployeesByForename(String forename);
	public ArrayList<Employee> getEmployeesByNames(String forename, String surname);
	public ArrayList<Employee> getEmployeesByDepartment(EmployeeDepartment department);
	public ArrayList<Employee> getEmployeesByRole(EmployeeDepartment department, EmployeePermissions position);
	
	//UPDATE
	public void updateEmployee(Employee employee);
	
	//DELETE
	public void removeEmployee(Employee employee);
}
