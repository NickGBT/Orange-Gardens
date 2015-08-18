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
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.persistence_manager.PersistenceManager;
import com.netbuilder.validation.PaymentDetailsValidator;

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
	
	private PaymentDetailsValidator paymentDetailsValidator;

	public void persistPaymentDetails(PaymentDetails paymentDetails) {
		
		if(paymentDetailsValidator.validatePaymentDetails(paymentDetails))
		{
			EntityManager em = pm.createEntityManager();
			em.getTransaction().begin();
			em.persist(paymentDetails);
			em.getTransaction().commit();
			pm.closeEntityManager(em);
		}
		else
		{
			//do something (maybe)
		}
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
		tq.setParameter("cardNo", cardNumber);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
		finally{
			pm.closeEntityManager(em);
		}
	}

	public PaymentDetails findCustomerPaymentDetails(LoginDetails customer) {

		EntityManager em = pm.createEntityManager();
		TypedQuery<PaymentDetails> tq = em.createNamedQuery(PaymentDetails.FIND_BY_CUSTOMER, PaymentDetails.class);
		tq.setParameter("id", customer);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
		finally {
			pm.closeEntityManager(em);
		}
	}

	public List<PaymentDetails> findExpiredDetails(int customerId) {

		List<PaymentDetails> results = null;

		EntityManager em = pm.createEntityManager();
		TypedQuery<PaymentDetails> tq = em.createNamedQuery(PaymentDetails.FIND_BY_EXPIRED, PaymentDetails.class);
		tq.setParameter("id", customerId);
		try {
			results = new ArrayList<PaymentDetails>(tq.getResultList());
		} catch (NoResultException nre) {

		}
		pm.closeEntityManager(em);
		return results;
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
