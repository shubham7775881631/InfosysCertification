package com.infy.infyallocation.dto;


import javax.validation.constraints.NotNull;

import com.infy.infyallocation.entity.Manager;

public class ManagerDTO {
	
	
	
	private Integer managerId;
	private String managerName;
	private Integer noOfProjectMentored;
	private String domainName;
	private Integer noOfTeamHandled;
	private Integer teamId;
	@NotNull(message="{invalid.courseId}")
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
		ManagerDTO other = (ManagerDTO) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		return true;
	}
	
	
	public static Manager prepareManagerEntity(ManagerDTO managerDTO)
	{
		Manager manager = new Manager();
		
		manager.setCourseId(managerDTO.getCourseId());
		manager.setDomainName(managerDTO.getDomainName());
		manager.setManagerId(managerDTO.getManagerId());
		manager.setManagerName(managerDTO.getManagerName());
		manager.setNoOfProjectMentored(managerDTO.getNoOfProjectMentored());
		manager.setNoOfTeamHandled(managerDTO.getNoOfTeamHandled());
		manager.setTeamId(managerDTO.getTeamId());
		
		return manager;
	}
	
	
	
	


}
