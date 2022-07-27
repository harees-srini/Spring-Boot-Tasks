package com.example.crud2.crudDemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CrudDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemo2Application.class, args);
	}
}