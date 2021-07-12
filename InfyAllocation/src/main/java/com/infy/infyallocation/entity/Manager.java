package com.infy.infyallocation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.infyallocation.dto.ManagerDTO;

@Entity
@Table(name="manager")
public class Manager {

	
	@Id
	private Integer managerId;
	private String managerName;
	private Integer noOfProjectMentored;
	private String domainName;
	private Integer noOfTeamHandled;
	private Integer teamId;
	
	@Column(name="course_code")
	private String courseId;
	
	
	
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public Integer getNoOfProjectMentored() {
		return noOfProjectMentored;
	}
	public void setNoOfProjectMentored(Integer noOfProjectMentored) {
		this.noOfProjectMentored = noOfProjectMentored;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public Integer getNoOfTeamHandled() {
		return noOfTeamHandled;
	}
	public void setNoOfTeamHandled(Integer noOfTeamHandled) {
		this.noOfTeamHandled = noOfTeamHandled;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
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
		Manager other = (Manager) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		return true;
	}
	
	
	public static ManagerDTO prepareManagerDTO(Manager manager)
	{
		
		ManagerDTO managerDTO = new ManagerDTO();
		
		managerDTO.setCourseId(manager.getCourseId());
		managerDTO.setDomainName(manager.getDomainName());
		managerDTO.setManagerId(manager.getManagerId());
		managerDTO.setManagerName(manager.getManagerName());
		managerDTO.setNoOfProjectMentored(manager.getNoOfProjectMentored());
		managerDTO.setNoOfTeamHandled(manager.getNoOfTeamHandled());
		managerDTO.setTeamId(manager.getTeamId());
		
		return managerDTO;
	}
	
	
	

}
