/**
 * 
 */
package com.sca.notification;

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
@ComponentScan({ "com.sca.common", "com.sca.notification" })
@EntityScan({ "com.sca.dao.domain.common", "com.sca.dao.domain.notification" })
@EnableJpaRepositories("com.sca.dao.repository.notification")
public class ScaNotificationServiceApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScaNotificationServiceApplication.class, args);
	}

}
