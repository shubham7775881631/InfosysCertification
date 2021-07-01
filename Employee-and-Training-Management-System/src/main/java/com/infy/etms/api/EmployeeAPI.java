package com.infy.etms.api;



import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.etms.dto.EmployeeDTO;
import com.infy.etms.exception.EmployeeException;
import com.infy.etms.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeAPI {
	
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@Autowired
	private Environment environment;
	
	//done
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws EmployeeException
	{
		
		Integer employeeId = employeeService.addEmployee(employeeDTO);
		
		String successMessage = environment.getProperty("API.EMPLOYEE_ADDED_SUCCESSFULLY")+employeeId;
		
		return new ResponseEntity<>(successMessage,HttpStatus.FOUND);
		
	}
	//done
	@GetMapping("/getEmployee/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable @Min(value=100,message="{employee.min.value}")
	@Max(value=999,message="{employee.max.value}") Integer employeeId ) throws EmployeeException
	{
		
		return new ResponseEntity<>(employeeService.getEmployee(employeeId),HttpStatus.OK);
		
	}
	//done
	@PutMapping("/updateEmployee/{employeeId}/{courseName}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer employeeId,@PathVariable String courseName ) throws EmployeeException
	{
		
		Integer empId = employeeService.updateEmployee(employeeId, courseName);
		
		String successMessage = environment.getProperty("API.EMPLOYEE_DETAILS_UPDATED")+empId;
		
		return new ResponseEntity<>(successMessage,HttpStatus.ACCEPTED);
		
		
	}
	//done
	@DeleteMapping("/removeEmployee/{employeeId}")
	public ResponseEntity<String> removeEmployee(@PathVariable Integer employeeId) throws EmployeeException
	{
		
		Integer empId = employeeService.removeEmployee(employeeId);
		
		String successMessage = environment.getProperty("API.EMPLOYEE_DELETED")+empId;
		
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
	}
	
	//Pagination
	//We want per page 7 record whose course 
	@GetMapping("/getAllEmployeeByCourseCode/{courseId}/{pageNo}")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployeeByCourseCode(@PathVariable String courseId,@PathVariable Integer pageNo) throws EmployeeException
	{
		
		return new ResponseEntity<>(employeeService.getAllEmployeeByCourseCode(courseId,pageNo),HttpStatus.OK);
	}
	

}
