package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;

/**
 * 
 * 
 * Usamos executeUpdate() siempre que usamos una SQL con (INSERT, DELETE o UPDATE ) y nos retorna "int" con numero de filas afectadas 
 * 
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php 
 * @author javaee
 *
 */
public class InsertarProductosConDAO {

	
	
	public static void main(String[] args) {


		final String SQL = " INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1) ; ";
		boolean continuar = true; 
				

		try(
				Connection conexion = ConnectionManager.getConnection();	
				PreparedStatement pst = conexion.prepareStatement(SQL);
				Scanner sc = new Scanner(System.in);
				
			){
	
		
			
			do {
				System.out.println("Dime el nombre del producto a guardar");
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
