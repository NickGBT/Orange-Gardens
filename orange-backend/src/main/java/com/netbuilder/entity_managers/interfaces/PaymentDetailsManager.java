package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import javax.faces.bean.RequestScoped;

import com.netbuilder.entities.PaymentDetails;

/**
 * 
 * @author Alexander Neil
 *
 */
@RequestScoped
public interface PaymentDetailsManager {

	// CREATE
	public void persistPaymentDetails(PaymentDetails paymentDetails);

	public void persistPaymentDetails(List<PaymentDetails> paymentDetails);

	// READ
	public PaymentDetails findCardByNumber(String cardNumber);

	public PaymentDetails findCustomerPaymentDetails(int userId);

	public List<PaymentDetails> findExpiredDetails(int userId);

//	public PaymentDetails findPaymentDetailsForOrder(int orderId);

	// UPDATE
	// public void updatePaymentDetails(PaymentDetails paymentDetails);

	// DELETE
	public void removePaymentDetails(PaymentDetails paymentDetails);

}
