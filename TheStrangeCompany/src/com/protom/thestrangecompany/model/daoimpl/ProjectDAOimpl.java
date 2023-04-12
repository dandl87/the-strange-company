package com.protom.thestrangecompany.model.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.protom.thestrangecompany.dbconnections.MySqlConnection;
import com.protom.thestrangecompany.model.dao.EmployeeDAO;
import com.protom.thestrangecompany.model.dao.ProjectDAO;
import com.protom.thestrangecompany.model.entity.Employee;
import com.protom.thestrangecompany.model.entity.Project;

public class ProjectDAOimpl implements ProjectDAO{
	
	private MySqlConnection mySqlConnection;
	
	

	public ProjectDAOimpl(MySqlConnection mySqlConnection) {
		super();
		this.mySqlConnection = mySqlConnection;
	}

	@Override
	public boolean createProject(Project project) {
		String query ="INSERT into project (code,name,descrizione) VALUES('"+project.getCode()+"','"+project.getName()+"','"+project.getDescription()+"');";
				
			PreparedStatement ps;
			try {
					
				ps = mySqlConnection.getConnection().prepareStatement(query);
				int result = ps.executeUpdate(query);
					if(result == 1) {
						System.out.println("project inserted");
						return true;
						}  
				
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("Error in db project insert");
			return false;
	}

	@Override
	public Project readProject(String projectCode) {
		ResultSet rs; 
				
				try {
				String query = "SELECT * FROM project WHERE project_code = '" + projectCode +"';";
				
				PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
				
				
					rs = ps.executeQuery();
					
					rs.next();
		 
					String code =rs.getString("code");
					String name =rs.getString("name");
					String description = rs.getString("descrizione"); 
					
					EmployeeDAO employeeDAO = new EmployeeDAOimpl(mySqlConnection);
					ArrayList<Employee> listOfEmployee = employeeDAO.readAllEmployeeOfAProject(projectCode); 
					
					Project project = new Project(code,name,description,listOfEmployee);
					return project;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block 
					System.out.println("Errore accesso a db!");
					return null;
				}
	}

	@Override
	public boolean updateProject(Project project) {
		
		String query ="UPDATE project set name ='"+project.getName()+"', description = '"+project.getDescription()+"' WHERE code='"+project.getCode()+"';";
				 
		PreparedStatement ps;
		try {
			
			ps = mySqlConnection.getConnection().prepareStatement(query);
			int result = ps.executeUpdate(query);
			if(result == 1) {
				System.out.println("project updated");
				return true;
			}  
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Error in db project update");
		return false;
	}

	@Override
	public boolean deleteProject(String projectCode) {
		String query ="DELETE FROM project WHERE code='"+projectCode+"';";
						
				
				PreparedStatement ps;
				try {
					
					ps = mySqlConnection.getConnection().prepareStatement(query);
					int result = ps.executeUpdate(query);
					if(result == 1) {
						System.out.println("project deleted");
						return true;
					}  
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Error in db project delete");
				return false;
	}

	@Override
	public ArrayList<Project> readAllProject() {
		ArrayList<Project> listOfProject = new ArrayList<>();
		ResultSet rs; 
		
		try {
		String query = "SELECT * FROM project;";
		
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
		
		
			rs = ps.executeQuery();
			
			while(rs.next()) {
 
			String code =rs.getString("code");
			String name =rs.getString("name");
			String description = rs.getString("descrizione"); 
			
			EmployeeDAO employeeDAO = new EmployeeDAOimpl(mySqlConnection);
			ArrayList<Employee> listOfEmployee = employeeDAO.readAllEmployeeOfAProject(code); 
			
			Project project = new Project(code,name,description,listOfEmployee);
			listOfProject.add(project);
		 
		}
			return listOfProject;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			System.out.println("Errore accesso a db!");
			return null;
		}
	}

}
