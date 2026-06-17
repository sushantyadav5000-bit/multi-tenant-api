package com.helpdesk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.dao.EmployeeDao;
import com.helpdesk.dao.TicketDao;
import com.helpdesk.dto.TicketDto;
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
	public List<TicketDto> findAllPaginated(int page, int size) {
	    // 1. Get the heavy data from the DAO
	    List<Ticket> rawTickets = dao.findAllPaginated(page, size);
	    
	    // 2. Create an empty list for our clean DTOs
	    List<TicketDto> cleanTickets = new ArrayList<>();
	    
	    // 3. Translate each ticket
	    for (Ticket ticket : rawTickets) {
	        cleanTickets.add(convertToDto(ticket));
	    }
	    
	    // 4. Return the clean list!
	    return cleanTickets;
	}
	
	private TicketDto convertToDto(Ticket ticket) {
	    TicketDto dto = new TicketDto();
	    dto.setId(ticket.getId());
	    dto.setTitle(ticket.getTitle());
	    dto.setStatus(ticket.getStatus());
	    
	    // Flatten the Tenant object into a simple string
	    dto.setCompanyName(ticket.getTenant().getCompanyName());
	    
	    // Flatten the Employee object into a simple string (with a null check!)
	    if (ticket.getAssignedTo() != null) {
	        dto.setAssignedWorker(ticket.getAssignedTo().getFirstName() + " " + ticket.getAssignedTo().getLastName());
	    } else {
	        dto.setAssignedWorker("Unassigned");
	    }
	    
	    return dto;
	}

}
