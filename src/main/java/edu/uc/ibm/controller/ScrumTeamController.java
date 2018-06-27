package edu.uc.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uc.ibm.models.Employee;
import edu.uc.ibm.models.ScrumTeam;
import edu.uc.ibm.models.TeamMember;
import edu.uc.ibm.service.EmployeeService;
import edu.uc.ibm.service.ScrumTeamService;

@RestController
public class ScrumTeamController {
	
	@Autowired
	private ScrumTeamService scrum_service;
	private EmployeeService emp_service;
	
	@RequestMapping("/createteam")
	public String create( @RequestParam String scrumTeamId, @RequestParam String scrumTeamName,  @RequestParam String startDate, @RequestParam String projectName) {
		return scrum_service.create(scrumTeamId, scrumTeamName, startDate, projectName).toString();
	}
	
	@RequestMapping("/deleteteam")
	public String deleteScrumTeam(@RequestParam String scrumTeamId) {
		//return (scrum_service.deleteScrumTeamById(scrumTeamId)>0)?"SUCCESSFULLY DELETED":"ERROR DELETING";
		return scrum_service.deleteScrumTeamById(scrumTeamId)+"";
	}
	
	@RequestMapping("/findteam")
	public ScrumTeam findScrumTeam(@RequestParam String scrumTeamId) {
		return scrum_service.findScrumTeamById(scrumTeamId);
	}
	
	
	
	@RequestMapping("/getallscrumteam")
	public List<ScrumTeam> getall(){
		return scrum_service.getall();
	}
	
	@RequestMapping("/deleteallscrumteam")
	public void deleteAllScrumTeam() {
		scrum_service.deleteAll();
	}
	
	
	
	@RequestMapping("/addmember")
	public String addMember(@RequestParam String scrumTeamId,@RequestParam String idno,@RequestParam String role) {
		ScrumTeam st=scrum_service.findScrumTeamById(scrumTeamId);
		Employee emp=emp_service.findEmployeeByIdno(idno);
		List<TeamMember> members=st.getProjectTeam();
			
		TeamMember member=new TeamMember(emp.getIdno(),emp.getFamilyname(),emp.getGivenname(),emp.getPosition(),emp.getSalary(),role);
		members.add(member);
		
		scrum_service.update(st.getScrumTeamId(), st.getScrumTeamName(), st.getStartDate(), st.getProjectName(),members);
		return member+" Added to Team "+st.getScrumTeamName();		
	}
	
	@RequestMapping("/removemember")
	public String removeMember(@RequestParam String scrumTeamId,@RequestParam String idno) {
		ScrumTeam st=scrum_service.findScrumTeamById(scrumTeamId);
		List<TeamMember> members=st.getProjectTeam();
		    Employee emp=emp_service.findEmployeeByIdno(idno);
			members.remove(new TeamMember(emp.getIdno()));
			scrum_service.update(st.getScrumTeamId(), st.getScrumTeamName(), st.getStartDate(), st.getProjectName(),members);
		return emp.toString()+"is Removed from Team "+st.getScrumTeamName();
	}
	
		
	@RequestMapping("/getmembers")
	public List<TeamMember> getMembers(@RequestParam String scrumTeamId){
		ScrumTeam st=scrum_service.findScrumTeamById(scrumTeamId);
		return st.getProjectTeam();
	}
	
	@RequestMapping("/removeAllMembers")
	public String removeAllMembers(@RequestParam String scrumTeamId) {
		ScrumTeam st=scrum_service.findScrumTeamById(scrumTeamId);
			st.getProjectTeam().clear();
			scrum_service.update(st.getScrumTeamId(), st.getScrumTeamName(), st.getStartDate(), st.getProjectName(),st.getProjectTeam());
		return "All Members at team :"+st.getProjectName()+" are removed";
	}
	
	
}
