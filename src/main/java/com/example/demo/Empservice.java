package com.example.demo;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

@Service
public class Empservice {
	
	private Emprepository emprepository;
	
	

	
	
	 public Empservice(Emprepository emprepository) {
		
		this.emprepository = emprepository;
	}

	public List<Employee> getAllEmployees() {
	        return emprepository.findAll();
	    }

	    public Optional<Employee> getEmployeeById(Long id) {
	        return emprepository.findById(id);
	    }

	    public Employee createEmployee(Employee employee) {
	        return emprepository.save(employee);
	    } 
	    

	    public Employee updateEmployee(Long id, Employee employeeDetails) {
	        Employee employee = emprepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
	        
	        
	        employee.setName(employeeDetails.getName());
	        employee.setDepartment(employeeDetails.getDepartment());
	       
	        
	        return emprepository.save(employee);
	    }

	    public void deleteEmployee(Long id) {
	    	emprepository.deleteById(id);
	    }
	
	

}
