package com.netbuilder.entities;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;

/**
 * 
 * @author mwatson
 *
 */

@Entity
@Table(name = "employee")
@NamedQueries({
	@NamedQuery(name = Employee.GET_ALL, query= "SELECT e FROM employee e"),
	@NamedQuery(name = Employee.FIND_BY_EMPLOYEE_ID, query= "SELECT e FROM employee e WHERE e.employee_id = :id;"),
	@NamedQuery(name = Employee.FIND_BY_SURNAME, query= "SELECT e FROM employee e WHERE MATCH (e.lname) AGAINST (':surname');"),
	@NamedQuery(name = Employee.FIND_BY_NAMES, query= "SELECT e from employee e WHERE MATCH (e.fname) AGAINST (':forename') AND MATCH (e.lname) AGAINST (':surname');"),
	@NamedQuery(name = Employee.FIND_BY_DEPARTMENT, query= "SELECT e from employee e WHERE e.departent = :department;"),
	@NamedQuery(name = Employee.FIND_BY_ROLE, query= "SELECT e from employee e WHERE e.departent = :department AND e.permissions = :permission;"),
	
})

public class Employee {
	
	public static final String GET_ALL = "Employee.getAll";
	public static final String FIND_BY_EMPLOYEE_ID = "Employee.findByEmployeeId";
	public static final String FIND_BY_SURNAME = "Employee.findBySurname";
	public static final String FIND_BY_NAMES = "Employee.findByNames";
	public static final String FIND_BY_DEPARTMENT = "Employee.findByDepartment";
	public static final String FIND_BY_ROLE = "Employee.findByDepartment";

	@Column(name = "department", nullable = false)
	@NotNull
	private EmployeeDepartment employeeDepartment;

	@Column(name = "fname", nullable = false, length = 20)
	@NotNull
	@Size(min = 1, max = 20)
	private String fName;

	@Column(name = "lname", nullable = false, length = 45)
	@NotNull
	@Size(min = 1, max = 45)
	private String lName;

	@Id
	@Column(name = "employee_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int employeeId;

	@Column(name = "password", nullable = false)
	@NotNull
	@Size(min = 6, max = 16)
	private String password;

	@Column(name = "permissions", nullable = false)
	@NotNull
	private EmployeePermissions employeePermission;

	public Employee(EmployeeDepartment employeeDepartment, String fName, String lName, String password, EmployeePermissions employeePermission) {
		this.employeeDepartment = employeeDepartment;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.employeePermission = employeePermission;
	}

	/**
	 * @return the department
	 */
	public EmployeeDepartment getDepartment() {
		return employeeDepartment;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(EmployeeDepartment employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName
	 *            the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName
	 *            the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the permission
	 */
	public EmployeePermissions getPermission() {
		return employeePermission;
	}

	/**
	 * @param permission
	 *            the permission to set
	 */
	public void setPermission(EmployeePermissions employeePermission) {
		this.employeePermission = employeePermission;
	}

}
