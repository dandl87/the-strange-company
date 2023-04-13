package com.protom.thestrangecompany.demo;

import com.protom.thestrangecompany.dbconnections.MySqlConnection;
import com.protom.thestrangecompany.model.dao.ProjectDAO;
import com.protom.thestrangecompany.model.daoimpl.ProjectDAOimpl;
import com.protom.thestrangecompany.model.entity.Project;

public class Programma1 {
	
	public static void main(String[] args) {
		
		MySqlConnection mySqlConnection = MySqlConnection.getInstance();
		
		mySqlConnection.avviaConnessione();
		
		ProjectDAO prjDAO = new ProjectDAOimpl(mySqlConnection);
		
		
		
		Project project1 = prjDAO.readProject("Pj001");
		
		
		System.out.println(project1);
		
		
		
		
		mySqlConnection.chiudiConnessione();
		
	}

}
