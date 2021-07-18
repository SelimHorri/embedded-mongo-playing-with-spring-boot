package com.selimhorri.pack.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@Field
	private String fname;
	
	@Field
	private String lname;
	
	@Field
	private Department department;
	
	
	
}
