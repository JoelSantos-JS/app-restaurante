package com.br.joel.app.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneId;
import java.util.TimeZone;

@SpringBootApplication
public class AppRestauranteApplication {

	public static void main(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		ZoneId.systemDefault();


		SpringApplication.run(AppRestauranteApplication.class, args);
	}

}
