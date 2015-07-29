package com.netbuilder.dops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.netbuilder.entities.Order;
import com.netbuilder.entity_managers.arraylist.OrderManagerAL;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author ngilbert
 *
 **/

public class OrderPrioritySystem {

	private OrderManagerAL orders;
	private long currentTime = System.currentTimeMillis();
	
	private ArrayList <Order> placedOrders = (ArrayList<Order>) orders.findByStatus(OrderStatus.placed);
		
	public List<Order> getPrioritisedQueue(){
		ArrayList <Order> lowPriority = new ArrayList <Order>();
		
		for (Order o : placedOrders){
			if ((currentTime - o.getDatePlacedInMillis()) < 360000){
				lowPriority.add(o);
			}
		}
		
		Collections.sort(lowPriority, new Comparator<Order>() {
		    @Override
		    public int compare(Order o1, Order o2) {
		        if (o1.getDatePlacedInMillis() < o2.getDatePlacedInMillis())
		            return 1;
		        if (o1.getDatePlacedInMillis() > o2.getDatePlacedInMillis())
		            return -1;
		        return 0;
		    }
		});
		
		ArrayList <Order> mediumPriority = new ArrayList <Order>();
		
		for (Order o : placedOrders){
			if ((currentTime - o.getDatePlacedInMillis()) < (360000 * 6) || (currentTime - o.getDatePlacedInMillis()) > (360000)){
				mediumPriority.add(o);
			}
		}
		
		Collections.sort(mediumPriority, new Comparator<Order>() {
		    @Override
		    public int compare(Order o1, Order o2) {
		        if (o1.getDatePlacedInMillis() < o2.getDatePlacedInMillis())
		            return 1;
		        if (o1.getDatePlacedInMillis() > o2.getDatePlacedInMillis())
		            return -1;
		        return 0;
		    }
		});
		
		ArrayList <Order> highPriority = new ArrayList <Order>(); 
		
		for (Order o : placedOrders){
			if ((currentTime - o.getDatePlacedInMillis()) < (360000 * 24) || (currentTime - o.getDatePlacedInMillis()) > (360000 * 6)){
				highPriority.add(o);
			}
		}
		
		Collections.sort(highPriority, new Comparator<Order>() {
		    @Override
		    public int compare(Order o1, Order o2) {
		        if (o1.getDatePlacedInMillis() < o2.getDatePlacedInMillis())
		            return 1;
		        if (o1.getDatePlacedInMillis() > o2.getDatePlacedInMillis())
		            return -1;
		        return 0;
		    }
		});
		
		ArrayList <Order> criticalPriority = new ArrayList <Order>();
		
		for (Order o : placedOrders){
			if ((currentTime - o.getDatePlacedInMillis()) < (360000 * 36) || (currentTime - o.getDatePlacedInMillis()) > (360000 * 24)){
				criticalPriority.add(o);
			}
		}
		
		Collections.sort(criticalPriority, new Comparator<Order>() {
		    @Override
		    public int compare(Order o1, Order o2) {
		        if (o1.getDatePlacedInMillis() < o2.getDatePlacedInMillis())
		            return 1;
		        if (o1.getDatePlacedInMillis() > o2.getDatePlacedInMillis())
		            return -1;
		        return 0;
		    }
		});
		
		ArrayList <Order> prioritisedQueue = new ArrayList <Order>();
		
		for (Order o : criticalPriority){
			prioritisedQueue.add(o);
		}
		
		for (Order o : highPriority){
			prioritisedQueue.add(o);
		}
		
		for (Order o : mediumPriority){
			prioritisedQueue.add(o);
		}
		
		for (Order o : lowPriority){
			prioritisedQueue.add(o);
		}
		
		return prioritisedQueue;		
	}
}
