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

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.persistence_manager.PersistenceManager;
import com.netbuilder.util.LoginDetailsToolkit;

/**
 * 
 * @author Alexander Neil
 *
 */
@Default
@Stateless
public class LoginDetailsManagerDB implements LoginDetailsManager {
	@Inject
	private PersistenceManager pm;

	public void persistLoginDetails(LoginDetails details) {

		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(details);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public LoginDetails findByUsername(String username) {

		EntityManager em = pm.createEntityManager();
		TypedQuery<LoginDetails> tq = em.createNamedQuery(LoginDetails.FIND_BY_USERNAME, LoginDetails.class);
		tq.setParameter("username", username);
		pm.closeEntityManager(em);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public LoginDetails findByEmail(String email) {

		EntityManager em = pm.createEntityManager();
		TypedQuery<LoginDetails> tq = em.createNamedQuery(LoginDetails.FIND_BY_EMAIL, LoginDetails.class);
		tq.setParameter("email", email);
		pm.closeEntityManager(em);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public LoginDetails findByUserId(int userId) {

		EntityManager em = pm.createEntityManager();
		TypedQuery<LoginDetails> tq = em.createNamedQuery(LoginDetails.FIND_BY_USER_ID, LoginDetails.class);
		tq.setParameter("userId", userId);
		pm.closeEntityManager(em);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public int checkPassword(String name, String password) {

		LoginDetails result;

		if (LoginDetailsToolkit.isEmail(name)) {
			result = findByEmail(name);
		} else {
			result = findByUsername(name);
		}

		if (result != null) {
			if (LoginDetailsToolkit.checkPassword(result, password))
				return result.getUserId();
		}
		return -1;
	}

	public void updateLoginDetails(LoginDetails details) {

		if (details == null) {
			throw new ValidationException("Null details passed!");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(details);
		pm.closeEntityManager(em);

	}

	public void deleteLoginDetails(LoginDetails details) {

		if (details == null) {
			throw new ValidationException("Null details passed!");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(details);
		pm.closeEntityManager(em);

	}

	public List<LoginDetails> getAllLoginDetails() {
		EntityManager em = pm.createEntityManager();
		List<LoginDetails> allLoginDetails = (ArrayList<LoginDetails>) em.createQuery("SELECT a FROM login_details a", LoginDetails.class).getResultList();
		pm.closeEntityManager(em);
		return allLoginDetails;
	}

}
