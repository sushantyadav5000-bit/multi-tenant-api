package com.helpdesk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.helpdesk.entity.Ticket;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class TicketDaoImpl implements TicketDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void save(Ticket ticket) {
		em.persist(ticket);
	}

	@Override
	public List<Ticket> findAll() {
		return em.createQuery("FROM Ticket", Ticket.class).getResultList();
	}

	@Override
	public Ticket findById(Long id) {
		return em.find(Ticket.class, id);
	}

	@Override
	public List<Ticket> findByTenantId(Long tenantId) {
		Query query = em.createQuery("FROM Ticket t WHERE t.tenant.id = :tenantId", Ticket.class);
		query.setParameter("tenantId", tenantId);
		return query.getResultList();
	}

	@Override
	public List<Ticket> findByEmployeeId(Long empId) {
		Query query = em.createQuery("FROM Ticket t WHERE t.assignedTo.id = :empId", Ticket.class);
		query.setParameter("empId", empId);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void update(Ticket ticket) {
	    em.merge(ticket);
	}

	@Override
	@Transactional
	public void delete(Long id) {
	    // To delete an object, Hibernate requires to find it first
	    Ticket ticket = em.find(Ticket.class, id);
	    if (ticket != null) {
	        em.remove(ticket);
	    }
	}

	@Override
	public List<Ticket> findAllPaginated(int page, int size) {
		// If page is 0 and size is 10, offset = 0 (Skip nothing, get first 10)
	    // If page is 1 and size is 10, offset = 10 (Skip first 10, get next 10)
	    int offset = page * size;
	    
	    return em.createQuery("FROM Ticket", Ticket.class)
	            .setFirstResult(offset)  // This is SQL OFFSET
	            .setMaxResults(size)     // This is SQL LIMIT
	            .getResultList();
	}

}
