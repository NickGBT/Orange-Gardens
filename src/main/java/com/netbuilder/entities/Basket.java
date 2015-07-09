package com.netbuilder.entities;

/**
 * @author llew
 */

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "basket")
public class Basket {

	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false)
	@NotNull
	private Customer customerID;

	private ArrayList<BasketLine> basketLine;

	public Basket(Customer customerID, ArrayList<BasketLine> basketLine) {
		this.customerID = customerID;
		this.basketLine = basketLine;
	}

	public Customer getCustomer() {
		return customerID;
	}

	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}

	public ArrayList<BasketLine> getProducts() {
		return basketLine;
	}

	public void setProducts(ArrayList<BasketLine> product) {
		this.basketLine = product;
	}

	public Basket getBasket() {
		return this;
	}

}
