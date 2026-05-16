package com.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.dao.TicketDao;
import com.helpdesk.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketDao dao;
	
	@Override
	public void save(Ticket ticket) {
		dao.save(ticket);
	}

	@Override
	public List<Ticket> findAll() {
		return dao.findAll();
	}

	@Override
	public Ticket findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Ticket> findByTenantId(Long tenantId) {
		return dao.findByTenantId(tenantId);
	}

	@Override
	public List<Ticket> findByEmployeeId(Long empId) {
		return dao.findByEmployeeId(empId);
	}

}
