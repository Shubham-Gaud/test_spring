package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private Empservice empservice;
	
	
   
	@Autowired
    public EmployeeController(Empservice empservice) {
	
		this.empservice = empservice;
	}
    
    
    @GetMapping("/greet")
    public String greet() {
        throw new NullPointerException("Null pointer argument");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> NullPointerException(NullPointerException ex) {
        return new ResponseEntity<>("Handled Exception: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
	// GET all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return empservice.getAllEmployees();
    }

    // GET employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return empservice.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create a new employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return empservice.createEmployee(employee);
    }
    
    // PUT update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        try {
            return ResponseEntity.ok(empservice.updateEmployee(id, employeeDetails));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    	empservice.deleteEmployee(id);	
        return ResponseEntity.noContent().build();
    }

  
}
