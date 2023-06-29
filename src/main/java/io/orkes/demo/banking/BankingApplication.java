package io.orkes.demo.banking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.conductor.common.config.ObjectMapperProvider;
import io.orkes.conductor.client.ApiClient;
import io.orkes.conductor.client.TaskClient;
import io.orkes.conductor.client.WorkflowClient;
import io.orkes.conductor.client.http.OrkesTaskClient;
import io.orkes.conductor.client.http.OrkesWorkflowClient;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@AllArgsConstructor
@SpringBootApplication
@ComponentScan(basePackages = {"io.orkes"})
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

	// ObjectMapper instance used for JSON serialization - can be modified to configure additional modules
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapperProvider().getObjectMapper();
	}

}
