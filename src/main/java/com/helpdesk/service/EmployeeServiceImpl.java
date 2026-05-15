package com.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.dao.EmployeeDao;
import com.helpdesk.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public void save(Employee employee) {
		dao.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}

	@Override
	public Employee findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Employee> findByTenantId(Long tenantId) {
		return dao.findByTenantId(tenantId);
	}
	
	
	
}
