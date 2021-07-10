package com.selimhorri.pack.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.selimhorri.pack.model.Department;

public interface DepartmentRepository extends MongoRepository<Department, Integer> {
	
}
