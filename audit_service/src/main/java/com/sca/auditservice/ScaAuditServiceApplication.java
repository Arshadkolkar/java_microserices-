/**
 * This is the main class of Audit service.
 */
package com.sca.auditservice;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * @author subhash
 *
 */
@EnableDiscoveryClient
@EnableAsync
@SpringBootApplication
@ComponentScan({ "com.sca.common", "com.sca.auditservice" })
@EntityScan({ "com.sca.dao.domain.common", "com.sca.dao.domain.audit" })
@EnableJpaRepositories("com.sca.dao.repository.audit")
public class ScaAuditServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaAuditServiceApplication.class, args);
	}

	@Configuration
	public class TaskExecutorConfig extends AsyncConfigurerSupport {

		@Override
		public Executor getAsyncExecutor() {
			return new SimpleAsyncTaskExecutor();
		}

	}
}
