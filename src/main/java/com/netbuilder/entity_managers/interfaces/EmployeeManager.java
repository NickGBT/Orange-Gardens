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
	public Employee findEmployeeById(int employeeId);
	public ArrayList<Employee> findEmployeesBySurname(String surname);
	public ArrayList<Employee> findEmployeesByNames(String forename, String surname);
	public ArrayList<Employee> findEmployeesByDepartment(EmployeeDepartment department);
	public ArrayList<Employee> findEmployeesByRole(EmployeeDepartment department, EmployeePermissions permission);
	
	//UPDATE
	public void updateEmployee(Employee employee);
	
	//DELETE
	public void removeEmployee(Employee employee);
}
