package br.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BootapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootapiApplication.class, args);
	}
}
