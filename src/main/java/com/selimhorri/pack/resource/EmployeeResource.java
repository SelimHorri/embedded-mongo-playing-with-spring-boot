package com.selimhorri.pack.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selimhorri.pack.model.Employee;
import com.selimhorri.pack.repo.EmployeeRepository;

@RestController
@RequestMapping("/app/api/employees")
public class EmployeeResource {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeResource(final EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAll() {
		return new ResponseEntity<>(this.employeeRepository.findAll(), HttpStatus.OK);
	}
	
	
	
}
