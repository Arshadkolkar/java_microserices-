/**
 * 
 */
package com.sca.common.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * 
 * @author subhash
 *
 */
public class RandomGeneratorUtils {
	static String tokenChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!*+_-";
	static String anonymName = "Kukun4n0nym";
	static String randomChars = "abcdefghijklmnopqrstuvwxyzABCDLMOSTYZ";
	// TODO: CONFIGURE
	static String emailSuffix = "@anonymous.kukun.com";

	/**
	 * 
	 * Generate Random Token
	 * 
	 * @return
	 */
	public static String generateRandomToken() {
		String saltChars = new StringBuilder(tokenChars).append(System.currentTimeMillis()).toString();
		// Get random Salt String of length 32
		String saltString = getSaltString(saltChars, 32);

		return HashingUtils.md5(saltString);
	}

	/**
	 * 
	 * Generate Random UserName
	 * 
	 * @return
	 */
	public static String generateRandomUserName() {
		// Get Salt String of length 4
		String saltString = getSaltString(randomChars, 4);
		saltString = new StringBuilder(anonymName).append(saltString).append(System.currentTimeMillis()).toString();

		return saltString;
	}

	/**
	 * 
	 * Generate Random Password
	 * 
	 * @return
	 */
	public static String generateRandomPassword() {
		return getSaltString(randomChars, 6);
	}

	/**
	 * 
	 * Generate Random Password with time
	 * 
	 * @return
	 */
	public static String generateRandomPasswordWithTime() {
		return getSaltString(randomChars, 6).concat(String.valueOf(System.currentTimeMillis()));
	}

	/**
	 * 
	 * Generate Random Md5 Password
	 * 
	 * @return
	 */
	public static String generateRandomMd5Password() {
		// Get Salt String of length 6
		String saltString = getSaltString(randomChars, 6);
		saltString = new StringBuilder(saltString).append(System.currentTimeMillis()).toString();

		return HashingUtils.md5(saltString);
	}

	/**
	 * 
	 * Generate Random FirstName
	 * 
	 * @return
	 */
	public static String generateRandomFirstName() {
		// Get Salt String of length between 4 and 20
		String saltString = getSaltString(randomChars, getRandomNumber(4, 20));

		return saltString;
	}

	/**
	 * 
	 * Generate Random LastName
	 * 
	 * @return
	 */
	public static String generateRandomLastName() {
		// Get Salt String of length between 5 and 25
		String saltString = getSaltString(randomChars, getRandomNumber(5, 25));

		return saltString;
	}

	/**
	 * Get Email based on the userName passed
	 * 
	 * @param userName
	 * @return
	 */
	public static String generateRandomEmail(String userName) {
		String randomEmail = new StringBuilder(userName).append(emailSuffix).toString();

		return randomEmail;
	}

	/**
	 * 
	 * Generate Activation Key
	 * 
	 * @return
	 */
	public static String generateActivationKey(String userName, String userEmail) {
		String saltString = new StringBuilder(userName).append(userEmail).append(System.currentTimeMillis()).toString();

		return HashingUtils.md5(saltString);
	}

	/**
	 * 
	 * Generate Random Salt String
	 * 
	 * @param saltChars
	 * @param length
	 * @return
	 */
	public static String getSaltString(String saltChars, int length) {
		StringBuilder salt = new StringBuilder();
		SecureRandom rnd = new SecureRandom();

		while (salt.length() < length) {
			salt.append(saltChars.charAt(rnd.nextInt(saltChars.length())));
		}

		return salt.toString();
	}

	/**
	 * Get random number based on the range passed
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandomNumber(int min, int max) {
		Random rand = new Random();

		return min + rand.nextInt(max);
	}

	/**
	 * 
	 * @return
	 */
	// $filename = sha1(mt_rand(1, 9999) .self::$destination.uniqid()) . time();
	public static String generateRandomFileName() {
		// Get Salt String of length between 1 and 25
		String saltString = new StringBuilder(getSaltString(randomChars, getRandomNumber(1, 25)))
				.append(System.currentTimeMillis()).toString();

		return HashingUtils.md5(saltString);
	}
}
