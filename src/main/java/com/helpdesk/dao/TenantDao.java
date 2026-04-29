package com.helpdesk.dao;

import java.util.List;

import com.helpdesk.entity.Tenant;

/*In enterprise Java, we always create an interface first. This acts as a contract so the rest 
 * of your application knows what database actions are available, without needing to know 
 * the complex SQL behind them.
*/

public interface TenantDao {

	void save(Tenant tenant);
	
	List<Tenant> findAll();
	
	Tenant findById(Long id);
	
}
