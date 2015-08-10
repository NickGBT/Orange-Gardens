package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import com.netbuilder.entities.Employee;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;

/**
 * 
 * @author Alexander Neil
 *
 */
public interface EmployeeManager {

	// CREATE
	public void persistEmployee(Employee employee);

	public void persistEmployees(List<Employee> employees);

	// READ
	public List<Employee> getAll();

	public Employee findEmployeeById(int userId);

	public List<Employee> findEmployeesBySurname(String surname);

	public List<Employee> findEmployeesByNames(String forename, String surname);

	public List<Employee> findEmployeesByDepartment(
			EmployeeDepartment department);

	public List<Employee> findEmployeesByRole(EmployeeDepartment department,
			EmployeePermissions permission);

	// UPDATE
	public void updateEmployee(Employee employee);

	// DELETE
	public void removeEmployee(Employee employee);
}
