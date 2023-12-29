package com.stackroute.swaggerautoconfbean;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SwaggerAutoConfBeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerAutoConfBeanApplication.class, args);
	}

}
