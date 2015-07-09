package com.netbuilder.entity_managers.database;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.entities.Employee;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.EmployeeManager;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;
import com.netbuilder.orange_gardens.PersistenceManager;

@Default
@Stateless
public class EmployeeManagerDB implements EmployeeManager {
	@Inject
	private PersistenceManager pm;
	
	public void persistEmployee(Employee employee) {
		
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public void persistEmployees(ArrayList<Employee> employees) {
		
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for(Employee e: employees){
			em.persist(e);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);

	}

	public Employee getEmployeeById(int employeeId) {
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Employee> tq = em.createNamedQuery(Employee.FIND_BY_EMPLOYEE_ID, Employee.class);
		pm.closeEntityManager(em);
		tq.setParameter("id", employeeId);
		try{
			return tq.getSingleResult();
		}
		catch(NoResultException nre){
			return null;
		}
	}

	public ArrayList<Employee> getEmployeesBySurname(String surname) {

		ArrayList<Employee> results = null;
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Employee> tq = em.createNamedQuery(Employee.FIND_BY_SURNAME, Employee.class);
		pm.closeEntityManager(em);
		tq.setParameter("surname", surname);
		try{
			results = new ArrayList<Employee>(tq.getResultList());
		}
		catch(NoResultException nre){
			
		}
		return results;
	}

	public ArrayList<Employee> getEmployeesByNames(String forename, String surname) {
		
		ArrayList<Employee> results = null;
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Employee> tq = em.createNamedQuery(Employee.FIND_BY_NAMES, Employee.class);
		pm.closeEntityManager(em);
		tq.setParameter("forename", forename);
		tq.setParameter("surname", surname);
		try{
			results = new ArrayList<Employee>(tq.getResultList());
		}
		catch(NoResultException nre){
			
		}
		return results;
	}

	public ArrayList<Employee> getEmployeesByDepartment(EmployeeDepartment department) {

		ArrayList<Employee> results = null;
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Employee> tq = em.createNamedQuery(Employee.FIND_BY_DEPARTMENT, Employee.class);
		pm.closeEntityManager(em);
		tq.setParameter("department", department);

		try{
			results = new ArrayList<Employee>(tq.getResultList());
		}
		catch(NoResultException nre){
			
		}
		return results;
	}

	public ArrayList<Employee> getEmployeesByRole(EmployeeDepartment department, EmployeePermissions permission) {

		ArrayList<Employee> results = null;
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Employee> tq = em.createNamedQuery(Employee.FIND_BY_NAMES, Employee.class);
		pm.closeEntityManager(em);
		tq.setParameter("department", department);
		tq.setParameter("permission", permission);
		try{
			results = new ArrayList<Employee>(tq.getResultList());
		}
		catch(NoResultException nre){
			
		}
		return results;
	}

	public void updateEmployee(Employee employee) {
		
		if(employee == null){
			throw new ValidationException("Null product passed!");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(employee);
		pm.closeEntityManager(em);
	}

	public void removeEmployee(Employee employee) {

		if(employee == null){
			throw new ValidationException("Null product passed!");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(employee);
		pm.closeEntityManager(em);

	}

}
