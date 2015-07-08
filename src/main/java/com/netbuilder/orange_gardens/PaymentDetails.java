package com.netbuilder.orange_gardens;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author mwatson
 *
 */

@Entity
@Table(name = "payment_details")

public class PaymentDetails {

	private enum CardType {
		VISA, VISADEBIT, VISAELECTRON, MAESTRO, MASTERCARD, AMERICANEXPRESS;
	}

	@Column(name = "card_type", nullable = false)
	@NotNull
	private CardType cardType;

	@Column(name = "card_number", nullable = false)
	@NotNull
	private int cardNumber;

	@Column(name = "name_on_card", nullable = false)
	@NotNull
	@Size(min = 2, max = 45)
	private String nameOnCard;

	@Column(name = "security_number", nullable = false)
	@NotNull
	private int securityNumber;

	@Column(name = "expiry_date", nullable = false)
	@NotNull
	private String expiryDate;

	@Column(name = "employee_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int customerId;

	public PaymentDetails(CardType cardType, int cardNumber, String nameOnCard, int securityNumber, String expiryDate) {

		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.securityNumber = securityNumber;
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the cardType
	 */
	public CardType getCardType() {
		return cardType;
	}

	/**
	 * @param cardType
	 *            the cardType to set
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
	 * @param cardNumber
	 *            the cardNumber to set
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
	 * @param nameOnCard
	 *            the nameOnCard to set
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
	 * @param securityNumber
	 *            the securityNumber to set
	 */
	public void setSecurityNumber(int securityNumber) {
		this.securityNumber = securityNumber;
	}

	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
