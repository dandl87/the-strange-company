package com.protom.thestrangecompany.model.daoimpl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
import com.protom.thestrangecompany.dbconnections.MySqlConnection;
import com.protom.thestrangecompany.model.dao.EmployeeDAO;
import com.protom.thestrangecompany.model.entity.Employee;

public class EmployeeDAOimpl implements EmployeeDAO{
	
	private MySqlConnection mySqlConnection;
	
	

	public EmployeeDAOimpl(MySqlConnection mySqlConnection) {
		super();
		this.mySqlConnection = mySqlConnection;
	}

	@Override
	public boolean createEmployee(Employee employee) {

		String query ="INSERT into employee (name,surname,role,project_code) VALUES('"+employee.getName()+"','"+employee.getSurname()+"','"+employee.getRole()+"','"+employee.getProjectCode()+"');";
		
		PreparedStatement ps;
		try {
			
			ps = mySqlConnection.getConnection().prepareStatement(query);
			int result = ps.executeUpdate(query);
			if(result == 1) {
				System.out.println("employee inserted");
				return true;
			}  
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Error in db employee insert");
		return false;
		
	}

	@Override
	public Employee readEmployee(int idEmployee) {
		
		ResultSet rs; 
		
		try {
		String query = "SELECT * FROM employee WHERE id = " + idEmployee +";";
		
		PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
		
		
			rs = ps.executeQuery();
			
			rs.next();

			int id= rs.getInt("id");
			String name =rs.getString("name");
			String surname =rs.getString("surname");
			String role = rs.getString("role");
			String projectCode = rs.getString("project_code");  
			
			Employee employee = new Employee(id, name, surname, role, projectCode ); 
			return employee;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			System.out.println("Errore accesso a db!");
			return null;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		
		String query ="UPDATE employee set name ='"+employee.getName()+"', surname = '"+employee.getSurname()+"', role = '"+employee.getRole()+"', project_code = '"+employee.getProjectCode()+"' WHERE id="
				+ employee.getId()+");";
		
		PreparedStatement ps;
		try {
			
			ps = mySqlConnection.getConnection().prepareStatement(query);
			int result = ps.executeUpdate(query);
			if(result == 1) {
				System.out.println("employee updated");
				return true;
			}  
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Error in db employee update");
		return false;
	}

	@Override
	public boolean deleteEmployee(int idEmployee) {
		String query ="DELETE FROM employee WHERE id="+idEmployee+";";
				
		
		PreparedStatement ps;
		try {
			
			ps = mySqlConnection.getConnection().prepareStatement(query);
			int result = ps.executeUpdate(query);
			if(result == 1) {
				System.out.println("employee deleted");
				return true;
			}  
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Error in db employee delete");
		return false;
	}

	@Override
	public ArrayList<Employee> readAllEmployee() {
		
		ArrayList<Employee> listOfEmployee = new ArrayList<>();
		ResultSet rs; 
		
		try {
		String query = "SELECT * FROM employee;";
			
		
		PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
		
		
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
			
			int id= rs.getInt("id");
			String name =rs.getString("name");
			String surname =rs.getString("surname");
			String role = rs.getString("role");
			String projectCode = rs.getString("project_code");  
			
			Employee employee = new Employee(id, name, surname, role, projectCode ); 
			
			listOfEmployee.add(employee);
			}
			return listOfEmployee;
			
			} catch (SQLException e) {
			 
			System.out.println("Errore accesso a db!");
			return null;
		}
		
	}

	@Override
	public ArrayList<Employee> readAllEmployeeOfAProject(String projectCode) {
		ArrayList<Employee> listOfEmployee = new ArrayList<>();
		ResultSet rs; 
		
		try {
		String query = "SELECT * FROM employee WHERE project_code='"+projectCode+"';";
			
		
		PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
		
		
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
			
			int id= rs.getInt("id");
			String name =rs.getString("name");
			String surname =rs.getString("surname");
			String role = rs.getString("role");
			String projectCodeFromDb = rs.getString("project_code");  
			
			Employee employee = new Employee(id, name, surname, role, projectCodeFromDb ); 
			
			listOfEmployee.add(employee);
			}
			return listOfEmployee;
			
			} catch (SQLException e) {
			 
			System.out.println("Errore accesso a db!");
			return null;
		}
	}

}
