package com.netbuilder.entity_managers.database;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.entities.Employee;
import com.netbuilder.entity_managers.interfaces.EmployeeManager;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;
import com.netbuilder.persistence_manager.PersistenceManager;
import com.netbuilder.validation.EmployeeValidator;

/**
 * 
 * @author Alexander Neil
 *
 */
@Default
@Stateless
public class EmployeeManagerDB implements EmployeeManager {
	@Inject
	private PersistenceManager pm;
	
	private EmployeeValidator employeeValidator;

	public void persistEmployee(Employee employee) {

		//if(employeeValidator.validateEmployee(employee))
		//{
			EntityManager em = pm.createEntityManager();
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
			pm.closeEntityManager(em);
		//}
	}

	public void persistEmployees(List<Employee> employees) {

		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for (Employee e : employees) {
			em.persist(e);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);

	}

	public List<Employee> getAll() {
		List<Employee> results = null;

		EntityManager em = pm.createEntityManager();
		TypedQuery<Employee> tq = em.createNamedQuery(Employee.GET_ALL, Employee.class);
		try {
			results = new ArrayList<Employee>(tq.getResultList());
		} catch (NoResultException nre) {
			nre.printStackTrace();
		}
		pm.closeEntityManager(em);
		return results;
	}

	public Employee findEmployeeById(int userId) {

		EntityManager em = pm.createEntityManager();
		TypedQuery<Employee> tq = em.createNamedQuery(Employee.FIND_BY_USER_ID, Employee.class);
		tq.setParameter("id", userId);
		pm.closeEntityManager(em);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			nre.printStackTrace();
			return null;
		}
	}

	public List<Employee> findEmployeesBySurname(String surname) {

		List<Employee> results = null;

		EntityManager em = pm.createEntityManager();
		TypedQuery<Employee> tq = em.createNamedQuery(Employee.FIND_BY_SURNAME, Employee.class);
		tq.setParameter("surname", surname);
		pm.closeEntityManager(em);
		try {
			results = new ArrayList<Employee>(tq.getResultList());
		} catch (NoResultException nre) {
			nre.printStackTrace();
		}
		return results;
	}

	public List<Employee> findEmployeesByNames(String forename, String surname) {

		List<Employee> results = null;

		EntityManager em = pm.createEntityManager();
		TypedQuery<Employee> tq = em.createNamedQuery(Employee.FIND_BY_NAMES, Employee.class);
		tq.setParameter("forename", forename);
		tq.setParameter("surname", surname);
		pm.closeEntityManager(em);
		try {
			results = new ArrayList<Employee>(tq.getResultList());
		} catch (NoResultException nre) {
			nre.printStackTrace();
		}
		return results;
	}

	public List<Employee> findEmployeesByDepartment(EmployeeDepartment department) {

		List<Employee> results = null;

		EntityManager em = pm.createEntityManager();
		TypedQuery<Employee> tq = em.createNamedQuery(Employee.FIND_BY_DEPARTMENT, Employee.class);
		tq.setParameter("department", department);
		pm.closeEntityManager(em);
		try {
			results = new ArrayList<Employee>(tq.getResultList());
		} catch (NoResultException nre) {
			nre.printStackTrace();
		}
		return results;
	}

	public List<Employee> findEmployeesByRole(EmployeeDepartment department,
			EmployeePermissions permission) {

		List<Employee> results = null;

		EntityManager em = pm.createEntityManager();
		TypedQuery<Employee> tq = em.createNamedQuery(Employee.FIND_BY_NAMES, Employee.class);
		tq.setParameter("department", department);
		tq.setParameter("permission", permission);
		pm.closeEntityManager(em);
		try {
			results = new ArrayList<Employee>(tq.getResultList());
		} catch (NoResultException nre) {
			nre.printStackTrace();
		}
		return results;
	}

	public void updateEmployee(Employee employee) {

		if (employee == null) {
			throw new ValidationException("Null product passed!");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(employee);
		pm.closeEntityManager(em);
	}

	public void removeEmployee(Employee employee) {

		if (employee == null) {
			throw new ValidationException("Null product passed!");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(employee);
		pm.closeEntityManager(em);

	}

}
