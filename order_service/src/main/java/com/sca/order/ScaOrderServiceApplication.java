/**
 * 
 */
package com.sca.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * @author
 *
 */
@EnableDiscoveryClient
@EnableAsync
@SpringBootApplication
@EntityScan({ "com.sca.dao.domain"})
@ComponentScan({ "com.sca.common", "com.sca.order","com.sca.fems" })
@EnableJpaRepositories("com.sca.dao.repository")
public class ScaOrderServiceApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScaOrderServiceApplication.class, args);
	}

}
