package com.infy.infyallocation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.infyallocation.dto.ManagerDTO;
import com.infy.infyallocation.entity.Manager;
import com.infy.infyallocation.exception.ManagerException;
import com.infy.infyallocation.repository.ManagerRepository;

@Service("managerService")
@Transactional
public class ManagerServiceImpl implements ManagerService {
	
	
	@Autowired
	private ManagerRepository managerRepository;
	


	@Override
	public List<ManagerDTO> fetchAllManagerDetails() throws ManagerException {
		
		List<Manager> managerListEnt = managerRepository.findAll();
		
		if(managerListEnt.isEmpty())
		{
			throw new ManagerException("Service.MANAGERS_NOT_FOUND");
		}
		
		List<ManagerDTO> managerDTOs = new ArrayList<>();
		
		
		for(Manager manager:managerListEnt)
		{
			ManagerDTO managerDTO = new ManagerDTO();
			managerDTO= Manager.prepareManagerDTO(manager);
			managerDTOs.add(managerDTO);
		}
		
		
		return managerDTOs;
	}

	@Override
	public ManagerDTO fetechManagerById(Integer managerId) throws ManagerException {
		
		
		Optional<Manager> OptEnt = managerRepository.findById(managerId);
		
		Manager managerEnt= OptEnt.orElseThrow(()-> new ManagerException("Service.MANAGER_NOT_FOUND"));
		
		
		ManagerDTO managerDTO = new ManagerDTO();
		
		managerDTO = Manager.prepareManagerDTO(managerEnt);

		return managerDTO;
	}

	@Override
	public Integer addManager(ManagerDTO managerDTO) throws ManagerException {
		
		Optional<Manager> ManagerEnt = managerRepository.findById(managerDTO.getManagerId());
		
		if(ManagerEnt.isPresent())
		{
			throw new ManagerException("Service.MANAGER_IS_ALREADY_EXIST");
		}
			
		Manager manager = new Manager();
		
		manager= ManagerDTO.prepareManagerEntity(managerDTO);
		

		return managerRepository.save(manager).getManagerId();
	}

	@Override
	public Integer updateManager(Integer managerId, String courseId) throws ManagerException {
		

		Optional<Manager> managerEnt = managerRepository.findById(managerId);
		
		Manager manager= managerEnt.orElseThrow(()-> new ManagerException("Service.MANAGER_NOT_FOUND"));

		manager.setCourseId(courseId);

		return managerRepository.save(manager).getManagerId();
	}

	@Override
	public Integer removeManager(Integer managerId) throws ManagerException {
		

		Optional<Manager> managerEnt = managerRepository.findById(managerId);
		
		Manager manager= managerEnt.orElseThrow(()-> new ManagerException("Service.MANAGER_NOT_FOUND"));

		managerRepository.delete(manager);
		return managerId;
	}
	
	
	

}
