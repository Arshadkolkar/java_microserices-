/**
 * 
 */
package com.sca.dao.util;

import com.google.common.base.CaseFormat;

/**
 * 
 * @author subhash
 *
 */
public class CaseFormatHelper {

	/**
	 * Convert String from Camel case to Snake case
	 * 
	 * @param input
	 * @return
	 */
	public static String camelToSnakeCase(String input) {
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, input);
	}

	/**
	 * Convert String from Snake case to Camel case
	 * 
	 * @param input
	 * @return
	 */
	public static String snakeToCamelCase(String input) {
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, input);
	}
}
