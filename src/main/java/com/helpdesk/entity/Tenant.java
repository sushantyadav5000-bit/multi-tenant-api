package com.helpdesk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tenants")
public class Tenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*Hibernate checks if an ID is null to figure out if it's a brand new record it needs to INSERT, or an existing record
	it needs to UPDATE. If you use primitive long, Hibernate sees 0 and might get confused, thinking it's trying to update a record with ID #0! */
	private Long id;
	
	@Column(name = "company_name", nullable = false)
	private String companyName;
	
	@Column(name = "contact_email", unique = true)
	@NotBlank(message = "Contact email cannot be empty")
	@Email(message = "Must be a valid email address")
	private String contactEmail;
	
	@Column(name = "subscription_status")
	private String subscriptionStatus = "TRIAL";
	
	public Tenant()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	
}
