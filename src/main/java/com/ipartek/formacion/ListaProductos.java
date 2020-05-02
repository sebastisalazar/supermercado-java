package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;



/**
 * Ejemplo de como cerrar los recursos abiertos con versiones anteriores a Java 7
 * @see https://www.arquitecturajava.com/jdbc-java-try-with-resources/
 * 
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */
public class ListaProductos {

	public static void main(String[] args) {
		
		final String SQL = " SELECT id, nombre FROM producto ORDER BY id DESC; ";
		
		Connection conexion = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		

		try {
			
						
			// conectarnos a la bbdd supermercado			
			//conexion = DriverManager.getConnection ( URL, USUARIO, PASS);
			conexion = ConnectionManager.getConnection();
			
			System.out.println("Conexion con exito");
			
			
			//Realizar una consulta
			pst =  conexion.prepareStatement(SQL);
			rs = pst.executeQuery();
			
			System.out.println("Listado de productos");
			System.out.println("--------------------------------------");
			
			// consultar 1 a 1 los resultados, hasta que no existan mas registros
			while ( rs.next() ) {
				
				int id        = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				Producto p = new Producto(nombre);
				p.setId(id);
				
				
				System.out.println(p);
				//System.out.println(p.toString());
				
			}
			
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {                                        // este bloque siempre se ejecuta
			
			
			try {
				if ( rs != null ) {
					rs.close();
				}	
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
			try {
				if ( pst != null ) {
					pst.close();
				}	
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
			try {
				if ( conexion != null ) {
					conexion.close();
				}	
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
		}

		

		

	}

}
