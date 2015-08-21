package com.netbuilder.jms_tools;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author jtaylor
 *
 */
public class DopsOrder implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<DopsOrderline> dopsOrder = new ArrayList<DopsOrderline>();

	private OrderStatus orderstatus;
	
	public DopsOrder (int orderId, OrderStatus orderstatus, ArrayList<DopsOrderline> dopsOrder)
	{
		this.dopsOrder = dopsOrder;
	}

	public ArrayList<DopsOrderline> getDopsOrder() {
		return dopsOrder;
	}

	public void setDopsOrder(ArrayList<DopsOrderline> dopsOrder) {
		this.dopsOrder = dopsOrder;
	}
	
	/**
	 * @author ngilbert
	 */
	public void setDopsOrderStatus(OrderStatus orderstatus){
		this.orderstatus = orderstatus;
	}
				
}
