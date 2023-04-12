package com.protom.thestrangecompany.model.entity;

import java.util.ArrayList;

public class Project {
	
	private String code;
	private String name;
	private String description;
	private ArrayList<Employee> team;
	
	
	public Project(String code, String name, String description, ArrayList<Employee> team) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.team = team;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public ArrayList<Employee> getTeam() {
		return team;
	}


	public void setTeam(ArrayList<Employee> team) {
		this.team = team;
	}


	@Override
	public String toString() {
		return "Project [code=" + code + ", name=" + name + ", description=" + description + ", team components=" + team.size() + "]";
	}
	
	

}
