package com.infy.etms.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.etms.dto.EmployeeDTO;
import com.infy.etms.dto.MentorDTO;
import com.infy.etms.entity.Employee;
import com.infy.etms.entity.Mentor;
import com.infy.etms.exception.EmployeeException;
import com.infy.etms.repository.MentorRepository;

@Service("mentorService")
@Transactional
public class MentorServiceImpl implements MentorService {
	
	@Autowired
	private MentorRepository mentorRepository;
	

	@Override
	public List<MentorDTO> getMentorAndEmployeeByCourseId(Integer mentorId, Integer pageNo) throws EmployeeException {
		
		List<Mentor> mentEntlist =mentorRepository.getMentorAndEmployeeByCourseId(mentorId,pageNo);
		
		List<MentorDTO> mentorDTOList = new ArrayList<>();
		
		for(Mentor m:mentEntlist)
		{
			MentorDTO mentorDTO = new MentorDTO();
			
			mentorDTO.setMentorName(m.getMentorName());
			mentorDTO.setMentorId(m.getMentorId());
			mentorDTO.setProjectMentored(m.getProjectMentored());
			
			List<Employee> empEntList = m.getEmployee();
			
			List<EmployeeDTO> employeeDTOList = new LinkedList<>();
			
			if(!empEntList.isEmpty())
			{
			for(Employee e:empEntList)
			{
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setCourseId(e.getCourseId());
				employeeDTO.setCourseName(e.getCourseName());
				employeeDTO.setEmployeeId(e.getEmployeeId());
				employeeDTO.setEmployeeName(e.getEmployeeName());
				employeeDTO.setHoursSpent(e.getHoursSpent());
				employeeDTO.setScore(e.getScore());
				
				employeeDTOList.add(employeeDTO);
								
			}
			
			}
			
			mentorDTO.setEmployee(employeeDTOList);
			
		}
		
		return mentorDTOList;
	}

}
