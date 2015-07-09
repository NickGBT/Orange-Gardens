package com.netbuilder.entity_managers.arraylist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Employee;
import com.netbuilder.entities.Order;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.enums.OrderStatus;

public class OrderManagerAL implements OrderManager {

	private ArrayList<Order> orders = new ArrayList<Order>();
	
	public void persistOrder(Order order) {
		this.orders.add(order);
		
	}

	public void persistOrder(ArrayList<Order> order) {
		this.orders.addAll(order);
		
	}

	public Order findByOrderID(int orderID) {
		
		for(Order o : orders) {
			if(o.getOrderID() == orderID) {
				return o;
			}
		}
		
		return null;
	}

	public ArrayList<Order> findByStatus(OrderStatus status) {
		
		ArrayList<Order> orderResults = new ArrayList<Order>(); 
		
		for (Order o : orders) {
			if(o.getOrderStatus() == status) {
				orderResults.add(o);
			}
		}
		
		return orderResults;
	}

	public ArrayList<Order> findByDatePlaced(String datePlaced) {
		ArrayList<Order> orderResults = new ArrayList<Order>(); 
		
		for (Order o : orders) {
			if(o.getDatePlaced().equals(datePlaced)) {
				orderResults.add(o);
			}
		}
		
		return orderResults;
	}

	public ArrayList<Order> findByDateDispatched(String dateDispatched) {
		ArrayList<Order> orderResults = new ArrayList<Order>(); 
		
		for (Order o : orders) {
			if(o.getDateDispatched().equals(dateDispatched)) {
				orderResults.add(o);
			}
		}
		
		return orderResults;
	}

	public ArrayList<Order> findByDateDelivered(String dateDelivered) {
		ArrayList<Order> orderResults = new ArrayList<Order>(); 
		
		for (Order o : orders) {
			if(o.getDateDelivered().equals(dateDelivered)) {
				orderResults.add(o);
			}
		}
		return orderResults;
	}

	public ArrayList<Order> findByTwoDatesOrderPlaced(String firstDate, String secondDate) {
		ArrayList<Order> orderResults = new ArrayList<Order>(); 
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date fDate = dateFormatter.parse(firstDate);
			Date sDate = dateFormatter.parse(secondDate);
			
			for (Order o : orders) {
			
				Date oDate = dateFormatter.parse(o.getDatePlaced());
				
				if(oDate.compareTo(fDate) > 0 && oDate.compareTo(sDate) < 0) {
					orderResults.add(o);
				}
			}
		}
		catch(Exception e) {
			//Error
		}
		
		return orderResults;
	}

	public ArrayList<Order> findByTwoDatesOrderDespatched(String firstDate, String secondDate) {
		ArrayList<Order> orderResults = new ArrayList<Order>(); 
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date fDate = dateFormatter.parse(firstDate);
			Date sDate = dateFormatter.parse(secondDate);
			
			for (Order o : orders) {
			
				
				Date oDate = dateFormatter.parse(o.getDateDispatched());
				
				if(oDate.compareTo(fDate) > 0 && oDate.compareTo(sDate) < 0) {
					orderResults.add(o);
				}
			}
		}
		catch(Exception e) {
			//Error
		}
		
		return orderResults;
	}

	public ArrayList<Order> findByTwoDatesOrderDelivered(String firstDate, String secondDate) {
		ArrayList<Order> orderResults = new ArrayList<Order>(); 
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date fDate = dateFormatter.parse(firstDate);
			Date sDate = dateFormatter.parse(secondDate);
			
			for (Order o : orders) {
			
				
				Date oDate = dateFormatter.parse(o.getDateDelivered());
				
				if(oDate.compareTo(fDate) > 0 && oDate.compareTo(sDate) < 0) {
					orderResults.add(o);
				}
			}
		}
		catch(Exception e) {
			//Error
		}
		
		return orderResults;
	}

	public Order findByCustomerId(int customerId) {
		for(Order o : orders) {
			
			if(o.getCustomer().getCustomerID() == customerId) {
				return o;
			}
		}
		
		return null;
	}

	public Order findByEmployeeId(int employeeId) {
		
		for(Order o : orders) {
			if(o.getEmployee().getEmployeeId() == employeeId) {
				return o;
			}
		}
		
		return null;
	}

	public Order getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void updateWishList(Order order) {
		for(Order o: orders) {
			if (o.getOrderID() == order.getOrderID()){
				orders.set(orders.indexOf(o), order);
				return;
			}
		}
	}

}
