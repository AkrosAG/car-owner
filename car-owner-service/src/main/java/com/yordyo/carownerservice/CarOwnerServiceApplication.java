package com.yordyo.carownerservice;

import com.yordyo.carownerservice.shared.config.H2Config;
import com.yordyo.carownerservice.shared.config.PostgresConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({H2Config.class, PostgresConfig.class})
public class CarOwnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarOwnerServiceApplication.class, args);
	}

}
