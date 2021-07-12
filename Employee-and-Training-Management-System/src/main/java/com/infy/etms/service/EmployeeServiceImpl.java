package com.infy.etms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.infy.etms.dto.EmployeeDTO;
import com.infy.etms.entity.Employee;
import com.infy.etms.exception.EmployeeException;
import com.infy.etms.repository.EmployeeRepository;



@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService 
{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Integer addEmployee(EmployeeDTO employeeDTO) throws EmployeeException  
	{
		
		Optional<Employee> empOpt = employeeRepository.findById(employeeDTO.getEmployeeId());
		
		if(!empOpt.isEmpty())
		{
			throw new EmployeeException("Service.EMPLOYEE_ALREADY_EXIST");
		}
		
		
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDTO.getEmployeeId());
		employee.setEmployeeName(employeeDTO.getEmployeeName());
		employee.setCourseName(employeeDTO.getCourseName());
		employee.setCourseId(employeeDTO.getCourseId());
		employee.setScore(employeeDTO.getScore());
		employee.setHoursSpent(employeeDTO.getHoursSpent());
		
		employeeRepository.save(employee);

		return employee.getEmployeeId() ;
			
		
	}

	@Override
	public EmployeeDTO getEmployee(Integer employeeId) throws EmployeeException {
		
		Optional<Employee> optEnt = employeeRepository.findById(employeeId);
		
		Employee employeeEnt = optEnt.orElseThrow(() -> new EmployeeException("Service.EMPLOYEE_NOT_FOUND"));
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setEmployeeName(employeeEnt.getEmployeeName());
		employeeDTO.setEmployeeId(employeeEnt.getEmployeeId());
		employeeDTO.setCourseName(employeeEnt.getCourseName());
		employeeDTO.setCourseId(employeeEnt.getCourseId());
		employeeDTO.setScore(employeeEnt.getScore());
		employeeDTO.setHoursSpent(employeeEnt.getHoursSpent());
				
		
		return employeeDTO;
	}

	@Override
	public Integer updateEmployee(Integer employeeId, String courseName) throws EmployeeException {
		
        Optional<Employee> optEnt = employeeRepository.findById(employeeId);
		
		Employee employeeEnt = optEnt.orElseThrow(() -> new EmployeeException("Service.EMPLOYEE_NOT_FOUND"));
		
		employeeEnt.setCourseName(courseName);
		employeeRepository.save(employeeEnt);

		
		return employeeEnt.getEmployeeId();
	}

	@Override
	public Integer removeEmployee(Integer employeeId) throws EmployeeException {
		
		Optional<Employee> optEnt = employeeRepository.findById(employeeId);
		
		Employee employeeEnt = optEnt.orElseThrow(() -> new EmployeeException("Service.EMPLOYEE_NOT_FOUND"));
		
		employeeRepository.delete(employeeEnt);

		return employeeId;
	}

	@Override
	public List<EmployeeDTO> getAllEmployeeByCourseCode(String courseId,Integer pageNo) throws EmployeeException {
		
		Pageable pageable = PageRequest.of(pageNo, 7);
		
		List<Employee> empEntList= employeeRepository.getAllEmployeeByCourseCode(courseId,pageable);
		
		if(empEntList.isEmpty())
		{
			throw new  EmployeeException("Service.EMPLOYEE_NOT_FOUND");
		}
		
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();
		
		for(Employee emp:empEntList)
		{
			EmployeeDTO employeeDTO = new EmployeeDTO();
			
			employeeDTO.setEmployeeId(emp.getEmployeeId());
			employeeDTO.setEmployeeName(emp.getEmployeeName());
			employeeDTO.setCourseId(emp.getCourseId());
			employeeDTO.setCourseName(emp.getCourseName());
			employeeDTO.setScore(emp.getScore());
			employeeDTO.setHoursSpent(emp.getHoursSpent());
			
			employeeDTOList.add(employeeDTO);
	
		}
		
		return employeeDTOList;
	}
	

}
