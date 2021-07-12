package com.infy.etms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.etms.dto.MentorDTO;
import com.infy.etms.exception.EmployeeException;
import com.infy.etms.service.MentorServiceImpl;

@RestController
@RequestMapping("/mentor")
@Validated
public class MentorAPI {
	
	
	@Autowired
	private MentorServiceImpl mentorService;
	
//	@Autowired
//	private Environment environment;
	
	@GetMapping("/getMentorAndEmployeeByCourseId/{mentorId}/{courseId}/{pageNo}")
	public ResponseEntity<List<MentorDTO>> getMentorAndEmployeeByCourseId(@PathVariable Integer mentorId,@PathVariable String courseId, @PathVariable Integer pageNo) throws EmployeeException
	{
		
		return new ResponseEntity<>(mentorService.getMentorAndEmployeeByCourseId(mentorId,courseId,pageNo),HttpStatus.OK);
		
	}

}
