package com.infy.etms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:ValidationMessages.properties")
@SpringBootApplication
public class EmployeeAndTrainingManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAndTrainingManagementSystemApplication.class, args);
	}

}
