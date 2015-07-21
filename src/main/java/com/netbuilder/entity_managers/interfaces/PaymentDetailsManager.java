package com.netbuilder.entity_managers.interfaces;

import java.util.ArrayList;

import com.netbuilder.entities.PaymentDetails;

/**
 * 
 * @author Alexander Neil
 *
 */

public interface PaymentDetailsManager {
	
	//CREATE
	public void persistPaymentDetails(PaymentDetails paymentDetails);
	public void persistPaymentDetails(ArrayList<PaymentDetails> paymentDetails);
	
	//READ
	public PaymentDetails findCardByNumber(String cardNumber);
	public PaymentDetails findCustomerPaymentDetails(int userId);
	public ArrayList<PaymentDetails> findExpiredDetails(int userId);
	public PaymentDetails findPaymentDetailsForOrder(int orderId);
	
		
	//UPDATE
	//public void updatePaymentDetails(PaymentDetails paymentDetails);
	
	//DELETE
	public void removePaymentDetails(PaymentDetails paymentDetails);

}
