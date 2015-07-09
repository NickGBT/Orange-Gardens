package com.netbuilder.entity_managers;

import java.util.ArrayList;

import com.netbuilder.entities.Delivery;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class DeliveryManagerAL implements DeliveryManager
{
	private ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
	
	public void persistDelivery(Delivery delivery)
	{
		deliveries.add(delivery);
	}

	public void persistDeliveries(ArrayList<Delivery> deliveries)
	{
		deliveries.addAll(deliveries);
	}

	public Delivery findByDatePlaced(String datePlaced)
	{
		for(Delivery d: deliveries)
		{
			if(d.getDatePlaced() == datePlaced)
			{
				return d;
			}
		}
		return null;
	}

	public Delivery findByDeliveryID(int deliveryID) 
	{
		for(Delivery d: deliveries)
		{
			if(d.getDeliveryID() == deliveryID)
			{
				return d;
			}
		}
		return null;
	}

	public ArrayList<Delivery> getDeliveries()
	{
		ArrayList<Delivery> results = new ArrayList<Delivery>();
		return null;
	}

	public void updateDelivery(Delivery delivery)
	{
		for(Delivery d: deliveries)
		{
			if(d.getDeliveryID() == delivery.getDeliveryID())
			{
				deliveries.set(deliveries.indexOf(d), delivery);
			}
		}
	}

	public void removeDelivery(Delivery delivery)
	{
		for(Delivery d: deliveries)
		{
			if(d.getDeliveryID() == delivery.getDeliveryID())
			{
				deliveries.remove(deliveries.indexOf(d));
			}
		}
	}
}
