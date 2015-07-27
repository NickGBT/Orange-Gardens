package com.netbuilder.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.Address;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.AddressManager;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.util.UserId;
import com.netbuilder.util.OrderDetails;
/**
 * 
 * @author ngilbert
 *
 *
 **/

@Named
@RequestScoped
public class OrderCheckoutController {
	
	@Inject
	private OrderDetails order;
	public List<OrderLine> orderLines = new ArrayList<OrderLine>();
	private AddressManager address;	
	private PaymentDetailsManager paymentDetails;

	 
	public List<OrderLine> getBasket(){
		return order.getBasket();
	}
	
	public PaymentDetails getPaymentDetails(){
		return paymentDetails.findCustomerPaymentDetails(UserId.getUid());
	}
	
	public Address getAddress(){
		return address.findByUserId(UserId.getUid()); 
	} 
}
