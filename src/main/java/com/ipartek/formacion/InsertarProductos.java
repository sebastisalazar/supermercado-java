package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * 
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */
public class InsertarProductos {

	public static void main(String[] args) {

		final String URL = "jdbc:mysql://localhost/supermercado";
		final String USUARIO = "debian-sys-maint";
		final String PASS = "o8lAkaNtX91xMUcV";
		final String SQL = " INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1) ; ";
		boolean continuar = true; 

		try(
				Connection conexion = DriverManager.getConnection(URL, USUARIO, PASS);	
				PreparedStatement pst = conexion.prepareStatement(SQL);
				Scanner sc = new Scanner(System.in);
				
				) {

			

			// comprobar que tengamos el .jar de MySQL
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Existe el .jar para mysql");

			
			
		
			
			do {
			
				String nombre = sc.nextLine();
	
				// cambiamos el 1º ? de la SQL por la varaiabel nombre
				// INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1) ;
				pst.setString(1, nombre);
	
				try {
					
					int affectedRows = pst.executeUpdate();
					// affedetedRows es el numero de registros insertados
					if (affectedRows == 1) {
						System.out.println("El producto se ha guardado con exito");
						continuar = false;
					}
					
				} catch (Exception e) {
					System.out.println("Lo sentimos pero el nombre ya existe, dime otro:");
					
				}
				
			} while(continuar);	
				

		} catch (Exception e) {

			System.out.println("Tenemos un problema " + e.getMessage());

		}
		
		System.out.println("Agur, nos vemos otro día");

	}

}
