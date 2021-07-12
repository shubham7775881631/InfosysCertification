package com.infy.etms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

//import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@PropertySource("classpath:ValidationMessage.properties")
@SpringBootApplication
@EnableSwagger2
public class EmployeeAndTrainingManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAndTrainingManagementSystemApplication.class, args);
	}
	
	//For Customizing the swagger we used the Docket bean
	//Excluding MVC support based on the url and package name
	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
//				.paths(PathSelectors.ant("/employee/*"))
				.apis(RequestHandlerSelectors.basePackage("com.infy.etms"))
				.build();
				
	}
	
	//Creating the bean for the Rest client 
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}
