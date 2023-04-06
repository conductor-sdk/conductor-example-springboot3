package io.orkes.demo.banking;

import io.orkes.conductor.client.ApiClient;
import io.orkes.conductor.client.TaskClient;
import io.orkes.conductor.client.http.OrkesTaskClient;
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

	private final Environment env;

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

	@Bean
	public ApiClient apiClient() {
		String key = env.getProperty("orkes.access.key");
		String secret = env.getProperty("orkes.access.secret");
		String conductorServer = env.getProperty("orkes.conductor.server.url");
		return new ApiClient(conductorServer, key, secret);
	}

	@Bean
	public TaskClient taskClient(ApiClient apiClient) {
		return new OrkesTaskClient(apiClient);
	}

}
