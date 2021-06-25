package com.infy.etms.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.infy.etms.entity.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer>{

}
