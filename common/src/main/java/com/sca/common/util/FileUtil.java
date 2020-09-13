/**
 * 
 */
package com.sca.common.util;

/**
 * 
 * @author subhash
 *
 */
public class FileUtil {

	/**
	 * 
	 * @param fileNameWithExtension
	 * @return
	 */
	public static String removeExtension(String fileNameWithExtension) {

		if (fileNameWithExtension == null) {
			return null;
		}

		int pos = fileNameWithExtension.lastIndexOf(".");
		if (pos > 0) {
			return fileNameWithExtension = fileNameWithExtension.substring(0, pos);
		}

		return fileNameWithExtension;
	}
}
