package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcontroller {
	
	
	private Empservice empservice;
	
	
	@Autowired
	public Testcontroller(Empservice empservice) {
		
		this.empservice = empservice;
	}

	@PostMapping("/oktest")
	public Employee saveemployee(@RequestBody Employee employee) {
		return empservice.createEmployee(employee);
	}

	@GetMapping("/oktest")
	public List<Employee> getallemployees(){
		return empservice.getAllEmployees();
	}
	
	
	

}
