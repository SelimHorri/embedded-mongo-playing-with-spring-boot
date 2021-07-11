package com.selimhorri.pack.resource;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable("id") final String id) {
		return new ResponseEntity<>(this.employeeRepository.findById(id).orElseThrow(NoSuchElementException::new), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employee> save(final Employee employee) {
		return new ResponseEntity<>(this.employeeRepository.save(employee), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Employee> update(final Employee employee) {
		return new ResponseEntity<>(this.employeeRepository.save(employee), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable("id") final String id) {
		this.employeeRepository.deleteById(id);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
	
}
