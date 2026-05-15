package com.helpdesk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.helpdesk.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void save(Employee employee) {
		em.persist(employee);
	}

	@Override
	public List<Employee> findAll() {
		return em.createQuery("FROM Employee", Employee.class).getResultList();
	}

	@Override
	public Employee findById(Long id) {
		return em.find(Employee.class, id);
	}

	@Override
	public List<Employee> findByTenantId(Long tenantId) {
		Query query =  em.createQuery("FROM Employee e WHERE e.tenant.id = :tenantId");
		query.setParameter("tenantId", tenantId);
		return query.getResultList();
	}

}
