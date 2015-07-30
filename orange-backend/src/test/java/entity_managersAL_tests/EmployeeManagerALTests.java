package entity_managersAL_tests;

import static org.junit.Assert.*;

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
		
		e1 = new Employee(EmployeeDepartment.WAREHOUSE, "Ware", "House", EmployeePermissions.MANAGER);
		e2 = new Employee(EmployeeDepartment.WAREHOUSE, "Slave", "Labor", EmployeePermissions.WORKER);
		e3 = new Employee(EmployeeDepartment.WAREHOUSE, "Shelf", "Picker", EmployeePermissions.WORKER);
		e4 = new Employee(EmployeeDepartment.SALES, "Telephone", "House", EmployeePermissions.MANAGER);
		
		
		testInput = new ArrayList<Employee>();
		
		testInput.add(e1);
		testInput.add(e2);
		testInput.add(e3);
		testInput.add(e4);
	}

	@Test
	public void testPersistAndRetrieve() {
		employeeManager.persistEmployee(e1);
		
		Employee testE = employeeManager.findEmployeeById(e1.getEmployee().getUserId());
		
		assertEquals(testE, e1);
	}

	@Test
	public void testMultiplePersistAndGetAll(){
		
		employeeManager.persistEmployees(testInput);
		
		assertEquals(testInput.size(), employeeManager.getAll().size());
	}
	
	@Test
	public void testMultiplePersistAndFindByDepartment(){
		
		employeeManager.persistEmployees(testInput);
		
		List<Employee> output = employeeManager.findEmployeesByDepartment(EmployeeDepartment.WAREHOUSE);
		
		assertTrue((output.contains(e1))&&(output.contains(e2))&&!(output.contains(e4)));
	}
	
	@Test
	public void testUpdateEmployeeAndRetrieve(){
		employeeManager.persistEmployee(e1);
		
		employeeManager.updateEmployee(e3);
		
		Employee sample = employeeManager.findEmployeeById(e1.getEmployee().getUserId());
		
		assertNotEquals(e1, sample);
	}
	
	@Test
	public void testRemoveEmployee(){
		
		employeeManager.persistEmployees(testInput);
		
		employeeManager.removeEmployee(e1);
		
		Employee output = employeeManager.findEmployeeById(e1.getEmployee().getUserId());
		
		assertNull(output);
	}
	
	@Test
	public void testFindEmployeesBySurname(){
		
		employeeManager.persistEmployees(testInput);
		
		List<Employee> output = employeeManager.findEmployeesBySurname("House");
		
		assertTrue(output.size()==2);
	}
	
	@Test
	public void testfindEmployeesByRole(){
		
		employeeManager.persistEmployees(testInput);
		
		List<Employee> output = employeeManager.findEmployeesByRole(EmployeeDepartment.WAREHOUSE, EmployeePermissions.WORKER);
		
		assertTrue(output.size()==2);
	}
	


}
