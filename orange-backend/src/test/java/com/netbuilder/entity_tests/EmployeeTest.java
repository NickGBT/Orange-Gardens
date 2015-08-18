package com.netbuilder.entity_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Employee;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;

public class EmployeeTest {

	Employee testEmployee;

	EmployeeDepartment employeeDepartment;
	String fName;
	String lName;
	int employeeId;
	String password;
	EmployeePermissions employeePermission;

	@Before
	public void setUp() throws Exception {

		employeeDepartment = EmployeeDepartment.sales;
		fName = "Matthew";
		lName = "Watson";
		employeePermission = EmployeePermissions.manager;

		testEmployee = new Employee(employeeDepartment, fName, lName,
				employeePermission);
	}

	@Test
	public void testGetDepartment() {
		assertEquals(testEmployee.getDepartment(), employeeDepartment);
	}

	@Test
	public void testGetfName() {
		assertEquals(testEmployee.getfName(), fName);
	}

	@Test
	public void testGetlName() {
		assertEquals(testEmployee.getlName(), lName);
	}

	@Test
	public void testGetEmployeeId() {
		assertEquals(testEmployee.getEmployee().getUserId(), employeeId);
	}

	@Test
	public void testGetPassword() {
		assertEquals(testEmployee.getEmployee().getPassword(), password);
	}

	@Test
	public void testGetPermission() {
		assertEquals(testEmployee.getPermission(), employeePermission);
	}

}
