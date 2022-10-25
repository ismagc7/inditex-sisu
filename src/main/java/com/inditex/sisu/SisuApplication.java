package com.inditex.sisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.inditex.sisu")
public class SisuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisuApplication.class, args);
	}

}
