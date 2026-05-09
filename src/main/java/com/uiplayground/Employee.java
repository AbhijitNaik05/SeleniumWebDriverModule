package com.uiplayground;

public class Employee {
	private String id;
	private String name;
	private String role;
	private String company;
	private String salary;
	private String status;
	private String joined;

	public Employee(String id, String name, String role, String company, String salary, String status, String joined) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.company = company;
		this.salary = salary;
		this.status = status;
		this.joined = joined;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJoined() {
		return joined;
	}

	public void setJoined(String joined) {
		this.joined = joined;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", company=" + company + ", salary="
				+ salary + ", status=" + status + ", joined=" + joined + "]";
	}

}
