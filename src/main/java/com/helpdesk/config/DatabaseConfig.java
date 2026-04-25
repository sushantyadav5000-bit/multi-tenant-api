package com.helpdesk.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	//Connecting To Database
	@Bean
	public DriverManagerDataSource createDMDS()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/helpdesk_db");
		ds.setUsername("postgres");
		ds.setPassword("root");
		
		return ds;
	}
	
	//Telling Spring that what tables to create
	@Bean
	public LocalContainerEntityManagerFactoryBean createEMF()
	{
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(createDMDS());
		emf.setPackagesToScan("com.helpdesk.entity");
		HibernateJpaVendorAdapter hibernate = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(hibernate);
		Properties property = new Properties();
		property.setProperty("hibernate.hbm2ddl.auto", "update");
		property.setProperty("hibernate.show_sql", "true");
		emf.setJpaProperties(property);
		
		return emf;
	}
	
	//Giving control of Transaction Management to spring (Replaces begin and commit methods)
	@Bean
	public JpaTransactionManager createTM()
	{
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(createEMF().getObject());
		 return tm;
	}
	
}
