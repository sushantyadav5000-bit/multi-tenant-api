package com.helpdesk.service;

import java.util.List;

import com.helpdesk.entity.Ticket;

public interface TicketService {

void save(Ticket ticket);
	
	List<Ticket> findAll();
	
	Ticket findById(Long id);
	
	List<Ticket> findByTenantId(Long tenantId);
	
	List<Ticket> findByEmployeeId(Long employeeId);
	
}
