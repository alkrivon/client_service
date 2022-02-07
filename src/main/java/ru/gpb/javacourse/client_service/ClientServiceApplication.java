package ru.gpb.javacourse.client_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//import ru.gpb.javacourse.client_service.config.ApplicationConfig;
import ru.gpb.javacourse.client_service.controller.ClientController;

@SpringBootApplication
public class ClientServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

}
