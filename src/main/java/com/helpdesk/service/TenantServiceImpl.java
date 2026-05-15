package com.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.dao.TenantDao;
import com.helpdesk.entity.Tenant;

@Service
public class TenantServiceImpl implements TenantService {

	@Autowired
	TenantDao dao;
	
	@Override
	public void save(Tenant tenant) {
		dao.save(tenant);
	}

	@Override
	public List<Tenant> findAll() {
		List<Tenant> tenant = dao.findAll();
		return tenant;
	}

	@Override
	public Tenant findById(Long id) {
		Tenant tenant = dao.findById(id);
		return tenant;
	}

}
