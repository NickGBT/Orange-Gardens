package com.netbuilder.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * 
 * @author Alexander Neil
 *
 */
public class LoginDetailsGenerator {
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
	 * Hashes a given password using the provided salt with PBKDF2 with Hmac SHA-1.
	 * @param password Password to be hashed
	 * @param salt 64-bit (8 byte) salt to hash the password
	 * @return 160-character byte array representing the hashed password
	 * @throws NoSuchAlgorithmException In case of an incorrect algorithm name being provided. Is hard coded so should never occur.
	 * @throws InvalidKeySpecException In case the KeySpec is not compatible with the KeyFactory used
	 */
	public static byte[] getEncryptedPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException{
		String algorithm = "PBKDF2WithHmacSHA1";
		 
		int derivedKeyLength = 160;
		
		int iterations = 10000;
		
		KeySpec cryptoKey = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
		
		return keyFactory.generateSecret(cryptoKey).getEncoded();
	}
	
	/**
	 * Compares a password pre-hashed with PBKDF2 Hmac SHA-1 with a new password.
	 * @param hashedPassword Pre hashed password to be checked against
	 * @param salt Salt used to hash the existing password
	 * @param testPassword Password to be tested against the existing hash
	 * @return true if hashed passwords match, else false
	 */
	public static boolean comparePasswords(byte[] hashedPassword, byte[] salt, String testPassword){
		try {
			if(hashedPassword.equals(getEncryptedPassword(testPassword, salt))) return true;
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

	