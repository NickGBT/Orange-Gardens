package com.netbuilder.validation;

import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.enums.CardType;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class PaymentDetailsValidator
{
	public boolean validatePaymentDetails(PaymentDetails toBeValidated)
	{
		if(toBeValidated.getCardType().getClass().isEnum())
		{
			if(toBeValidated.getCardNumber().length() == 16)
			{
				if(toBeValidated.getNameOnCard().length() > 2 && toBeValidated.getNameOnCard().length() < 45)
				{
					if(toBeValidated.getExpiryDate().length() == 10)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}