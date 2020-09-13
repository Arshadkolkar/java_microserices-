/**
 * 
 */
package com.sca.common.util;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author subhash
 *
 */
public class JUnitUtil {

	/**
	 * To check current thread is running for JUnit tests
	 * 
	 * @return
	 */
	public static boolean isJUnitTest() {
		
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		List<StackTraceElement> list = Arrays.asList(stackTrace);
		for (StackTraceElement element : list) {
			if (element.getClassName().startsWith("org.junit.")) {
				return true;
			}
		}

		return false;
	}
}
