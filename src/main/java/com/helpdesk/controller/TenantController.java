package com.helpdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpdesk.entity.Tenant;
import com.helpdesk.service.TenantService;

@RestController
@RequestMapping("/tenants")
public class TenantController {

	@Autowired
	private TenantService service;
	
	@GetMapping
	public List<Tenant> findAll()
	{
		return service.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody Tenant tenant)
	{
		service.save(tenant);
	}
	
	@GetMapping("/{id}")
	public Tenant findById(@PathVariable Long id)
	{
		Tenant tenant = service.findById(id);
		return tenant;
	}
	
}
