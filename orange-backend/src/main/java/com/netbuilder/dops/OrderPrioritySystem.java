package com.netbuilder.dops;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netbuilder.entities.Order;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author ngilbert
 *
 **/

public class OrderPrioritySystem {

	private OrderManager orders;
	private long milliseconds;
	private long currentTime = System.currentTimeMillis();
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
	private Date datePlaced;
	private Calendar calendar;
	private static final Logger logger = LogManager.getLogger();

	private ArrayList<Order> placedOrders = (ArrayList<Order>) orders.findByStatus(OrderStatus.placed);
	
	/**
	 * @author JustinMabbutt
	 * @param datePlaced
	 * @return the date in milliseconds
	 */
	public long changeDateToMillis(String date)
	{
		try
		{
			datePlaced = dateFormatter.parse(date);
		} 
		catch (ParseException pe) 
		{
			logger.error("Date format incorrect", date);
			pe.printStackTrace();
		}
		calendar.setTime(datePlaced);
		milliseconds = calendar.getTimeInMillis();
		return milliseconds;
	}
	
	/**
	 * This method generates a prioritised queue sorted in blocks of priorities
	 * by arraylists It returns a list of Order objects sorted from highest
	 * priority (critical) to lowest
	 * 
	 **/
	public List<Order> getPrioritisedQueue() {
		ArrayList<Order> lowPriority = new ArrayList<Order>();

		for (Order o : placedOrders) {
			if ((currentTime - changeDateToMillis(o.getDatePlaced())) < 360000) {
				lowPriority.add(o);
			}
		}

		Collections.sort(lowPriority, new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				if (changeDateToMillis(o1.getDatePlaced()) < changeDateToMillis(o2.getDatePlaced()))
					return 1;
				if (changeDateToMillis(o1.getDatePlaced()) > changeDateToMillis(o2.getDatePlaced()))
					return -1;
				return 0;
			}
		});

		ArrayList<Order> mediumPriority = new ArrayList<Order>();

		for (Order o : placedOrders) {
			if ((currentTime - changeDateToMillis(o.getDatePlaced())) < (360000 * 6)
					|| (currentTime - changeDateToMillis(o.getDatePlaced())) > (360000)) {
				mediumPriority.add(o);
			}
		}

		Collections.sort(mediumPriority, new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				if (changeDateToMillis(o1.getDatePlaced()) < changeDateToMillis(o2.getDatePlaced()))
					return 1;
				if (changeDateToMillis(o1.getDatePlaced()) > changeDateToMillis(o2.getDatePlaced()))
					return -1;
				return 0;
			}
		});

		ArrayList<Order> highPriority = new ArrayList<Order>();

		for (Order o : placedOrders) {
			if ((currentTime - changeDateToMillis(o.getDatePlaced())) < (360000 * 24)
					|| (currentTime - changeDateToMillis(o.getDatePlaced())) > (360000 * 6)) {
				highPriority.add(o);
			}
		}

		Collections.sort(highPriority, new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				if (changeDateToMillis(o1.getDatePlaced()) < changeDateToMillis(o2.getDatePlaced()))
					return 1;
				if (changeDateToMillis(o1.getDatePlaced()) > changeDateToMillis(o2.getDatePlaced()))
					return -1;
				return 0;
			}
		});

		ArrayList<Order> criticalPriority = new ArrayList<Order>();

		for (Order o : placedOrders) {
			if ((currentTime - changeDateToMillis(o.getDatePlaced())) < (360000 * 36)) {
				criticalPriority.add(o);
			}
		}

		Collections.sort(criticalPriority, new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				if (changeDateToMillis(o1.getDatePlaced()) < changeDateToMillis(o2.getDatePlaced()))
					return 1;
				if (changeDateToMillis(o1.getDatePlaced()) > changeDateToMillis(o2.getDatePlaced()))
					return -1;
				return 0;
			}
		});

		ArrayList<Order> prioritisedQueue = new ArrayList<Order>();

		for (Order o : criticalPriority) {
			prioritisedQueue.add(o);
		}

		for (Order o : highPriority) {
			prioritisedQueue.add(o);
		}

		for (Order o : mediumPriority) {
			prioritisedQueue.add(o);
		}

		for (Order o : lowPriority) {
			prioritisedQueue.add(o);
		}

		return prioritisedQueue;
	}
}
