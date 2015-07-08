package com.netbuilder.entity_managers;

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
	public PaymentDetails findByNumber(String cardNumber, int customerId);
	public ArrayList<PaymentDetails> getProductsCustomer(int customerId);
		
	//UPDATE
	public void updatePaymentDetails(PaymentDetails paymentDetails);
	
	//DELETE
	public void removePaymentDetails(PaymentDetails paymentDetails);

}
