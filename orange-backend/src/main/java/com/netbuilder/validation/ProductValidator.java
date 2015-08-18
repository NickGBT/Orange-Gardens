package com.netbuilder.validation;

import com.netbuilder.entities.Product;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class ProductValidator
{
	public boolean validateProduct(Product toBeValidated)
	{
		if(toBeValidated.getProductName().length() > 2 && toBeValidated.getProductName().length() < 45)
		{
			if(toBeValidated.getProductPrice() == (double)toBeValidated.getProductPrice())
			{
				if(toBeValidated.getDescription().length() > 20 && toBeValidated.getDescription().length() < 100)
				{
					if(toBeValidated.getWeight() == (double)toBeValidated.getWeight())
					{
						if(toBeValidated.getHeight() == (int)toBeValidated.getHeight())
						{
							if(toBeValidated.getWidth() == (int)toBeValidated.getWidth())
							{
								if(toBeValidated.getLength() == (int)toBeValidated.getLength())
								{
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}