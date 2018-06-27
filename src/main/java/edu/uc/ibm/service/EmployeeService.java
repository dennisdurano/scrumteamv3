package edu.uc.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uc.ibm.models.Employee;
import edu.uc.ibm.models.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository emp_repo;
	
	
	public Employee create(String idno,String familyname,String givenname,String position,String salary) {
		return emp_repo.save(new Employee(idno,familyname,givenname,position,salary));
	}
	
	public List<Employee> getAll(){
		return emp_repo.findAll();
	}
	
	public Employee findEmployeeByIdno(String idno) {
		return emp_repo.findByIdno(idno);
	}
	
	
	public void deleteAll() {
		emp_repo.deleteAll();
	}
	
	public void deleteEmployeeByIdno(String idno) {
		Employee emp=emp_repo.findByIdno(idno);
		emp_repo.delete(emp);
	}
	
	public List<Employee> findAllEmployeeByPosition(String position){
		return emp_repo.findByPosition(position);
	}
	
	public Employee updateEmployee(String idno,String familyname,String givenname,String position,String salary) {
		Employee emp=emp_repo.findByIdno(idno);
		emp.setFamilyname(familyname);
		emp.setGivenname(givenname);
		emp.setPosition(position);
		emp.setSalary(salary);
		return emp_repo.save(emp);
	}
	
}
