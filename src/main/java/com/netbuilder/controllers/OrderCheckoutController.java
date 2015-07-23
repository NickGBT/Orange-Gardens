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
	/* @Inject
	private ProductManagerAL productManager;
	@Inject
	private OrderManagerAL orderManager;
	@Inject
	private OrderLineManagerAL orderLineManager;
	@Inject
	private CustomerManagerAL customerManager;
	
	private AddressManagerAL addressManager;
	
	private PaymentDetailsManagerAL paymentDetailsManager;
	
	private ArrayList<Product> productsInOrder = new ArrayList<Product>();
	
	private Customer customer;
	
	private Order order;
	


	public OrderCheckoutController(){
		
		customer = customerManager.findByUserId(UserId.getUid()); //cookie persisted customer reference
				
		order = orderManager.findBasket(basket, UserId.getUid());
		
		address = addressManager.findByUserId(UserId.getUid());//customers registered address, possibly add a checkbox for a different address.
		
		paymentDetails = paymentDetailsManager.findCustomerPaymentDetails(UserId.getUid());//customers registered payment details, possibly add a checkbox for alternate payment details.
		
		productsInOrder = orderManager.findBasket(basket, UserId.getUid()); //find order by customer id and basket status.
		
	} */
	
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
