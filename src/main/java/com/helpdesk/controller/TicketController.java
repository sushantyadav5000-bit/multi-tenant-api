package com.helpdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helpdesk.dto.TicketDto;
import com.helpdesk.entity.Ticket;
import com.helpdesk.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	TicketService service;
	
	@PostMapping
	public void save(@RequestBody Ticket ticket)
	{
		service.save(ticket);
	}
	
	@GetMapping
	public List<Ticket> findAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Ticket findById(@PathVariable("id") Long id)
	{
		return service.findById(id);
	}
	
	@GetMapping("/tenant/{tenantId}")
	public List<Ticket> findByTenantId(@PathVariable("tenantId") Long id)
	{
		return service.findByTenantId(id);
	}
	
	@GetMapping("/employee/{empId}")
	public List<Ticket> findByEmployeeId(@PathVariable("empId") Long id)
	{
		return service.findByEmployeeId(id);
	}
	
	@PutMapping
	public void update(@RequestBody Ticket ticket) {
	    service.update(ticket);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
	    service.delete(id);
	}
	
	@GetMapping("/page")
	public List<TicketDto> findAllPaginated(
	        @RequestParam(value = "page", defaultValue = "0") int page,
	        @RequestParam(value = "size", defaultValue = "10") int size) {
	    
	    return service.findAllPaginated(page, size);
	}
	
	
}
