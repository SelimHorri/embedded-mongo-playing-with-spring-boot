package com.selimhorri.pack.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selimhorri.pack.model.Department;
import com.selimhorri.pack.repo.DepartmentRepository;

@RestController
@RequestMapping("/app/api/departments")
public class DepartmentResource {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping
	public ResponseEntity<List<Department>> findAll() {
		return ResponseEntity.ok(this.departmentRepository.findAll());
	}
	
	
	
}
