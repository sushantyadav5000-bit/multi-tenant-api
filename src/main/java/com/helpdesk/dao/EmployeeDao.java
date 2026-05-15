package com.helpdesk.dao;

import java.util.List;

import com.helpdesk.entity.Employee;

public interface EmployeeDao {

	void save(Employee employee);
	
	List<Employee> findAll();
	
	Employee findById(Long id);
	
	List<Employee> findByTenantId(Long tenantId);
	
}
