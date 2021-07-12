package com.infy.infyallocation.service;

import java.util.List;

import com.infy.infyallocation.dto.ManagerDTO;
import com.infy.infyallocation.exception.ManagerException;

public interface ManagerService {
	
	
	public List<ManagerDTO> fetchAllManagerDetails() throws ManagerException;
	
	public ManagerDTO fetechManagerById(Integer managerId) throws ManagerException;
	
	public Integer addManager(ManagerDTO managerDTO) throws ManagerException;
	
	public Integer updateManager(Integer managerId, String courseId) throws ManagerException;
	
	public Integer removeManager(Integer managerId) throws ManagerException;
	
	

}
