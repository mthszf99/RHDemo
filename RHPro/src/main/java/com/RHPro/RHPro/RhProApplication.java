package com.RHPro.RHPro;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.RHPro.RHPro.models")
@SpringBootApplication
public class RhProApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhProApplication.class, args);
	}

}
