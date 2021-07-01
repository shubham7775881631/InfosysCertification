package com.infy.etms.dto;

import java.util.List;

public class MentorDTO {
	
	private Integer mentorId;
	private String mentorName;
	private Integer projectMentored;
	private List<EmployeeDTO> employee;
	public Integer getMentorId() {
		return mentorId;
	}
	


	public void setMentorId(Integer mentorId) {
		this.mentorId = mentorId;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public Integer getProjectMentored() {
		return projectMentored;
	}
	public void setProjectMentored(Integer projectMentored) {
		this.projectMentored = projectMentored;
	}


	public List<EmployeeDTO> getEmployee() {
		return employee;
	}
	public void setEmployee(List<EmployeeDTO> employee) {
		this.employee = employee;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mentorId == null) ? 0 : mentorId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MentorDTO other = (MentorDTO) obj;
		if (mentorId == null) {
			if (other.mentorId != null)
				return false;
		} else if (!mentorId.equals(other.mentorId))
			return false;
		return true;
	}
	
	
	

}
