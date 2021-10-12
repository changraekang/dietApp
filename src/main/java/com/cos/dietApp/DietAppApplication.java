package com.cos.dietApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class DietAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DietAppApplication.class, args);
	}

}
