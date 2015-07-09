package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.Delivery;
import com.netbuilder.entity_managers.interfaces.DeliveryManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Alternative
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

	public ArrayList<Delivery> findByDatePlaced(String datePlaced)
	{
		ArrayList<Delivery> results = new ArrayList<Delivery>();
		for(Delivery d: deliveries)
		{
			if(d.getDatePlaced().contains(datePlaced))
			{
				results.add(d);
			}
		}
		return results;
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
		return deliveries;
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
