package edu.uc.ibm.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

	@Id
	
	String id;
	String idno,familyname,givenname,position,salary;
	public Employee(String idno, String familyname, String givenname, String position, String salary) {
		super();
		this.idno = idno;
		this.familyname = familyname;
		this.givenname = givenname;
		this.position = position;
		this.salary = salary;
	}
	
	public Employee() {
		
	}
	
	public Employee(String idno) {
		super();
		// TODO Auto-generated constructor stub
		this.idno=idno;
	}

	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public String getFamilyname() {
		return familyname;
	}
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	public String getGivenname() {
		return givenname;
	}
	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [idno=" + idno + ", familyname=" + familyname + ", givenname=" + givenname + ", position="
				+ position + ", salary=" + salary + "]";
	}
	
	
	
}
