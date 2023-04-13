package com.protom.thestrangecompany.demo;

import java.sql.PreparedStatement;

import com.protom.thestrangecompany.dbconnections.MySqlConnection;
import com.protom.thestrangecompany.service.Service;

public class Programma2 {
	
	public static void main(String[] args) {
		
		//inserisci operazione 
		// 1 -> stampa Project
		// 2 -> inserisci nuovo Project
		
		MySqlConnection mySqlConnection = MySqlConnection.getInstance();
		mySqlConnection.avviaConnessione();
		
		
		Service service = new Service(mySqlConnection);
		
		service.stampaInfoPrj("CodeForBreakfast");
		
		
		mySqlConnection.chiudiConnessione();
		
		
	}

}
