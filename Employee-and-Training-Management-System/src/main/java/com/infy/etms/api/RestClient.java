package com.infy.etms.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.infy.etms.entity.Employee;

public class RestClient {
	
	@Autowired
	private static RestTemplate restTemplate;
	
	private static final String CREATE_USER_API = "http://localhost:8080/employee";
	private static final String GET_USER_BY_ID_API = "http://localhost:8080//{employeeId}";
	private static final String UPDATE_USER_BY_ID_AND_COURSE_NAME_API = "http://localhost:8080/{employeeId}/{courseName}";
	private static final String DELETE_USER_BY_ID_API = "http://localhost:8080/{employeeId}";
	private static final String GET_7_USER_PER_PAGE_API = "http://localhost:8765/employee/CSE/0";
	
	 public static void main (String[] args)
	 {
		 
	 }
	 
	 
	 
	 
	 public static void callGetUserByIdAPI() {
		 
		 
         Map<String, Integer> param = new HashMap<>();
		 
		 param.put("id",101);
		 
		 Employee emp = restTemplate.getForObject(GET_USER_BY_ID_API,Employee.class,param);
		 
		 
		 
		 
	 }
//	 public static void callGetUserByIdAPI() {
//		 
//		 HttpHeaders  headers = new HttpHeaders();
//		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		 
//		 HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
//		 
//		ResponseEntity<String> result= restTemplate.exchange(GET_USER_BY_ID_API,HttpMethod.GET,entity,String.class);
//		 
//		System.out.println(result);
//		 
//	 }

}
