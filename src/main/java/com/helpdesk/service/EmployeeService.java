package com.helpdesk.service;

import java.util.List;

import com.helpdesk.entity.Employee;

public interface EmployeeService {

	void save(Employee employee);
	
	List<Employee> findAll();
	
	Employee findById(Long id);
	
	List<Employee> findByTenantId(Long tenantId);
	
}
