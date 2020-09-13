/**
 * 
 */
package com.sca.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 
 * @author subhash
 *
 */
public class NumberUtil {

	public static BigDecimal getBigDecimal(Object value) {

		BigDecimal ret = null;
		if (value != null) {
			if (value instanceof BigDecimal) {
				ret = (BigDecimal) value;
			} else if (value instanceof String) {
				ret = new BigDecimal((String) value);
			} else if (value instanceof BigInteger) {
				ret = new BigDecimal((BigInteger) value);
			} else if (value instanceof Number) {
				ret = new BigDecimal(((Number) value).doubleValue());
			} else {
				throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass()
						+ " into a BigDecimal.");
			}
		}

		return ret;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static double getDouble(Object value) {

		if (value instanceof Number) {
			return ((Number) value).doubleValue();
		}

		return 0.0;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static long getLong(Object value) {

		if (value instanceof Number) {
			return ((Number) value).longValue();
		}

		return 0;
	}

	/**
	 * 
	 * @param totalRecordCount
	 * @param pageSize
	 * @return
	 */
	public static int getTotalPagesCount(int totalRecordCount, int pageSize) {
		return (int) Math.ceil((double) totalRecordCount / (double) pageSize);
	}
}
