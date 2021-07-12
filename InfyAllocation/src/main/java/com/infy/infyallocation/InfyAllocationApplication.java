package com.infy.infyallocation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.infy.infyallocation.restclass.Employee;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@PropertySource("classpath:validationMessage.properties")
@SpringBootApplication
public class InfyAllocationApplication {
	
	
    static RestTemplate restTemplate= new RestTemplate();
    
    static String baseUrl="http://localhost:8765/employee";
	
	private static final Logger logger = LogManager.getLogger(InfyAllocationApplication.class);
	

	public static void main(String[] args) {
		
		SpringApplication.run(InfyAllocationApplication.class, args);
		
		exchangeMethodRestTemplate();
	}
	
//	@Bean
//	public RestTemplate getRestTemplate()
//	{
//		return new RestTemplate();
//	}
	
	
	
	public static void exchangeMethodRestTemplate()
	{
		
		
//		List<Employee> employee = (List<Employee>) restTemplate.getForObject("http://localhost:8765/employee/CSE/0", Employee.class);
		
		HttpHeaders headers= new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		
		getSingleEmployeeExchangeMethodRestTemplate(requestEntity);
		
		getListEmployeeExchangeMethodRestTemplate(requestEntity);
		
		
		Employee employee = new Employee();
		employee.setEmployeeId(127);
		employee.setCourseId("CSE");
		employee.setEmployeeName("Charls");
		employee.setCourseName("CDC");
		employee.setHoursSpent(162);
		employee.setScore(85);
		
		requestEntity= new HttpEntity<>(employee,headers);
		
		addEmployeeExchangeMethodRestTemplate(requestEntity);
		
		updateEmployeeExchangeMethodRestTemplate(requestEntity);
		
		deleteEmployeeExchangeMethodRestTemplate(requestEntity);
		
		

	}

    //getSingleEmployee	from another Employee RestAPI running on differnet port Number 
	public static void getSingleEmployeeExchangeMethodRestTemplate(HttpEntity<Object> requestEntity)
	{
		logger.info("************ GET Method *************************");
		//In String format
        ResponseEntity<String> reponseEntity  = restTemplate.exchange(baseUrl + "/101", HttpMethod.GET, requestEntity, String.class);
	
		HttpStatus statusCode = reponseEntity.getStatusCode();
		logger.info("Sataus Code:"+statusCode);
		
		String emp = reponseEntity.getBody(); 
		logger.info("Response Body:"+emp);
		
		HttpHeaders httpheader = reponseEntity.getHeaders();
		logger.info("Response Header:"+httpheader);
		
		//In Object format
        ResponseEntity<Employee> reponseEmployee  = restTemplate.exchange(baseUrl + "/101", HttpMethod.GET, requestEntity, Employee.class);
	
		HttpStatus statusCodeEmp = reponseEmployee.getStatusCode();
		logger.info("Sataus Code:"+statusCode);
		
		Employee employee = reponseEmployee.getBody(); 
		logger.info("Response Body:"+"--->"+"Employee Name:"+employee.getEmployeeName()+"Employee ID:"+employee.getEmployeeId());
		
		HttpHeaders httpheaderEmp = reponseEmployee.getHeaders();
		logger.info("Response Header:"+httpheaderEmp);
		
	}
	//getALLemployeeByCourseCode Employee RestAPI
	public static void getListEmployeeExchangeMethodRestTemplate(HttpEntity<Object> requestEntity)
	{
		logger.info("************ LIST GET Method *************************");
		//In String format
        ResponseEntity<List> reponseEntity  = restTemplate.exchange(baseUrl + "/CSE/0", HttpMethod.GET, requestEntity, List.class);
	
		HttpStatus statusCode = reponseEntity.getStatusCode();
		logger.info("Sataus Code:"+statusCode);
		
		List emp = reponseEntity.getBody(); 
		logger.info("Response Body:"+emp);
		
		HttpHeaders httpheader = reponseEntity.getHeaders();
		logger.info("Response Header:"+httpheader);
		
		//In Object format
        ResponseEntity<List> reponseEmployee  = restTemplate.exchange(baseUrl + "/CSE/0", HttpMethod.GET, requestEntity, List.class);
	
		HttpStatus statusCodeEmp = reponseEmployee.getStatusCode();
		logger.info("Sataus Code:"+statusCode);
		
		List employee = reponseEmployee.getBody();
		
		logger.info("Response Body:"+"--->"+employee);
		
		
		HttpHeaders httpheaderEmp = reponseEmployee.getHeaders();
		logger.info("Response Header:"+httpheaderEmp);
		
	}
	//addEmployee from Employee RestAPI
	public static void addEmployeeExchangeMethodRestTemplate(HttpEntity<Object> requestEntity)
	{
		logger.info("************ POST Method *************************");
		
		ResponseEntity<String> reponseEntity = restTemplate.exchange(baseUrl, HttpMethod.POST,requestEntity,String.class);
		
		HttpStatus statusCode=reponseEntity.getStatusCode();
		logger.info("Status Code:"+statusCode);
		
		String reponseBody =reponseEntity.getBody();
		logger.info("Response Body:"+reponseBody);
		
		HttpHeaders httpheaderEmp = reponseEntity.getHeaders();
		logger.info("Response Header:"+httpheaderEmp);
		

	}
	
	public static void updateEmployeeExchangeMethodRestTemplate(HttpEntity<Object> requestEntity)
	{
		logger.info("************ PUT Method *************************");
		
		ResponseEntity<String> reponseEntity = restTemplate.exchange(baseUrl+"/777/MVC", HttpMethod.PUT,requestEntity,String.class);
		
		HttpStatus statusCode=reponseEntity.getStatusCode();
		logger.info("Status Code:"+statusCode);
		
		String reponseBody =reponseEntity.getBody();
		logger.info("Response Body:"+reponseBody);
		
		HttpHeaders httpheaderEmp = reponseEntity.getHeaders();
		logger.info("Response Header:"+httpheaderEmp);
	
	}
	
	public static void deleteEmployeeExchangeMethodRestTemplate(HttpEntity<Object> requestEntity)
	{
		logger.info("************ DELETE Method *************************");
		
		ResponseEntity<String> reponseEntity = restTemplate.exchange(baseUrl+"/127", HttpMethod.DELETE,requestEntity,String.class);
		
		HttpStatus statusCode=reponseEntity.getStatusCode();
		logger.info("Status Code:"+statusCode);
		
		String reponseBody =reponseEntity.getBody();
		logger.info("Response Body:"+reponseBody);
		
		HttpHeaders httpheaderEmp = reponseEntity.getHeaders();
		logger.info("Response Header:"+httpheaderEmp);
		
		
		
	}
	
	
	

}
