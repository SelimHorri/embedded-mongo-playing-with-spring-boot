package com.selimhorri.pack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.selimhorri.pack.model.Department;
import com.selimhorri.pack.model.Employee;
import com.selimhorri.pack.repo.DepartmentRepository;
import com.selimhorri.pack.repo.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class EmbeddedMongoPlayingWithSpringBootApplication {
	
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmbeddedMongoPlayingWithSpringBootApplication.class, args);
	}
	
	// @Profile(value = {"!prod"})
	public CommandLineRunner run() throws Exception {
		return args -> {
			// this.departmentRepository.save(new Department("billing"));
			this.departmentRepository.save(
				Department.builder()
					.departmentName("billing")
					.build()
			);
			this.departmentRepository.save(
				Department.builder()
					.departmentName("dwh")
					.build()
			);
			this.employeeRepository.save(
				Employee.builder()
					.fname("selim")
					.lname("horri")
					.department(new Department("", "billing", null))
					.build()
			);
			this.employeeRepository.save(
				Employee.builder()
					.fname("imen")
					.lname("touk")
					.department(new Department("", "dwh", null))
					.build()
			);
			this.employeeRepository.save(
				Employee.builder()
					.fname("badr")
					.lname("idoudi")
					.department(new Department("", "digital", null))
					.build()
			);
			
			this.departmentRepository.findAll().forEach(System.out::println);
			this.employeeRepository.findAll().forEach(System.out::println);
		};
	}
	
	
	
}







