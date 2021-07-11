package com.selimhorri.pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.selimhorri.pack.model.Department;
import com.selimhorri.pack.model.Employee;
import com.selimhorri.pack.repo.DepartmentRepository;
import com.selimhorri.pack.repo.EmployeeRepository;

@SpringBootApplication
public class EmbeddedMongoPlayingWithSpringBootApplication implements CommandLineRunner {
	
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	
	@Autowired
	public EmbeddedMongoPlayingWithSpringBootApplication(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EmbeddedMongoPlayingWithSpringBootApplication.class, args);
	}
	
	@Override
	// @Profile(value = {"!prod"})
	public void run(String... args) throws Exception {
		this.departmentRepository.save(new Department("billing"));
		this.departmentRepository.save(new Department("dwh"));
		this.employeeRepository.save(new Employee("selim", "horri", new Department("billing")));
		this.employeeRepository.save(new Employee("imen", "touk", new Department("dwh")));
		this.employeeRepository.save(new Employee("badr", "idoudi", new Department("digital")));
		
		this.departmentRepository.findAll().forEach(System.out::println);
		this.employeeRepository.findAll().forEach(System.out::println);
	}
	
	
	
}







