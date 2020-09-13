package com.sca.fileexchange;

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
@ComponentScan({ "com.sca.common", "com.sca.fileexchange" })
@EntityScan({ "com.sca.dao.domain.common", "com.sca.dao.domain.file" })
@EnableJpaRepositories("com.sca.dao.repository.file")
public class ScaFileExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaFileExchangeServiceApplication.class, args);
	}

}
