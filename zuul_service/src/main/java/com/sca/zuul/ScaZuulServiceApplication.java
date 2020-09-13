/**
 * 
 */
package com.sca.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author subhash
 *
 */
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
@ComponentScan({ "com.sca.common", "com.sca.zuul" })
@EntityScan({ "com.sca.dao.domain.common" })
@EnableJpaRepositories("com.sca.dao.repository.aduit")
public class ScaZuulServiceApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScaZuulServiceApplication.class, args);
	}

}
