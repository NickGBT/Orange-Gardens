package com.netbuilder.jms_tools;

import java.io.Serializable;
import java.util.ArrayList;

public class DopsOrder implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<DopsOrderline> dopsOrder = new ArrayList<DopsOrderline>();
	
	public DopsOrder (ArrayList<DopsOrderline> dopsOrder)
	{
		this.dopsOrder = dopsOrder;
	}

	public ArrayList<DopsOrderline> getDopsOrder() {
		return dopsOrder;
	}

	public void setDopsOrder(ArrayList<DopsOrderline> dopsOrder) {
		this.dopsOrder = dopsOrder;
	}
	
	
}
