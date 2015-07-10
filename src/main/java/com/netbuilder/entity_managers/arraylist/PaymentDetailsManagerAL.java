package com.netbuilder.entity_managers.arraylist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.orange_gardens.PersistenceManager;

/**
 * 
 * @author Alexander Neil
 *
 */
@Alternative
@Stateless
public class PaymentDetailsManagerAL implements PaymentDetailsManager {
	
	private List<PaymentDetails> paymentDetails = new ArrayList<PaymentDetails>();
	
	public void persistPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails.add(paymentDetails);
	}

	public void persistPaymentDetails(ArrayList<PaymentDetails> paymentDetails) {
		this.paymentDetails.addAll(paymentDetails);
	}

	public PaymentDetails findCardByNumber(String cardNumber) {
		for(PaymentDetails pd: paymentDetails){
			if(pd.getCardNumber() == cardNumber) return pd;
		}
		return null;
	}

	public ArrayList<PaymentDetails> findCustomerPaymentDetails(int customerId) {
		ArrayList<PaymentDetails> results = new ArrayList<PaymentDetails>();
		
		for(PaymentDetails pd: paymentDetails){
			if(pd.getCustomerId().getCustomerID() == customerId) results.add(pd);
		}
		return results;
	}

	public ArrayList<PaymentDetails> findExpiredDetails(int customerId) {
		
		ArrayList<PaymentDetails> results = new ArrayList<PaymentDetails>();
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-yy");
		
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

	public PaymentDetails findPaymentDetailsForOrder(int orderId) {

		for(PaymentDetails pd: paymentDetails){
			try{
				if(pd.getOrderId().getOrderID() == orderId) return pd;
			}
			catch(NullPointerException npe){
				//No orderId for these payment details
			}
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
