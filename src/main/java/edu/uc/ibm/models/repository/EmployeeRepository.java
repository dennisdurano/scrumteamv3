package edu.uc.ibm.models.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.uc.ibm.models.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String>{

	public Employee findByIdno(String idno);
	public boolean deleteByIdno(String idno);
	public List<Employee> findByPosition(String position);

}
