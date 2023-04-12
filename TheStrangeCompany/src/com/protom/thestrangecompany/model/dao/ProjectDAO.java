package com.protom.thestrangecompany.model.dao;

import java.util.ArrayList;

import com.protom.thestrangecompany.model.entity.Project;
 

public interface ProjectDAO {
	
	boolean createProject(Project project);
	Project readProject(String projectCode);
	boolean updateProject(Project project); 
	boolean deleteProject(String projectCode);
	
	
	ArrayList<Project> readAllProject(); 
	

}
