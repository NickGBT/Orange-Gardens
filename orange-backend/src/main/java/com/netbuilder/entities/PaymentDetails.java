package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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
		@NamedQuery(name = PaymentDetails.FIND_BY_CARD_NUMBER, query = "SELECT pd FROM payment_details pd WHERE pd.card_number = :cardNo;"),
		@NamedQuery(name = PaymentDetails.FIND_BY_CUSTOMER, query = "SELECT pd FROM payment_detais pd WHERE pd.customer_id = :id;"),
		@NamedQuery(name = PaymentDetails.FIND_BY_EXPIRED, query = "SELECT pd FROM payment_details pd WHERE pd.customer_id = :id AND expiry_date < CURRENT_DATE();"),
		@NamedQuery(name = PaymentDetails.FIND_BY_ORDER, query = "SELECT pd FROM payment_details pd WHERE order_id = :oId;") })
public class PaymentDetails {

	public static final String FIND_BY_CARD_NUMBER = "PaymentDetails.findByCardNumber";
	public static final String FIND_BY_CUSTOMER = "PaymentDetails.findByCustomer";
	public static final String FIND_BY_EXPIRED = "PaymentDetails.findByExpired";
	public static final String FIND_BY_ORDER = "PaymentDetails.findByOrder";

	@Column(name = "card_type", nullable = false)
	@NotNull
	private CardType cardType;

	@Column(name = "card_number", nullable = false)
	@NotNull
	private String cardNumber;

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

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull
	private LoginDetails customerId;

	@OneToOne
	@JoinColumn(name = "order_id", nullable = true)
	@Null
	private Order orderId;

	public PaymentDetails(CardType cardType, String cardNumber,
			String nameOnCard, int securityNumber, String expiryDate,
			LoginDetails customerId, Order orderId) {
		super();
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.securityNumber = securityNumber;
		this.expiryDate = expiryDate;
		this.customerId = customerId;
		this.orderId = orderId;
	}

	public PaymentDetails(CardType cardType, String cardNumber,
			String nameOnCard, int securityNumber, String expiryDate,
			LoginDetails customerId) {
		super();
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.securityNumber = securityNumber;
		this.expiryDate = expiryDate;
		this.customerId = customerId;
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
	public LoginDetails getCustomerId() {
		return customerId;
	}

	/**
	 * @return the orderId
	 */
	public Order getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

}
