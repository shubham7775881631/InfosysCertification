package com.infy.infyallocation.controller;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import javax.validation.Valid;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.infyallocation.dto.ManagerDTO;
import com.infy.infyallocation.exception.ManagerException;
import com.infy.infyallocation.restclass.Employee;
import com.infy.infyallocation.service.ManagerServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/manager")
@Validated
public class ManagerAPI {
	
	
	@Autowired
	private ManagerServiceImpl managerService;
	
	@Autowired
	private Environment environment;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	
	//done
	@GetMapping(produces="application/json")
	public ResponseEntity<List<ManagerDTO>> fetchAllManagerDetails() throws ManagerException
	{
		
		
		return new ResponseEntity<>(managerService.fetchAllManagerDetails(),HttpStatus.FOUND);
	}
	
	//done
	@GetMapping( value="/{managerId}", produces="application/json")  
	public ResponseEntity<ManagerDTO> fetechManagerById(@PathVariable 
			@Min(value=1001,message="{invalid.managerId}") @Max(value=1007,message="{invalid.managerId}") Integer managerId) throws ManagerException
	{
		
		return new ResponseEntity<>(managerService.fetechManagerById(managerId),HttpStatus.FOUND);
		
	}
	//done
	@PostMapping(consumes={"application/json","application/xml"})
	public ResponseEntity<String> addManager(@Valid @RequestBody ManagerDTO managerDTO) throws ManagerException
	{
		
		
		   Integer managerId = managerService.addManager(managerDTO);
		
		   String successMessage = environment.getProperty("API.MANAGER_ADDED_SUCESSFULLY")+managerId;
		
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
		
	}
	//done
	@PutMapping(value="/{managerId}/{courseId}",produces="application/text")
	public ResponseEntity<String> updateManager(@PathVariable @Min(value=1001,message="{invalid.managerId}") 
				@Max(value=1007,message="{invalid.managerId}") Integer managerId, @PathVariable @NotNull(message= "{invalid.courseId}") String courseId) throws ManagerException
	{
		
		  Integer mId = managerService.updateManager(managerId, courseId);
		
		  String successMessage = environment.getProperty("API.MANAGER_UPDATED_SUCESSFULLY")+mId;
		
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
	}
	//done
	@DeleteMapping(value="/{managerId}",produces="application/text")
	public ResponseEntity<String> removeManager(@PathVariable
			@Min(value=1001,message="{invalid.managerId}") @Max(value=1007,message="{invalid.managerId}") Integer managerId) throws ManagerException
	{

		  Integer mId = managerService.removeManager(managerId);
		
		  String successMessage = environment.getProperty("API.MANAGER_DELETED_SUCESSFULLY")+mId;
		
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
	}
	
//	@GetMapping( value="/getEmployeeAndManager" )  
//	public Employee getEmployeeAndManager() throws ManagerException
//	{
//
//		String baseUrl="http://localhost:8765/employee/CSE/0";
//		
////		List<Employee> employee = (List<Employee>) restTemplate.getForObject("http://localhost:8765/employee/CSE/0", Employee.class);
//		
//		HttpHeaders headers= new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
//		
//		ResponseEntity<Employee> reponseEntity  = restTemplate.exchange(baseUrl,HttpMethod.GET,requestEntity,Employee.class);
//		
//	
//		return reponseEntity.getBody();
//		
//	}
	

}
