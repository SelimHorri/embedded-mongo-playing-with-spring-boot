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

import com.selimhorri.pack.model.Department;
import com.selimhorri.pack.repo.DepartmentRepository;

@RestController
@RequestMapping("/app/api/departments")
public class DepartmentResource {
	
	private DepartmentRepository departmentRepository;
	
	public DepartmentResource(final DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Department>> findAll() {
		return new ResponseEntity<>(this.departmentRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> findById(@PathVariable("id") final String id) {
		return new ResponseEntity<>(this.departmentRepository.findById(id).orElseThrow(NoSuchElementException::new), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Department> save(final Department department) {
		return new ResponseEntity<>(this.departmentRepository.save(department), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Department> update(final Department department) {
		return new ResponseEntity<>(this.departmentRepository.save(department), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable("id") final String id) {
		this.departmentRepository.deleteById(id);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
	
}
