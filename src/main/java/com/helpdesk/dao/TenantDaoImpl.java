package com.helpdesk.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.helpdesk.entity.Tenant;
import com.helpdesk.entity.Ticket;

// 1. Tells Spring: "Manage this class, and translate any raw SQL errors into clean Java errors."
@Repository 
public class TenantDaoImpl implements TenantDao {

    // 2. Automatically grabs the EntityManager we built in your DatabaseConfig!
    @PersistenceContext
    private EntityManager em;

    // 3. Automatically runs begin() and commit() around this method!
    @Override
    @Transactional
    public void save(Tenant tenant) {
        em.persist(tenant);
    }

    // Notice we don't need @Transactional here because we are only reading data, not writing it!
    @Override
    public List<Tenant> findAll() {
        // This is JPQL (Java Persistence Query Language) - it selects the Object, not the table!
        return em.createQuery("FROM Tenant", Tenant.class).getResultList();
    }

    @Override
    public Tenant findById(Long id) {
        return em.find(Tenant.class, id);
    }

	@Override
	@Transactional
	public void update(Tenant tenant) {
		em.merge(tenant);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Tenant tenant = em.find(Tenant.class, id);
	    if (tenant != null) {
	        em.remove(tenant);
	    }
	}
}