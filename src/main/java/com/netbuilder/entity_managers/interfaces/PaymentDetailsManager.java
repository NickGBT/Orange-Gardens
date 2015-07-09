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
	public ArrayList<PaymentDetails> getCustomerPaymentDetails(int customerId);
	public ArrayList<PaymentDetails> getExpiredDetails(int customerId);
	public PaymentDetails getPaymentDetailsForOrder(int orderId);
	
		
	//UPDATE
	//public void updatePaymentDetails(PaymentDetails paymentDetails);
	
	//DELETE
	public void removePaymentDetails(PaymentDetails paymentDetails);

}
