/**
 * 
 */
package com.sca.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author subhash
 *
 */
public class HashingUtils {

	/**
	 * 
	 * @param input
	 * @return
	 */
	public static String md5(String input) {
		String result = input;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(result.getBytes());
			byte[] digest = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}

}
