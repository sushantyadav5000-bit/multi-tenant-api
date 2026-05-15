package com.helpdesk.service;

import java.util.List;

import com.helpdesk.entity.Tenant;

public interface TenantService {

	void save(Tenant tenant);
	
	List<Tenant> findAll();
	
	Tenant findById(Long id);
	
}
