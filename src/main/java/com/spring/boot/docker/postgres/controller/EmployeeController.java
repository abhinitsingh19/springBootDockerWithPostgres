package com.spring.boot.docker.postgres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.docker.postgres.exception.ResourceNotFoundException;
import com.spring.boot.docker.postgres.model.Employee;
import com.spring.boot.docker.postgres.repository.EmployeeRepository;

@RestController
public class EmployeeController 
{

	@Autowired
	private EmployeeRepository empRepository;
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	
	{
		return ResponseEntity.ok(empRepository.save(emp));
		
	}
	
	@GetMapping("/employee")
	public List<Employee> findAllEmployees()
	
	{
		return empRepository.findAll();
		
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable int id)
	{
		 Employee employee = empRepository.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Employee Not found"));
		return ResponseEntity.ok().body(employee);
		 
		
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable int id)
	{
		
		Employee employee = empRepository.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Employee Not found"));
		empRepository.delete(employee);
		
		return ResponseEntity.ok().build();
		 
		
	}
}
