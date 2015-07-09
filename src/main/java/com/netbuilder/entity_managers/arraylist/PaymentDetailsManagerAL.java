package com.netbuilder.entity_managers.arraylist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;

/**
 * 
 * @author Alexander Neil
 *
 */
public class PaymentDetailsManagerAL implements PaymentDetailsManager {

	List<PaymentDetails> paymentDetails = new ArrayList<PaymentDetails>();
	
	public void persistPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails.add(paymentDetails);
	}

	public void persistPaymentDetails(ArrayList<PaymentDetails> paymentDetails) {
		this.paymentDetails.addAll(paymentDetails);
	}

	public PaymentDetails findCardByNumber(String cardNumber, int customerId) {
		for(PaymentDetails pd: paymentDetails){
			if((pd.getCardNumber() == cardNumber)&&(pd.getCustomerId().getCustomerID() == customerId)) return pd;
		}
		return null;
	}

	public ArrayList<PaymentDetails> getCustomerPaymentDetails(int customerId) {
		ArrayList<PaymentDetails> results = new ArrayList<PaymentDetails>();
		
		for(PaymentDetails pd: paymentDetails){
			if(pd.getCustomerId().getCustomerID() == customerId) results.add(pd);
		}
		return results;
	}

	public ArrayList<PaymentDetails> getExpiredDetails(int customerId, String date) {
		
		ArrayList<PaymentDetails> results = new ArrayList<PaymentDetails>();
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			Date currentDate = new Date();
			
			for(PaymentDetails pd: paymentDetails){
				Date expDate = dateFormatter.parse(pd.getExpiryDate());
				
				if(expDate.compareTo(currentDate) < 0){
					results.add(pd);
				}
				
			}
		}
		catch(Exception e){
			//Error parsing date
		}

		return results;

	}

	public PaymentDetails getPaymentDetailsForOrder(int orderId) {

		for(PaymentDetails pd: paymentDetails){
			if(pd.getOrderId().getOrderID() == orderId) return pd;
		}
		return null;
	}
/*
	public void updatePaymentDetails(PaymentDetails paymentDetails) {
		
	}
*/
	public void removePaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails.remove(paymentDetails);
	}

}
