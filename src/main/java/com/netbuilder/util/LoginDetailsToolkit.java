package com.netbuilder.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.netbuilder.entities.LoginDetails;

/**
 * 
 * @author Alexander Neil
 *
 */
public class LoginDetailsToolkit {
	/**
	 * Generates a new 8-byte salt.
	 * @return Secure 8-byte array for the salt
	 * @throws NoSuchAlgorithmException Should never be thrown as the algorithm for the CPRNG is hard-coded
	 */
	public static byte[] generateSalt() throws NoSuchAlgorithmException{
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		
		return salt;
	}
	
	/**
	 * Generates a unique key to be used in the password reset URL.
	 * Uses the userId, current date to seconds accuracy and username and converts it to an md5 hash to use as the URL key.
	 * @param details User details requiring a password reset
	 */
	public static void generateResetKey(LoginDetails details){
		
		Date currDate = new Date();
		DateFormat df = new SimpleDateFormat("MMddyyHHmmss");
		String input = details.getUserId() + df.format(currDate) + details.getUsername();		
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes(), 0, input.length());
			String md5Key = new BigInteger(1, digest.digest()).toString(16);
			
			details.setResetDetails(md5Key, currDate);

			
		} catch (NoSuchAlgorithmException e) {
			//Should never occur as instance is hardcoded to MD5
			e.printStackTrace();
		}
	}
	
	/**
	 * Hashes a given password using the provided salt with PBKDF2 with Hmac SHA-1.
	 * @param password Password to be hashed
	 * @param salt 64-bit (8 byte) salt to hash the password
	 * @return 160-character byte array representing the hashed password
	 * @throws NoSuchAlgorithmException In case of an incorrect algorithm name being provided. Is hard coded so should never occur.
	 * @throws InvalidKeySpecException In case the KeySpec is not compatible with the KeyFactory used
	 */
	public static byte[] getHashedPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException{
		String algorithm = "PBKDF2WithHmacSHA1";
		 
		int derivedKeyLength = 160;
		
		int iterations = 10000;
		
		KeySpec cryptoKey = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
		
		return keyFactory.generateSecret(cryptoKey).getEncoded();
	}
	
	/**
	 * Changes the password for a set of login details.
	 * Generates a new random salt for the password, hashes the password and stores it and the salt in the details
	 * @param details Set of login details requiring a password change
	 * @param password New password to be set for the login details
	 */
	public static void setNewPassword(LoginDetails details, String password){
		byte[] newSalt;
		byte[] newHashedPassword;
		try {
			newSalt = generateSalt();
			newHashedPassword = getHashedPassword(password, newSalt);
			
			details.setNewPasswordAndSalt(newHashedPassword, newSalt);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Compares a password pre-hashed with PBKDF2 Hmac SHA-1 with a new password.
	 * @param hashedPassword Pre hashed password to be checked against
	 * @param salt Salt used to hash the existing password
	 * @param testPassword Password to be tested against the existing hash
	 * @return true if hashed passwords match, else false
	 */
	public static boolean checkPassword(LoginDetails details, String testPassword){
		try {
			if(details.getPassword().equals(getHashedPassword(testPassword, details.getSalt()))) return true;
			else return false;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return false;
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
			return false;
		}
	}
}

	