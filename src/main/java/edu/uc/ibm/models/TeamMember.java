package edu.uc.ibm.models;

public class TeamMember extends Employee {
	
	private String role;

	public TeamMember(String idno, String familyname, String givenname, String position, String salary, String role) {
		super(idno, familyname, givenname, position, salary);
		this.role = role;
	}
	
	public TeamMember(String idno) {
		super(idno);
	}
	
	
	public TeamMember() {
		super();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
