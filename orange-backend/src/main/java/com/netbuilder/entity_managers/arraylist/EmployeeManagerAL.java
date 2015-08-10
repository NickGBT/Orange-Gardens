package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.Employee;
import com.netbuilder.entity_managers.interfaces.EmployeeManager;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;

/**
 * 
 * @author Alexander Neil
 *
 */

@Alternative
@Stateless
public class EmployeeManagerAL implements EmployeeManager {

	private ArrayList<Employee> employees = new ArrayList<Employee>();

	public void persistEmployee(Employee employee) {
		employees.add(employee);

	}

	public void persistEmployees(List<Employee> employees) {
		this.employees.addAll(employees);

	}

	public List<Employee> getAll() {
		return employees;
	}

	public Employee findEmployeeById(int userId) {
		for (Employee e : employees) {
			if (e.getEmployee().getUserId() == userId)
				return e;
		}
		return null;
	}

	public List<Employee> findEmployeesBySurname(String surname) {
		List<Employee> results = new ArrayList<Employee>();

		for (Employee e : employees) {
			if (e.getlName().equals(surname))
				results.add(e);
		}
		return results;
	}

	public List<Employee> findEmployeesByNames(String forename, String surname) {
		List<Employee> results = new ArrayList<Employee>();

		for (Employee e : employees) {
			if (e.getfName().equals(forename) && e.getlName().equals(surname))
				results.add(e);
		}

		return results;
	}

	public List<Employee> findEmployeesByDepartment(
			EmployeeDepartment department) {
		List<Employee> results = new ArrayList<Employee>();

		for (Employee e : employees) {
			if (e.getDepartment() == department)
				results.add(e);
		}

		return results;
	}

	public List<Employee> findEmployeesByRole(EmployeeDepartment department,
			EmployeePermissions permission) {
		List<Employee> results = new ArrayList<Employee>();

		for (Employee e : employees) {
			if ((e.getDepartment() == department)
					&& (e.getPermission() == permission))
				results.add(e);
		}

		return results;
	}

	public void updateEmployee(Employee employee) {
		for (Employee e : employees) {
			if (e.getEmployee().getUserId() == employee.getEmployee()
					.getUserId()) {
				employees.set(employees.indexOf(e), employee);
			}
		}
	}

	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

}
