/**
 * 
 */
package com.sca.payment;

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
@ComponentScan({ "com.sca.common", "com.sca.payment" })
@EntityScan({ "com.sca.dao.domain.common", "com.sca.dao.domain.payment", "com.sca.dao.domain.security" })
@EnableJpaRepositories("com.sca.dao.repository.payment")
public class ScaPaymentServiceApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScaPaymentServiceApplication.class, args);
	}

}
