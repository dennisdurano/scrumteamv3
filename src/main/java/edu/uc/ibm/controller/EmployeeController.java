package edu.uc.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uc.ibm.models.Employee;
import edu.uc.ibm.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService emp_service;
	
	@RequestMapping("/createemployee")
	public String create(@RequestParam String idno,@RequestParam String familyname,@RequestParam String givenname,@RequestParam String position,@RequestParam String salary) {
		Employee emp=emp_service.create(idno, familyname, givenname, position, salary);
		return emp.toString();
	}
	
	@RequestMapping("/getemployee")
	public Employee getEmployee(@RequestParam String idno) {
		return emp_service.findEmployeeByIdno(idno);
	}
	
	@RequestMapping("/getallemployee")
	public List<Employee> getAllEmployee(){
		return emp_service.getAll();
	}
	
	@RequestMapping("/updateemployee")
	public String updateEmployee(@RequestParam String idno,@RequestParam String familyname,@RequestParam String givenname,@RequestParam String position,@RequestParam String salary) {
		Employee emp=emp_service.updateEmployee(idno, familyname, givenname, position, salary);
		return emp.toString();
	}
	
	@RequestMapping("/deleteemployee")
	public String deleteEmployee(String idno) {
		emp_service.deleteEmployeeByIdno(idno);
		return "Deleted : "+idno;
	}
	
	@RequestMapping("/deleteallemployee")
	public void deleteAllEmployee() {
		emp_service.deleteAll();
	}
	
	@RequestMapping("/findposition")
	public List<Employee>findAllEmployeeByPosition(@RequestParam String position){
		return emp_service.findAllEmployeeByPosition(position);
	}
	
	
}
