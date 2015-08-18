package com.netbuilder.entity_managers.arraylist;

/**
 * @author mwatson llew
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import com.netbuilder.entities.Order;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.enums.OrderStatus;

@Alternative
@Singleton
public class OrderManagerAL implements OrderManager {

	private ArrayList<Order> orders = new ArrayList<Order>();

	public void persistOrder(Order order) {
		this.orders.add(order);

	}

	public Order findByOrderID(int orderID) {

		for (Order o : orders) {
			if (o.getOrderID() == orderID) {
				return o;
			}
		}

		return null;
	}

	public Order findByStatusAndId(OrderStatus status, int customerId) {

		for (Order o : orders) {
			if (o.getOrderStatus() == status && o.getCustomer().getUserId() == customerId) {
				return o;
			}
		}
		return null;
	}
	
	public List<Order> findByStatus(OrderStatus status) {
		List<Order> orderResults = new ArrayList<Order>();

		for (Order o : orders) {
			if (o.getOrderStatus().equals(status)) {
				orderResults.add(o);
			}
		}

		if (orderResults.isEmpty()) {
			return null;
		} else
			return orderResults;
	}

	public List<Order> findByDatePlaced(String datePlaced) {
		List<Order> orderResults = new ArrayList<Order>();

		for (Order o : orders) {
			if (o.getDatePlaced().equals(datePlaced)) {
				orderResults.add(o);
			}
		}

		if (orderResults.isEmpty()) {
			return null;
		} else
			return orderResults;
	}

	/**
	 * 
	 * @author ngilbert
	 *
	 **/

//	public List<Order> findByDatePlacedInMillis(long datePlacedInMillis) {
//		List<Order> orderResults = new ArrayList<Order>();
//
//		for (Order o : orders) {
//			if (o.getDatePlacedInMillis() == datePlacedInMillis) {
//				orderResults.add(o);
//			}
//		}
//
//		if (orderResults.isEmpty()) {
//			return null;
//		} else
//			return orderResults;
//	}

	public List<Order> findByDateDispatched(String dateDispatched) {
		List<Order> orderResults = new ArrayList<Order>();

		for (Order o : orders) {
			if (o.getDateDispatched().equals(dateDispatched)) {
				orderResults.add(o);
			}
		}

		if (orderResults.isEmpty()) {
			return null;
		} else
			return orderResults;
	}

	public List<Order> findByDateDelivered(String dateDelivered) {
		List<Order> orderResults = new ArrayList<Order>();

		for (Order o : orders) {
			if (o.getDateDelivered().equals(dateDelivered)) {
				orderResults.add(o);
			}
		}
		if (orderResults.isEmpty()) {
			return null;
		} else
			return orderResults;
	}

	public List<Order> findByTwoDatesOrderPlaced(String firstDate,
			String secondDate) {
		List<Order> orderResults = new ArrayList<Order>();

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date fDate = dateFormatter.parse(firstDate);
			Date sDate = dateFormatter.parse(secondDate);

			for (Order o : orders) {

				Date oDate = dateFormatter.parse(o.getDatePlaced());

				if (oDate.compareTo(fDate) > 0 && oDate.compareTo(sDate) < 0) {
					orderResults.add(o);
				}
			}
		} catch (Exception e) {
			// Error
		}

		if (orderResults.isEmpty()) {
			return null;
		} else
			return orderResults;
	}

	public List<Order> findByTwoDatesOrderDispatched(String firstDate,
			String secondDate) {
		List<Order> orderResults = new ArrayList<Order>();

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date fDate = dateFormatter.parse(firstDate);
			Date sDate = dateFormatter.parse(secondDate);

			for (Order o : orders) {

				Date oDate = dateFormatter.parse(o.getDateDispatched());

				if (oDate.compareTo(fDate) > 0 && oDate.compareTo(sDate) < 0) {
					orderResults.add(o);
				}
			}
		} catch (Exception e) {
			// Error
		}

		if (orderResults.isEmpty()) {
			return null;
		} else
			return orderResults;
	}

	public List<Order> findByTwoDatesOrderDelivered(String firstDate,
			String secondDate) {
		List<Order> orderResults = new ArrayList<Order>();

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date fDate = dateFormatter.parse(firstDate);
			Date sDate = dateFormatter.parse(secondDate);

			for (Order o : orders) {

				Date oDate = dateFormatter.parse(o.getDateDelivered());

				if (oDate.compareTo(fDate) > 0 && oDate.compareTo(sDate) < 0) {
					orderResults.add(o);
				}
			}
		} catch (Exception e) {
			// Error
		}

		if (orderResults.isEmpty()) {
			return null;
		} else
			return orderResults;
	}

	public List<Order> findByCustomerId(int customerId) {
		List<Order> orderResults = new ArrayList<Order>();

		for (Order o : orders) {

			if (o.getCustomer().getUserId() == customerId) {
				orderResults.add(o);
			}
		}

		if (orderResults.isEmpty()) {
			return null;
		} else
			return orderResults;

	}

	public List<Order> findByEmployeeId(int employeeId) {

		List<Order> orderResults = new ArrayList<Order>();

		for (Order o : orders) {
			if (o.getEmployee().getUserId() == employeeId) {
				orderResults.add(o);
			}
		}

		if (orderResults.isEmpty()) {
			return null;
		} else
			return orderResults;
	}

	public void updateWishList(Order order) {
		for (Order o : orders) {
			if (o.getOrderID() == order.getOrderID()) {
				orders.set(orders.indexOf(o), order);
				return;
			}
		}
	}

	public void updateOrder(Order order) {
		for (Order o : orders) {
			if (o.getOrderID() == order.getOrderID()) {
				orders.set(orders.indexOf(o), order);
			}
		}
	}

	public List<Order> getAllOrders() {
		return orders;
	}

	@Override
	public Order findBasketByUsername(OrderStatus status, String username) {
		for (Order o : orders) {
			if (o.getOrderStatus().equals(status)
					&& (o.getCustomer().getUsername().equals(username))) {
				return o;
			}
		}
		return null;
	}

	public List<Order> findPreviousOrders(OrderStatus status, String username) {
		List<Order> prevOrders = new ArrayList<Order>();

		for (Order o : orders) {
			if (o.getOrderStatus().equals(status)
					&& (o.getCustomer().getUsername().equals(username))) {
				prevOrders.add(o);
			}
		}
		return prevOrders;
	}

}
