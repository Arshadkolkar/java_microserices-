/**
 * 
 */
package com.sca.common.util;

/**
 * 
 * @author subhash
 *
 */
public class EntityHelper {

	/**
	 * 
	 * @param externalName
	 * @return
	 */
	public static String buildInternalName(String externalName) {
		return externalName.toLowerCase().replaceAll(" ", "_");
	}

}
