package com.selimhorri.pack.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.selimhorri.pack.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
}
