package com.infy.etms.service;

import java.util.List;

import com.infy.etms.dto.MentorDTO;
import com.infy.etms.exception.EmployeeException;

public interface MentorService {
	
	
	public List<MentorDTO> getMentorAndEmployeeByCourseId(Integer mentorId,String courseId, Integer pageNo) throws EmployeeException;

}
