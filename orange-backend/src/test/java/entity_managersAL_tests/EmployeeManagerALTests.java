package entity_managersAL_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netbuilder.entities.Employee;
import com.netbuilder.entity_managers.arraylist.EmployeeManagerAL;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;

/**
 * 
 * @author Alexander Neil
 *
 */
public class EmployeeManagerALTests {

	EmployeeManagerAL employeeManager;
	Employee e1;
	Employee e2;
	Employee e3;
	Employee e4;

	ArrayList<Employee> testInput;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		employeeManager = new EmployeeManagerAL();

		e1 = new Employee(EmployeeDepartment.warehouse, "Ware", "House",
				EmployeePermissions.manager);
		e2 = new Employee(EmployeeDepartment.warehouse, "Slave", "Labor",
				EmployeePermissions.worker);
		e3 = new Employee(EmployeeDepartment.warehouse, "Shelf", "Picker",
				EmployeePermissions.worker);
		e4 = new Employee(EmployeeDepartment.sales, "Telephone", "House",
				EmployeePermissions.manager);

		testInput = new ArrayList<Employee>();

		testInput.add(e1);
		testInput.add(e2);
		testInput.add(e3);
		testInput.add(e4);
	}

	@Test
	public void testPersistAndRetrieve() {
		employeeManager.persistEmployee(e1);

		Employee testE = employeeManager.findEmployeeById(e1.getEmployee()
				.getUserId());

		assertEquals(testE, e1);
	}

	@Test
	public void testMultiplePersistAndGetAll() {

		employeeManager.persistEmployees(testInput);

		assertEquals(testInput.size(), employeeManager.getAll().size());
	}

	@Test
	public void testMultiplePersistAndFindByDepartment() {

		employeeManager.persistEmployees(testInput);

		List<Employee> output = employeeManager
				.findEmployeesByDepartment(EmployeeDepartment.warehouse);

		assertTrue((output.contains(e1)) && (output.contains(e2))
				&& !(output.contains(e4)));
	}

	@Test
	public void testUpdateEmployeeAndRetrieve() {
		employeeManager.persistEmployee(e1);

		employeeManager.updateEmployee(e3);

		Employee sample = employeeManager.findEmployeeById(e1.getEmployee()
				.getUserId());

		assertNotEquals(e1, sample);
	}

	@Test
	public void testRemoveEmployee() {

		employeeManager.persistEmployees(testInput);

		employeeManager.removeEmployee(e1);

		Employee output = employeeManager.findEmployeeById(e1.getEmployee()
				.getUserId());

		assertNull(output);
	}

	@Test
	public void testFindEmployeesBySurname() {

		employeeManager.persistEmployees(testInput);

		List<Employee> output = employeeManager.findEmployeesBySurname("House");

		assertTrue(output.size() == 2);
	}

	@Test
	public void testfindEmployeesByRole() {

		employeeManager.persistEmployees(testInput);

		List<Employee> output = employeeManager.findEmployeesByRole(
				EmployeeDepartment.warehouse, EmployeePermissions.worker);

		assertTrue(output.size() == 2);
	}

}
