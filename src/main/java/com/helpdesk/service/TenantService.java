package com.helpdesk.service;

import java.util.List;

import com.helpdesk.entity.Tenant;

public interface TenantService {

	void save(Tenant tenant);
	
	List<Tenant> findAll();
	
	Tenant findById(Long id);
	
	void update(Tenant tenant);
	
	void delete(Long id);
	
}
