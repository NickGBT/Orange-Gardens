package com.netbuilder.orange_gardens;

import java.util.Date;

/**
 * 
 * @author mwatson
 *
 */

public class PaymentDetails {

	private enum CardType { 
		VISA, VISADEBIT,VISAELECTRON, MAESTRO, MASTERCARD;
	}
	private CardType cardType;
	private int cardNumber;
	private String nameOnCard;
	private int securityNumber;
	private Date expiryDate;
	private int customerId;
	
	/**
	 * @return the cardType
	 */
	public CardType getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	/**
	 * @return the cardNumber
	 */
	public int getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @return the nameOnCard
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}
	/**
	 * @param nameOnCard the nameOnCard to set
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	/**
	 * @return the securityNumber
	 */
	public int getSecurityNumber() {
		return securityNumber;
	}
	/**
	 * @param securityNumber the securityNumber to set
	 */
	public void setSecurityNumber(int securityNumber) {
		this.securityNumber = securityNumber;
	}
	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
