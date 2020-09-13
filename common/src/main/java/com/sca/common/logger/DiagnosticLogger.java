/**
 * 
 */
package com.sca.common.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author subhash
 *
 */
public class DiagnosticLogger {

	private Logger logger = null;

	/**
	 * 
	 * @param className
	 * @return
	 */
	public static DiagnosticLogger getLogger(String className) {
		return new DiagnosticLogger(className);
	}

	/**
	 * 
	 * @param class1
	 * @return
	 */
	public static DiagnosticLogger getLogger(Class<?> class1) {
		return new DiagnosticLogger(class1);
	}

	private DiagnosticLogger(Class<?> class1) {
		logger = LogManager.getLogger(class1);
	}

	private DiagnosticLogger(String className) {
		logger = LogManager.getLogger(className);
	}

	/**
	 * 
	 * @param exception
	 */
	public void trace(Exception exception) {
		if (exception != null) {
			logger.trace(exception.getMessage(), exception);
		}
	}

	/**
	 * 
	 * @param message
	 */
	public void trace(String message) {
		logger.trace(message);
	}

	/**
	 * 
	 * @param exception
	 */
	public void debug(Exception exception) {
		if (exception != null) {
			logger.debug(exception.getMessage(), exception);
		}
	}

	/**
	 * 
	 * @param message
	 */
	public void debug(String message) {
		logger.debug(message);
	}

	/**
	 * 
	 * @param message
	 * @param objects
	 */
	public void debug(String message, Object... objects) {
		logger.debug(message, objects);
	}

	/**
	 * 
	 * @param message
	 */
	public void info(String message) {
		logger.info(message);
	}

	/**
	 * 
	 * @param message
	 * @param objects
	 */
	public void info(String message, Object... objects) {
		logger.info(message, objects);
	}

	/**
	 * 
	 * @param message
	 */
	public void warn(String message) {
		logger.warn(message);
	}

	/**
	 * 
	 * @param message
	 * @param objects
	 */
	public void warn(String message, Object... objects) {
		logger.warn(message, objects);
	}

	/**
	 * 
	 * @param exception
	 */
	public void error(Exception exception) {
		if (exception != null) {
			logger.error(exception.getMessage(), exception);
		}
	}

	/**
	 * 
	 * @param errorMessage
	 */
	public void error(String errorMessage) {
		logger.error(errorMessage);
	}

	/**
	 * 
	 * @param errorMessage
	 * @param objects
	 */
	public void error(String errorMessage, Object... objects) {
		logger.error(errorMessage, objects);
	}

	/**
	 * 
	 * @param exception
	 */
	public void fatal(Exception exception) {
		if (exception != null) {
			logger.fatal(exception.getMessage(), exception);
		}
	}

	/**
	 * 
	 * @param errorMessage
	 */
	public void fatal(String errorMessage) {
		logger.fatal(errorMessage);
	}

	/**
	 * 
	 * @param errorMessage
	 * @param objects
	 */
	public void fatal(String errorMessage, Object... objects) {
		logger.fatal(errorMessage, objects);
	}

}
