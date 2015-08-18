package com.netbuilder.jms_tools;

import java.io.Serializable;
import java.util.ArrayList;


public class DopsOrderline implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productName;
	private String quantity;
	private String boxSize;
	private ArrayList<GladosNode> path;
	
	public DopsOrderline(String productName, String quantity, String boxSize, ArrayList<GladosNode> path) {

		this.productName = productName;
		this.quantity = quantity;
		this.boxSize = boxSize;
		this.setPath(path);
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

	public ArrayList<GladosNode> getPath() {
		return path;
	}

	public void setPath(ArrayList<GladosNode> path) {
		this.path = path;
	}
}
