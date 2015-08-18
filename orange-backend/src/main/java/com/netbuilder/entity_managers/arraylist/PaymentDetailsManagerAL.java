package com.netbuilder.entity_managers.arraylist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;

/**
 * 
 * @author Alexander Neil
 *
 */
@Alternative
@Singleton
public class PaymentDetailsManagerAL implements PaymentDetailsManager {

	private List<PaymentDetails> paymentDetails = new ArrayList<PaymentDetails>();

	public void persistPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails.add(paymentDetails);
	}

	public void persistPaymentDetails(List<PaymentDetails> paymentDetails) {
		this.paymentDetails.addAll(paymentDetails);
	}

	public PaymentDetails findCardByNumber(String cardNumber) {
		for (PaymentDetails pd : paymentDetails) {
			if (pd.getCardNumber() == cardNumber)
				return pd;
		}
		return null;
	}

	public PaymentDetails findCustomerPaymentDetails(LoginDetails customer) {

		for (PaymentDetails pd : paymentDetails) {
			if (pd.getCustomerId().getUserId() == customer.getUserId())
				return pd;
		}
		return null;
	}

	public List<PaymentDetails> findExpiredDetails(int customerId) {

		List<PaymentDetails> results = new ArrayList<PaymentDetails>();

		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-yy");

		try {
			Date currentDate = new Date();

			for (PaymentDetails pd : paymentDetails) {
				Date expDate = dateFormatter.parse(pd.getExpiryDate());

				if (expDate.compareTo(currentDate) < 0) {
					results.add(pd);
				}

			}
		} catch (Exception e) {
			// Error parsing date
		}

		return results;

	}

//	public PaymentDetails findPaymentDetailsForOrder(int orderId) {
//
//		for (PaymentDetails pd : paymentDetails) {
//			try {
//				if (pd.getOrderId().getOrderID() == orderId)
//					return pd;
//			} catch (NullPointerException npe) {
//				// No orderId for these payment details
//			}
//		}
//		return null;
//	}

	/*
	 * public void updatePaymentDetails(PaymentDetails paymentDetails) {
	 * 
	 * }
	 */
	public void removePaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails.remove(paymentDetails);
	}

}
