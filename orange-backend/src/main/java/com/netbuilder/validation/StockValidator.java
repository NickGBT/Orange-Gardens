package com.netbuilder.validation;

import com.netbuilder.entities.Stock;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class StockValidator 
{
	public boolean validateStock(Stock toBeValidated)
	{
		if(toBeValidated.getStockLevel() == (int)toBeValidated.getStockLevel())
		{
			if(toBeValidated.getStockAvailable() == (int)toBeValidated.getStockAvailable())
			{
				if(toBeValidated.getCriticalThreshold() == (int)toBeValidated.getCriticalThreshold())
				{
					if(toBeValidated.getRequiredStock() == (int)toBeValidated.getRequiredStock())
					{
						if(toBeValidated.getWarehouseX() == (int)toBeValidated.getWarehouseX())
						{
							if(toBeValidated.getWarehouseY() == (int)toBeValidated.getWarehouseY())
							{
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
}