package com.helpdesk.dao;

import java.util.List;

import com.helpdesk.entity.Ticket;

public interface TicketDao {

	void save(Ticket ticket);
	
	List<Ticket> findAll();
	
	Ticket findById(Long id);
	
	List<Ticket> findByTenantId(Long tenantId);
	
	List<Ticket> findByEmployeeId(Long employeeId);
	
}
