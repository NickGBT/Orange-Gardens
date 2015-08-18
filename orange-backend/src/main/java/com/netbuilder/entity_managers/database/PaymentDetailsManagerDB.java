package com.netbuilder.entity_managers.database;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.persistence_manager.PersistenceManager;

/**
 * 
 * @author Alexander Neil
 *
 */
@Default
@Stateless
public class PaymentDetailsManagerDB implements PaymentDetailsManager {
	@Inject
	private PersistenceManager pm;

	public void persistPaymentDetails(PaymentDetails paymentDetails) {

		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(paymentDetails);
		em.getTransaction().commit();
		pm.closeEntityManager(em);

	}

	public void persistPaymentDetails(List<PaymentDetails> paymentDetails) {

		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for (PaymentDetails p : paymentDetails) {
			em.persist(p);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public PaymentDetails findCardByNumber(String cardNumber) {

		EntityManager em = pm.createEntityManager();
		TypedQuery<PaymentDetails> tq = em.createNamedQuery(PaymentDetails.FIND_BY_CARD_NUMBER, PaymentDetails.class);
		pm.closeEntityManager(em);
		tq.setParameter("cardNo", cardNumber);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public PaymentDetails findCustomerPaymentDetails(int userId) {

		EntityManager em = pm.createEntityManager();
		TypedQuery<PaymentDetails> tq = em.createNamedQuery(PaymentDetails.FIND_BY_CUSTOMER, PaymentDetails.class);
		pm.closeEntityManager(em);
		tq.setParameter("id", userId);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public List<PaymentDetails> findExpiredDetails(int customerId) {

		List<PaymentDetails> results = null;

		EntityManager em = pm.createEntityManager();
		TypedQuery<PaymentDetails> tq = em.createNamedQuery(PaymentDetails.FIND_BY_EXPIRED, PaymentDetails.class);
		pm.closeEntityManager(em);
		tq.setParameter("id", customerId);
		try {
			results = new ArrayList<PaymentDetails>(tq.getResultList());
		} catch (NoResultException nre) {

		}
		return results;
	}

	public PaymentDetails findPaymentDetailsForOrder(int orderId) {

		EntityManager em = pm.createEntityManager();
		TypedQuery<PaymentDetails> tq = em.createNamedQuery(PaymentDetails.FIND_BY_ORDER, PaymentDetails.class);
		pm.closeEntityManager(em);
		tq.setParameter("oId", orderId);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public void removePaymentDetails(PaymentDetails paymentDetails) {

		if (paymentDetails == null) {
			throw new ValidationException("Null product passed!");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(paymentDetails);
		pm.closeEntityManager(em);
	}

}
