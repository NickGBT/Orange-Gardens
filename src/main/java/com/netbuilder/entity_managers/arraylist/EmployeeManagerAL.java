package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import com.netbuilder.entities.Employee;
import com.netbuilder.entity_managers.interfaces.EmployeeManager;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;

/**
 * 
 * @author Alexander Neil
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

	public Employee getEmployeeById(int employeeId) {
		for(Employee e: employees){
			if(e.getEmployeeId() == employeeId) return e;
		}
		return null;
	}

	public ArrayList<Employee> getEmployeesBySurname(String surname) {
		ArrayList<Employee> results = new ArrayList<Employee>();
		
		for(Employee e: employees){
			if(e.getlName().equals(surname)) results.add(e);
		}
		return results;
	}

	public ArrayList<Employee> getEmployeesByForename(String forename) {
		ArrayList<Employee> results = new ArrayList<Employee>();
		
		for(Employee e: employees){
			if(e.getfName().equals(forename)) results.add(e);
		}
		
		return results;
	}

	public ArrayList<Employee> getEmployeesByNames(String forename, String surname) {
		ArrayList<Employee> results = new ArrayList<Employee>();
		
		for(Employee e: employees){
			if(e.getfName().equals(forename)&&e.getlName().equals(surname)) results.add(e);
		}
		
		return results;
	}

	public ArrayList<Employee> getEmployeesByDepartment(EmployeeDepartment department) {
		ArrayList<Employee> results = new ArrayList<Employee>();
		
		for(Employee e: employees){
			if(e.getDepartment() == department) results.add(e);
		}
		
		return results;
	}

	public ArrayList<Employee> getEmployeesByRole(EmployeeDepartment department, EmployeePermissions position) {
		ArrayList<Employee> results = new ArrayList<Employee>();
		
		for(Employee e: employees){
			if((e.getDepartment() == department)&&(e.getPermission() == position)) results.add(e);
		}
		
		return results;
	}

	public void updateEmployee(Employee employee) {
		for(Employee e: employees){
			if(e.getEmployeeId() == employee.getEmployeeId()){
				employees.set(employees.indexOf(e), employee);
				return;
			}
		}
	}

	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

	
	
}
