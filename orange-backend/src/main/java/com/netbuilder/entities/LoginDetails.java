package com.netbuilder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Alexander Neil
 *
 */
@Entity
@Table(name = "login_details")
@NamedQueries({
	@NamedQuery(name = LoginDetails.FIND_BY_USERNAME, query = "SELECT ld FROM LoginDetails ld WHERE ld.username = :username"),
	@NamedQuery(name = LoginDetails.FIND_BY_EMAIL, query = "SELECT ld FROM LoginDetails ld WHERE ld.email = :email"),
	@NamedQuery(name = LoginDetails.FIND_BY_USER_ID, query = "SELECT ld FROM LoginDetails ld WHERE ld.userId = :userId"),
	@NamedQuery(name = LoginDetails.GET_ALL, query = "SELECT ld FROM LoginDetails ld")})
public class LoginDetails implements Serializable {

	public static final String FIND_BY_USERNAME = "LoginDetails.findByUsername";
	public static final String FIND_BY_EMAIL = "LoginDetails.findByEmail";
	public static final String FIND_BY_USER_ID = "LoginDetails.findByUserId";
	public static final String GET_ALL = "LoginDetails.getAllLoginDetails";

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int userId;
	@Column(name = "username", nullable = false, length = 25)
	@NotNull
	@Size(min = 5, max = 25)
	private String username;
	@Column(name = "email", nullable = false, length = 254)
	@NotNull
	@Size(min = 6, max = 254)
	private String email;
	@Column(name = "password", nullable = false, length = 160)
	@NotNull
	@Size(min = 160, max = 160)
	private byte[] password;
	@Column(name = "salt", nullable = false, length = 8)
	@NotNull
	private byte[] salt;
	@Column(name = "reset_key", nullable = true, length = 32)
	@Size(min = 32, max = 32)
	private String resetKey;
	@Column(name = "reset_date")
	private Date resetDate;

	/**
	 * Instantiates an entity where the userId must be generated when persisted.
	 * 
	 * @param userId
	 *            Generated from the user_id field in the database
	 * @param username
	 *            user's username
	 * @param password
	 *            Hash of the user's password
	 * @param salt
	 *            Salt used to hash the user's password
	 */
	public LoginDetails(String username, String email, byte[] password,
			byte[] salt) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.salt = salt;
	}
	
	public LoginDetails(){}

	/**
	 * Instantiates an entity where the userId is already generated
	 * 
	 * @param userId
	 *            Generated from the user_id field in the database
	 * @param username
	 *            user's username
	 * @param password
	 *            Hash of the user's password
	 * @param salt
	 *            Salt used to hash the user's password
	 */
	public LoginDetails(int userId, String username, String email,
			byte[] password, byte[] salt) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.salt = salt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPassword() {
		return password;
	}

	/**
	 * Sets a new password and salt relating to the password. Must be set as a
	 * pair as every new password requires a new salt
	 * 
	 * @param password
	 *            New hashed password
	 * @param salt
	 *            New salt used to hash the new password
	 */
	public void setNewPasswordAndSalt(byte[] password, byte[] salt) {
		this.password = password;
		this.salt = salt;
	}

	public byte[] getSalt() {
		return salt;
	}

	public String getResetKey() {
		return resetKey;
	}

	public Date getResetDate() {
		return resetDate;
	}

	/**
	 * Sets a reset key for a unique reset URL and the timestamp at which it was
	 * generated.
	 * 
	 * @param resetKey
	 * @param resetDate
	 */
	public void setResetDetails(String resetKey, Date resetDate) {
		this.resetKey = resetKey;
		this.resetDate = resetDate;
	}

}
