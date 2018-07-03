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
	
	public boolean equals(Object obj) {
		TeamMember m=null;
		if(obj instanceof TeamMember) {
			m=(TeamMember)obj;
			return this.getIdno()==m.getIdno();
		}
		return false;
	}
	
	
	public String toString() {
		return super.toString()+role;
	}
	
}
