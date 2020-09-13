/**
 * 
 */
package com.sca.common.util;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 
 * @author subhash
 *
 */
public class ValidationUtil {

	/**
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isValidEmail(String email) {
		if (email == null || email.trim().isEmpty())
			return false;

		Pattern pat = Pattern.compile(Constants.REGEX_EMAIL_FORMAT);

		return pat.matcher(email).matches();
	}

	/**
	 * 
	 * @param <E>
	 * @param enumClass
	 * @param enumName
	 * @return
	 */
	public static <E extends Enum<E>> boolean isValidEnum(final Class<E> enumClass, final String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(enumClass, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * 
	 * @param value
	 * @param validValues
	 * @return
	 */
	public static boolean isArrayContains(String value, List<String> validValues) {
		if (!validValues.stream().anyMatch(validValue -> validValue.equals(value != null ? value.trim() : value))) {
			return false;
		}

		return true;
	}

}
