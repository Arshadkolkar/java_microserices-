/**
 * 
 */
package com.sca.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author subhash
 *
 */
@SpringBootApplication
public class ScaDaoApplication {

	final static Logger logger = LoggerFactory.getLogger(ScaDaoApplication.class);

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		logger.debug("***** STARTING SCADaoApplication *****");

		SpringApplication.run(ScaDaoApplication.class, args);

		logger.debug("***** SCAApplication STARTED *****");
	}

}
