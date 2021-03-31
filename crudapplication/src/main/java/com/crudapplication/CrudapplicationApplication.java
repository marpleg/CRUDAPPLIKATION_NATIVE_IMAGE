package com.crudapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class CrudapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudapplicationApplication.class, args);
	}

}
