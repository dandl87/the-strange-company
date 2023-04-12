package com.protom.thestrangecompany.model.entity;

public class Employee {
	
	private int id;
	private String name;
	private String surname;
	private String role;
	private String projectCode;
	
	public Employee(int id, String name, String surname, String role, String projectCode) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.projectCode = projectCode;
	}

	public Employee(String name, String surname, String role, String projectCode) {
		super();
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.projectCode = projectCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", role=" + role + ", projectCode="
				+ projectCode + "]";
	}
	
	
	
	
	

}
