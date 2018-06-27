package edu.uc.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uc.ibm.models.ScrumTeam;
import edu.uc.ibm.models.TeamMember;
import edu.uc.ibm.models.repository.ScrumTeamRepository;

@Service
public class ScrumTeamService {
	
	@Autowired
	private ScrumTeamRepository scrum_repo;

	public List<ScrumTeam> getall(){
		return scrum_repo.findAll();
	}
	
	public ScrumTeam create(String scrumTeamId, String scrumTeamName, String startDate, String projectName) {
		ScrumTeam st=new ScrumTeam(scrumTeamId,scrumTeamName,startDate,projectName);
		scrum_repo.save(st);
		return st;
	}
	
	public ScrumTeam update(String scrumTeamId, String scrumTeamName, String startDate, String projectName) {
		ScrumTeam st=scrum_repo.findByScrumTeamId(scrumTeamId);
		st.setScrumTeamId(scrumTeamId);
		st.setProjectName(projectName);
		st.setScrumTeamName(scrumTeamName);
		st.setStartDate(startDate);
		
		scrum_repo.save(st);
		return st;
	}
	
	
	public ScrumTeam update(String scrumTeamId, String scrumTeamName, String startDate, String projectName,List<TeamMember> projectTeam) {
		ScrumTeam st=scrum_repo.findByScrumTeamId(scrumTeamId);
		st.setScrumTeamId(scrumTeamId);
		st.setProjectName(projectName);
		st.setScrumTeamName(scrumTeamName);
		st.setStartDate(startDate);
		st.setProjectTeam(projectTeam);
		scrum_repo.save(st);
		return st;
	}
	
	public ScrumTeam findScrumTeamById(String scrumTeamId) {
		return scrum_repo.findByScrumTeamId(scrumTeamId);
	}
	
	public Long deleteScrumTeamById(String scrumTeamId) {
		return scrum_repo.deleteByScrumTeamId(scrumTeamId);
	}
	
	public void deleteAll() {
		scrum_repo.deleteAll();
	}
}
