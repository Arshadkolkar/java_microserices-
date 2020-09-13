/**
 * 
 */
package com.sca.common.util;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * @author
 *
 */
public class StringUtil {

//	public static String encloseWithQuoteAndJoinAsString(List<String> namesList) {
//		return String.join(",", namesList.stream().map(name -> ("'" + name + "'")).collect(Collectors.toList()));
//	}

	/**
	 * 
	 * @param names
	 * @return
	 */
	public static String encloseWithQuote(String names) {
		return String.join(",",
				Arrays.asList(names.split(",")).stream().map(name -> ("'" + name + "'")).collect(Collectors.toList()));
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static String toLowerAndAddUnderscores(String name) {
		return name.trim().toLowerCase().replaceAll(" ", "_");
	}

//	public static String intArrayToCommaSeparatedString(int[] ids) {
//		return Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
//	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String applyRegEx(String str) {
		String regEx = "/[^a-zA-Z0-9\\-\\s]/";
		return str.trim().replaceAll(regEx, "").toLowerCase();
	}

}
