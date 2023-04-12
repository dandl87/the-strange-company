package com.protom.thestrangecompany.model.dao;

import java.util.ArrayList;

import com.protom.thestrangecompany.model.entity.Employee; 

public interface EmployeeDAO {
	
	boolean createEmployee(Employee employee);
	Employee readEmployee(int idEmployee);
	boolean updateEmployee(Employee employee); 
	boolean deleteEmployee(int idEmployee);
	
	
	ArrayList<Employee> readAllEmployee();
	ArrayList<Employee> readAllEmployeeOfAProject(String projectCode);
	


}
