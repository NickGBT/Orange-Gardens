package com.netbuilder.entity_managers.database;

import java.util.ArrayList;

import com.netbuilder.entities.PaymentDetails;

public class PaymentDetailsManager implements com.netbuilder.entity_managers.interfaces.PaymentDetailsManager {

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

	public ArrayList<PaymentDetails> getExpiredDetails(int customerId, String date) {
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
