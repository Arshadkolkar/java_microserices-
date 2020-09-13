package com.sca.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableDiscoveryClient
@EnableAsync
@SpringBootApplication
@ComponentScan({ "com.sca.common", "com.sca.project" })
@EntityScan({ "com.sca.dao.domain.common", "com.sca.dao.domain.project" })
@EnableJpaRepositories("com.sca.dao.repository.project")
public class ScaProjectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaProjectServiceApplication.class, args);
	}

}
