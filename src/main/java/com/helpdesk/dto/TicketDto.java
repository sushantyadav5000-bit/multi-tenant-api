package com.helpdesk.dto;

public class TicketDto {

	private Long id;
	private String title;
	private String status;
	private String companyName;
	private String assignedWorker;
	
	public TicketDto()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAssignedWorker() {
		return assignedWorker;
	}

	public void setAssignedWorker(String assignedWorker) {
		this.assignedWorker = assignedWorker;
	}
	
}
