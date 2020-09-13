/**
 * 
 */
package com.sca.common.util;

import org.apache.commons.lang3.EnumUtils;

/**
 * 
 * @author subhash
 *
 */
public enum SQLNumericType {

	INT, SMALLINT, TINYINT, MEDIUMINT, BIGINT, BIT, FLOAT, DOUBLE, DECIMAL;

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isValid(String value) {
		return EnumUtils.isValidEnum(SQLNumericType.class, value.toUpperCase());
	}
}
