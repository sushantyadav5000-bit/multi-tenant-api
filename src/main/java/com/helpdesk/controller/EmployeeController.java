package com.helpdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpdesk.entity.Employee;
import com.helpdesk.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public void save(@RequestBody Employee employee)
	{
		service.save(employee);
	}
	
	@GetMapping
	public List<Employee> findAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") Long id)
	{
		return service.findById(id);
	}
	
	@GetMapping("/tenant/{tenantId}")
	public List<Employee> findByTenantId(@PathVariable("tenantId") Long tenantId)
	{
		return service.findByTenantId(tenantId);
	}
	
}
