package com.netbuilder.orange_gardens;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author mwatson
 *
 */


@Entity
@Table(name = "employee")


public class Employee {

	public Employee(Department department, String fName, String lName, int employeeId, String password,
			Permission permission) {
		this.department = department;
		this.fName = fName;
		this.lName = lName;
		this.employeeId = employeeId;
		this.password = password;
		this.permission = permission;
	}

	private enum Department {
		SALES, WAREHOUSE;
	}

	private enum Permission {
		MANAGER, WORKER;
	}

	
	@Column(name = "department", nullable = false)
	@NotNull
	private Department department;

	@Column(name = "fname", nullable = false, length = 20)
	@NotNull
	@Size(min = 1, max = 20)
	private String fName;

	@Column(name = "sname", nullable = false, length = 45)
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
	@Size(min = 6, max =16)
	private String password;
	
	@Column(name = "permissions", nullable = false)
	@NotNull
	private Permission permission;

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
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
	public Permission getPermission() {
		return permission;
	}

	/**
	 * @param permission
	 *            the permission to set
	 */
	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}
