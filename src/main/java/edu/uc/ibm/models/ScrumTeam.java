package edu.uc.ibm.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ScrumTeam {
	
	@Id
	private String id;

	private String scrumTeamId,scrumTeamName;
	private String startDate;
	private String projectName;
	private List<TeamMember> projectTeam;
	
	
	
	public ScrumTeam( String scrumTeamId, String scrumTeamName, String startDate, String projectName) {
		super();
		
		this.scrumTeamId = scrumTeamId;
		this.scrumTeamName = scrumTeamName;
		this.startDate = startDate;
		this.projectName = projectName;
	}
	
	public ScrumTeam( String scrumTeamId, String scrumTeamName, String startDate, String projectName,List<TeamMember> projectTeam) {
		super();
		
		this.scrumTeamId = scrumTeamId;
		this.scrumTeamName = scrumTeamName;
		this.startDate = startDate;
		this.projectName = projectName;
		this.projectTeam=projectTeam;
	}
	
	public ScrumTeam() {
		super();
	}
	
	public String getScrumTeamId() {
		return scrumTeamId;
	}
	public void setScrumTeamId(String scrumTeamId) {
		this.scrumTeamId = scrumTeamId;
	}
	public String getScrumTeamName() {
		return scrumTeamName;
	}
	public void setScrumTeamName(String scrumTeamName) {
		this.scrumTeamName = scrumTeamName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<TeamMember> getProjectTeam() {
		return projectTeam;
	}

	public void setProjectTeam(List<TeamMember> projectTeam) {
		this.projectTeam = projectTeam;
	}
	
}
