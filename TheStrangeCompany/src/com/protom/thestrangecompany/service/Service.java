package com.protom.thestrangecompany.service;

import java.util.ArrayList;

import com.protom.thestrangecompany.dbconnections.MySqlConnection;
import com.protom.thestrangecompany.model.dao.EmployeeDAO;
import com.protom.thestrangecompany.model.dao.ProjectDAO;
import com.protom.thestrangecompany.model.daoimpl.EmployeeDAOimpl;
import com.protom.thestrangecompany.model.daoimpl.ProjectDAOimpl;
import com.protom.thestrangecompany.model.entity.Project;

public class Service {
	
	//requisito funzionale 1 stampa info progetto 
	//requisito funzionale 2 inserisci un nuovo progetto specificando i componenti del team
	// che devono essere impiegati presenti e non assegnati ad altri progetti
	//requisito funzionale 3 inserisci nuovo impiegato
	// requisito funzionale 4 assegna impiegato a progetto
	// requisito funzionale 5 
	
	// requisito non funzionale 3 verifica che il dipendente non è assegnato a nessun progetto
	// il db deve essere relazionale
	// il software deve essere accessibile da qualsiasi pc collegato a internet previa autenticazione
	
	private EmployeeDAO employeeDAO;
	private ProjectDAO projectDAO;
	
	public Service(MySqlConnection mySqlConnection) {
		super();
		this.employeeDAO = new EmployeeDAOimpl(mySqlConnection);
		this.projectDAO = new ProjectDAOimpl(mySqlConnection);
	}
	
	public void stampaInfoPrj(String nomePrj) {
		
		ArrayList<Project> listOfProject = projectDAO.readAllProject();
		for(Project prj: listOfProject) {
			if(prj.getName().equals(nomePrj))
				System.out.println(prj);
		}
		
		
	}
	

}
