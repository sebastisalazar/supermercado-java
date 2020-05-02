package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	
	private final static String URL = "jdbc:mysql://localhost/supermercado";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "o8lAkaNtX91xMUcV";
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Connection con = null;
		
		// comprobar que tengamos el .jar de MySQL
		Class.forName("com.mysql.jdbc.Driver");
		
		//establecer conexion
		con = DriverManager.getConnection(URL, USUARIO, PASS);
		
		return con;
	};
	

}
