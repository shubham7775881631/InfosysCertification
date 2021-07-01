package com.infy.etms.service;

import java.util.List;

import com.infy.etms.dto.EmployeeDTO;
import com.infy.etms.exception.EmployeeException;

public interface EmployeeService {
	
	public Integer addEmployee(EmployeeDTO employeeDTO) throws EmployeeException;
	
	public EmployeeDTO getEmployee(Integer employeeId) throws EmployeeException;
	
	public Integer updateEmployee(Integer employeeId, String courseName) throws EmployeeException;
	
	public Integer removeEmployee(Integer employeeId) throws EmployeeException;
	
	 public List<EmployeeDTO> getAllEmployeeByCourseCode(String courseId,Integer pageNo) throws EmployeeException;
	
	

}
