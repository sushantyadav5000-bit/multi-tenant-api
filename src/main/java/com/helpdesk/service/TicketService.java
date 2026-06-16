package com.helpdesk.service;

import java.util.List;

import com.helpdesk.entity.Ticket;

public interface TicketService {

void save(Ticket ticket);
	
	List<Ticket> findAll();
	
	Ticket findById(Long id);
	
	List<Ticket> findByTenantId(Long tenantId);
	
	List<Ticket> findByEmployeeId(Long employeeId);
	
	void update(Ticket ticket);
	
	void delete(Long id);
	
	List<Ticket> findAllPaginated(int page, int size);
	
}
