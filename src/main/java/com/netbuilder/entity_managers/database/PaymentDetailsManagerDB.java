package com.netbuilder.entity_managers.database;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.orange_gardens.PersistenceManager;

@Default
@Stateless
public class PaymentDetailsManagerDB implements PaymentDetailsManager {
	@Inject
	private PersistenceManager pm;
	
	public void persistPaymentDetails(PaymentDetails paymentDetails) {
		// TODO Auto-generated method stub

	}

	public void persistPaymentDetails(ArrayList<PaymentDetails> paymentDetails) {
		// TODO Auto-generated method stub

	}

	public PaymentDetails findCardByNumber(String cardNumber, int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PaymentDetails> getCustomerPaymentDetails(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PaymentDetails> getExpiredDetails(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public PaymentDetails getPaymentDetailsForOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removePaymentDetails(PaymentDetails paymentDetails) {
		// TODO Auto-generated method stub

	}

}
