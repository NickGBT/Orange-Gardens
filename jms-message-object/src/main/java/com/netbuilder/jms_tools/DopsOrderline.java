package com.netbuilder.jms_tools;

import java.io.Serializable;

/**
 * 
 * @author jtaylor
 *
 */
public class DopsOrderline implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productName;
	private String quantity;
	private String boxSize;
	private GladosNode productLocation;
	
	public DopsOrderline(String productName, String quantity, String boxSize, GladosNode productLocation) {

		this.productName = productName;
		this.quantity = quantity;
		this.boxSize = boxSize;
		this.productLocation = productLocation;
	}
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getBoxSize() {
		return boxSize;
	}
	public void setBoxSize(String boxSize) {
		this.boxSize = boxSize;
	}
	
	public GladosNode getProductLocation() {
		return productLocation;
	}


	public void setProductLocation(GladosNode productLocation) {
		this.productLocation = productLocation;
	}

	
}
