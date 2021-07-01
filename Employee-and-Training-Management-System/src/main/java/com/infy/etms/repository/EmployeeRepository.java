package com.infy.etms.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.infy.etms.entity.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer>{

	
	@Query("select e from Employee e where courseId=?1")
	List<Employee> getAllEmployeeByCourseCode(String courseId, Pageable pageable);

}
