package com.helpdesk.service;

import java.util.List;

import com.helpdesk.dto.TicketDto;
import com.helpdesk.entity.Ticket;

public interface TicketService {

void save(Ticket ticket);
	
	List<TicketDto> findAll();
	
	TicketDto findById(Long id);
	
	List<TicketDto> findByTenantId(Long tenantId);
	
	List<TicketDto> findByEmployeeId(Long employeeId);
	
	void update(Ticket ticket);
	
	void delete(Long id);
	
	List<TicketDto> findAllPaginated(int page, int size);
	
}
