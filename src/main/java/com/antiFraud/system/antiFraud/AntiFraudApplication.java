package com.antiFraud.system.antiFraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.antiFraud.system.antiFraud.repository")
public class AntiFraudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntiFraudApplication.class, args);
	}

}
