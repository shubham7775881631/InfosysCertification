package com.infy.etms.entity;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Mentor {
	
	@Id 
	private Integer mentorId;
	private String mentorName;
	private Integer projectMentored;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name ="course_code")
//	@OneToMany(mappedBy = "course_code", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> employee;


	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

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
		Mentor other = (Mentor) obj;
		if (mentorId == null) {
			if (other.mentorId != null)
				return false;
		} else if (!mentorId.equals(other.mentorId))
			return false;
		return true;
	}
	
	
	
	

}
