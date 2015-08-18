package com.netbuilder.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.netbuilder.enums.CardType;

/**
 * 
 * @author mwatson
 *
 */
@Entity
@Table(name = "payment_details")
@NamedQueries({
	@NamedQuery(name = PaymentDetails.FIND_BY_CARD_NUMBER, query = "SELECT pd FROM PaymentDetails pd WHERE pd.cardNumber = :cardNo"),
	@NamedQuery(name = PaymentDetails.FIND_BY_CUSTOMER, query = "SELECT pd FROM PaymentDetails pd WHERE pd.customerId = :id"),
	@NamedQuery(name = PaymentDetails.FIND_BY_EXPIRED, query = "SELECT pd FROM PaymentDetails pd WHERE pd.customerId = :id AND pd.expiryDate < :currentDate")})
public class PaymentDetails implements Serializable {

	public static final String FIND_BY_CARD_NUMBER = "PaymentDetails.findByCardNumber";
	public static final String FIND_BY_CUSTOMER = "PaymentDetails.findByCustomer";
	public static final String FIND_BY_EXPIRED = "PaymentDetails.findByExpired";

	@Column(name = "card_type", nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private CardType cardType;

	@Column(name = "card_number", nullable = false)
	@NotNull
	private String cardNumber;

	@Column(name = "name_on_card", nullable = false)
	@NotNull
	@Size(min = 2, max = 45)
	private String nameOnCard;

	@Column(name = "expiry_date", nullable = false)
	@NotNull
	private String expiryDate;

	@ManyToOne
	@Id
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull
	private LoginDetails customerId;

	public PaymentDetails(CardType cardType, String cardNumber,
			String nameOnCard, int securityNumber, String expiryDate,
			LoginDetails customerId) {
		super();
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.expiryDate = expiryDate;
		this.customerId = customerId;
	}
	
	public PaymentDetails(){}

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
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber
	 *            the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
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
	public LoginDetails getCustomerId() {
		return customerId;
	}


}
