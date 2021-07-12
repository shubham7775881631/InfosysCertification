package com.infy.etms.Employee.and.Training.Management.System;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.infy.etms.dto.EmployeeDTO;
import com.infy.etms.entity.Employee;
import com.infy.etms.exception.EmployeeException;
import com.infy.etms.repository.EmployeeRepository;
import com.infy.etms.service.EmployeeServiceImpl;

@SpringBootTest
class EmployeeAndTrainingManagementSystemApplicationTests {

	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	
	
	//1.addEmployee
	//Valid
	@Test
	public void addEmployeeValidTest() throws EmployeeException
	{	
		Employee employee = new Employee();
		employee.setEmployeeId(1009);
		employee.setCourseId("MNS");
		employee.setEmployeeName("Charls");
		employee.setCourseName("CDC");
		employee.setHoursSpent(162);
		employee.setScore(85);
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setCourseId("MNS");
		employeeDTO.setEmployeeId(1009);
		employeeDTO.setCourseName("CDC");

		Mockito.when(employeeRepository.save(employee)).thenReturn(Mockito.any());
		
	
		Assertions.assertEquals(employee.getEmployeeId(), employeeService.addEmployee(employeeDTO));	
		
	}
	
	//Invalid
	
	
	@Test
	public void addEmployeeInvalidTest1() throws EmployeeException
	{
		Employee employee = new Employee();
		employee.setEmployeeId(1009);
		employee.setCourseId("MNS");
		employee.setEmployeeName("Charls");
		employee.setCourseName("CDC");
		employee.setHoursSpent(162);
		employee.setScore(85);
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setCourseId("MNS");
		employeeDTO.setEmployeeId(1009);
		employeeDTO.setEmployeeName("Charls");
		employeeDTO.setCourseName("CDC");
		employeeDTO.setHoursSpent(162);
		employeeDTO.setScore(85);
		
		
		
		Mockito.<Optional<Employee>>when(employeeRepository.findById(employeeDTO.getEmployeeId())).thenReturn(Optional.of(employee));
		
		EmployeeException exception = Assertions.assertThrows(EmployeeException.class,() -> employeeService.addEmployee(employeeDTO));
		
		Assertions.assertEquals("Service.EMPLOYEE_ALREADY_EXIST", exception.getMessage());
		
	}
	
	//2.getEmployee()
	
    //Invalid
	@Test
	public void getEmployeeInvalidTest1() throws EmployeeException
	{
		Employee employee = new Employee();
		employee.setEmployeeId(1009);
		employee.setCourseId("MNS");
		employee.setEmployeeName("Charls");
		employee.setCourseName("CDC");
		employee.setHoursSpent(162);
		employee.setScore(85);
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setCourseId("MNS");
		employeeDTO.setEmployeeId(1009);
		employeeDTO.setEmployeeName("Charls");
		employeeDTO.setCourseName("CDC");
		employeeDTO.setHoursSpent(162);
		employeeDTO.setScore(85);
		
		
		
		Mockito.<Optional<Employee>>when(employeeRepository.findById(employeeDTO.getEmployeeId())).thenReturn(Optional.empty());
		
		EmployeeException exception = Assertions.assertThrows(EmployeeException.class,() -> employeeService.getEmployee(employeeDTO.getEmployeeId()));
		
		Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", exception.getMessage());
		
	}
	
	//valid
	
	@Test
	public void getEmployeeValidTest() throws EmployeeException
	{
		//Input
		Employee employee = new Employee();
		employee.setEmployeeId(1009);
		employee.setCourseId("MNS");
		employee.setEmployeeName("Charls");
		employee.setCourseName("CDC");
		employee.setHoursSpent(162);
		employee.setScore(85);
		
		Integer employeeId=1009;
		
		//Output
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setCourseId("MNS");
		employeeDTO.setEmployeeId(1009);
		employeeDTO.setEmployeeName("Charls");
		employeeDTO.setCourseName("CDC");
		employeeDTO.setHoursSpent(162);
		employeeDTO.setScore(85);
		
		
		Mockito.<Optional<Employee>>when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
		
		Assertions.assertEquals(employeeDTO, employeeService.getEmployee(employeeId));
		
	}
	
	//3.updateEmployee()
	
	//Invalid
	
	@Test
	public void updateEmployeeInvalidTest() throws EmployeeException
	{
		Employee employee = new Employee();
		employee.setEmployeeId(1009);
		employee.setCourseId("MNS");
		employee.setEmployeeName("Charls");
		employee.setCourseName("CDC");
		employee.setHoursSpent(162);
		employee.setScore(85);
		
		Integer employeeId=1009;
		String courseId="CSE";
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setCourseId("MNS");
		employeeDTO.setEmployeeId(1009);
		employeeDTO.setEmployeeName("Charls");
		employeeDTO.setCourseName("CDC");
		employeeDTO.setHoursSpent(162);
		employeeDTO.setScore(85);
		
		Mockito.<Optional<Employee>>when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());
		
		EmployeeException exception =  Assertions.assertThrows(EmployeeException.class, ()-> employeeService.updateEmployee(employeeId, courseId));
		
		Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", exception.getMessage());
		
	}
	
	
	//Valid
	@Test
	public void updateEmployeeValidTest() throws EmployeeException
	{
		Employee employee = new Employee();
		employee.setEmployeeId(1009);
		employee.setCourseId("MNS");
		employee.setEmployeeName("Charls");
		employee.setCourseName("CDC");
		employee.setHoursSpent(162);
		employee.setScore(85);
		
		Integer employeeId=1009;
		String courseId="CSE";
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setCourseId("CSE");
		employeeDTO.setEmployeeId(1009);
		employeeDTO.setEmployeeName("Charls");
		employeeDTO.setCourseName("CDC");
		employeeDTO.setHoursSpent(162);
		employeeDTO.setScore(85);
		
		Mockito.<Optional<Employee>>when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
		
		Assertions.assertEquals(employeeDTO.getEmployeeId(),employeeService.updateEmployee(employeeId, courseId));
		
	
		
	}
	
	//4. removeEmployee()
	
	//InvalidTest
	
	@Test
	public void removeEmployeeInvalidTest() throws EmployeeException
	{
		
		Integer employeeId=1009;
		
		Mockito.<Optional<Employee>>when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());
		
		EmployeeException exception =  Assertions.assertThrows(EmployeeException.class, ()-> employeeService.removeEmployee(employeeId));
		
		Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", exception.getMessage());
		
	}
	
	//valid
	@Test
	public void removeEmployeevalidTest() throws EmployeeException
	{
		
		Integer employeeId=1009;
		
		Employee employee = new Employee();
		employee.setEmployeeId(1009);
		employee.setCourseId("MNS");
		employee.setEmployeeName("Charls");
		employee.setCourseName("CDC");
		employee.setHoursSpent(162);
		employee.setScore(85);
		
		Mockito.<Optional<Employee>>when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
		
		Assertions.assertEquals(employee.getEmployeeId(), employeeService.removeEmployee(employeeId));
		
	}
	
	//5.getAllEmployeeByCourseId
	
	
	@Test
	public void getAllEmployeeByCourseIdInvalidTest() throws EmployeeException
	
	{
		String courseId="CSE";
		Integer pageNo = 0;
		
		Pageable pageable = PageRequest.of(pageNo, 7);
		
		List<Employee> employeeList = new ArrayList<>();

		Mockito.<List<Employee>>when(employeeRepository.getAllEmployeeByCourseCode(courseId, pageable)).thenReturn(employeeList);
		
		EmployeeException exception = Assertions.assertThrows(EmployeeException.class,()-> employeeService.getAllEmployeeByCourseCode(courseId, pageNo));
		
		Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", exception.getMessage());
		
	}
	
	//valid
	@Test
	public void getAllEmployeeByCourseIdvalidTest() throws EmployeeException
	
	{
		String courseId="CSE";
		Integer pageNo = 0;
		
		Pageable pageable = PageRequest.of(pageNo, 7);
		
		List<Employee> employeeList = new ArrayList<>();
		Employee employee = new Employee();
		employee.setEmployeeId(1009);
		employee.setCourseId("MNS");
		employee.setEmployeeName("Charls");
		employee.setCourseName("CDC");
		employee.setHoursSpent(162);
		employee.setScore(85);
		employeeList.add(employee);
		
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();

		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setCourseId("CSE");
		employeeDTO.setEmployeeId(1009);
		employeeDTO.setEmployeeName("Charls");
		employeeDTO.setCourseName("CDC");
		employeeDTO.setHoursSpent(162);
		employeeDTO.setScore(85);
		employeeDTOList.add(employeeDTO);
		
		Mockito.<List<Employee>>when(employeeRepository.getAllEmployeeByCourseCode(courseId, pageable)).thenReturn(employeeList);

		Assertions.assertEquals(employeeDTOList, employeeService.getAllEmployeeByCourseCode(courseId, pageNo));
		
	}
	
	
	

}
