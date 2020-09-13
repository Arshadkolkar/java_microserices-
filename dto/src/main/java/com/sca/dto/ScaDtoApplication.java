/**
 * 
 */
package com.sca.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sca.dao.ScaDaoApplication;

/**
 * 
 * @author subhash
 *
 */
@SpringBootApplication
public class ScaDtoApplication {
	final static Logger logger = LoggerFactory.getLogger(ScaDaoApplication.class);

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		logger.debug("***** STARTING SCADTOApplication *****");
		SpringApplication.run(ScaDtoApplication.class, args);

		logger.debug("***** SCAApplication STARTED *****");
	}

}
