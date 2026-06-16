package com.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.dao.EmployeeDao;
import com.helpdesk.dao.TicketDao;
import com.helpdesk.entity.Employee;
import com.helpdesk.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao dao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void save(Ticket ticket) {
	    
	    // 1. Check if they are trying to assign a worker to this ticket
	    if (ticket.getAssignedTo() != null && ticket.getAssignedTo().getId() != null) {
	        
	        // 2. Fetch the REAL worker from the database
	        Employee realEmployee = employeeDao.findById(ticket.getAssignedTo().getId());
	        
	        // 3. Compare the Company IDs
	        Long ticketCompanyId = ticket.getTenant().getId();
	        Long workerCompanyId = realEmployee.getTenant().getId();
	        
	        if (!ticketCompanyId.equals(workerCompanyId)) {
	            // SECURITY BREACH! Stop the program and throw an error.
	            throw new RuntimeException("SECURITY ALERT: Cannot assign a worker from a different company to this ticket!");
	        }
	    }
	    
	    // 4. If we made it this far, the data is safe. Tell the DAO to save it.
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

	@Override
	public void update(Ticket ticket) {
		
		if (ticket.getAssignedTo() != null && ticket.getAssignedTo().getId() != null) {
	    	
	        Employee realEmployee = employeeDao.findById(ticket.getAssignedTo().getId());
	        
	        Long ticketCompanyId = ticket.getTenant().getId();
	        Long workerCompanyId = realEmployee.getTenant().getId();
	        
	        if (!ticketCompanyId.equals(workerCompanyId)) {
	            throw new RuntimeException("SECURITY ALERT: Cannot assign a worker from a different company to this ticket!");
	        }
	    }
		dao.update(ticket);
		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	public List<Ticket> findAllPaginated(int page, int size) {
		return dao.findAllPaginated(page, size);
	}

}
