package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Viewcontroller {

	Empservice empservice;
	
	@Autowired
	public Viewcontroller(Empservice empservice) {
		super();
		this.empservice = empservice;
	}
	
	
	@GetMapping
	public List<Employee> getallemployees(){
		return empservice.getAllEmployees();
	}
	
	@PostMapping
	public Employee createemployee(@RequestBody Employee employee) {
		return empservice.createEmployee(employee);
	}
	

	
	
	
	
}
