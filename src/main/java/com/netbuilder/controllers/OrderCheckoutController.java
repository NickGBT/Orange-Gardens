package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Address;
import com.netbuilder.entities.PaymentDetails;

import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entity_managers.interfaces.CustomerManager;
import com.netbuilder.entity_managers.interfaces.AddressManager;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
/**
 * 
 * @author ngilbert
 *
 */

/**
 * 
 * why did i agree to do this class, i'm a fucking idiot.
 *
 */

@Named
@RequestScoped
public class OrderCheckoutController {
	@Inject
	private ProductManager productManager;
	
	private OrderManager orderManager;
	
	private OrderLineManager orderLineManager;
	
	private CustomerManager customerManager;
	
	private AddressManager addressManager;
	
	private PaymentDetailsManager paymentDetailsManager;
	
	private ArrayList<Product> productsInOrder = new ArrayList<Product>();

	public OrderCheckoutController(){
		
		customer = customerManager.findByUserId(); //cookie persisted customer reference
				
		order = orderManager.//persisted basket order, to be changed to a different status when checkout is finished
		
		address = addressManager.findByUserId();//customers registered address, possibly add a checkbox for a different address.
		
		paymentDetails = paymentDetailsManager.findCustomerPaymentDetails();//customers registered payment details, possibly add a checkbox for alternate payment details.
		
		productsInOrder = orderManager.findBasket(); //find order by customer id and basket status.
		
	}
}

