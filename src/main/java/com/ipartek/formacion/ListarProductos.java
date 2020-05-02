package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;



public class ListarProductos {

	public static void main(String[] args) {
		String URL_CONEXION="jdbc:mysql://localhost/supermercado";
		String USUARIO="debian-sys-maint";
		String PASS="o8lAkaNtX91xMUcV";
		String SQL= "SELECT id, nombre FROM producto ORDER BY nombre ASC;";
		
		
		try {
			
			System.out.println("\t COMPROBANDO CONEXION\n");
			//comprobar que tengamos el .jar de Mysql
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Existe el .jar para mysql");
			
			
			
			//CONEXION A BBDD
			Connection conexion=DriverManager.getConnection(URL_CONEXION,USUARIO,PASS);
			System.out.println("conexion con exito");
			System.out.println("\n*****************************\n");
			
			
			//REALIZAR CONSULTA
			System.out.println("\tREALIZANDO SELECT * FROM producto\n");
			PreparedStatement pst = conexion.prepareStatement(SQL);
			ResultSet rs=pst.executeQuery();
			
			
			
			
			
			//LEER DATOS QUE DEVUELVE LA QUERY
			System.out.println("\n\n\t Listado de productos\n");
			while (rs.next()) {
				int id        = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				Producto p = new Producto(nombre);
				p.setId(id);
				
				
				System.out.println(p);
				
			}
			
			System.out.println("\n*****************************\n");
			
			//INSERTAR PRODUCTOS
			System.out.println("\tREALIZANDO la siguiente query: \n 1- INSERT INTO producto (nombre, id_usuario) VALUES (1,);\n");
			System.out.println("\n 2- st.setString(1, \"Galletitas saladas2\");");
			String sql2="INSERT INTO producto (nombre, id_usuario) VALUES (?,1);";
			pst=conexion.prepareStatement(sql2);
			pst.setString(1, "Galletitas saladas2");
	
			int affectedrows = pst.executeUpdate();
			//si affectedrows es el numero de registros insertados
			
			System.out.println("Numero de registros insertados: "+affectedrows);
			System.out.println("\n*****************************\n");
			
			 
			
			//INSERTAR PRODUCTOS POR TECLADO
			System.out.println("\tRealizando la siguiente query:\n 1- INSERT INTO producto (nombre, id_usuario) VALUES (?,nombre);\n");
			boolean continuar=true;
			Scanner sc= new Scanner(System.in);
			System.out.print("Escribe el nombre del producto: ");
			String nombre= sc.nextLine();
			pst.setString(1, nombre);
			System.out.println("\nnombre= "+nombre);
			
			do {
				try {
					int filainsertadas= pst.executeUpdate();
					
					if (filainsertadas==1) {
						System.out.println("El producto se ha guardado con exito");
						continuar=false;
					}
				} catch (Exception e) {
					System.out.println("Lo sentimos pero el nombre ya existe, dime otro: ");
				}
			} while (continuar);
			
			System.out.println("\n*****************************\n");
			
		} catch (Exception e) {
			System.out.println("Lo sentimos pero el nombre ya existe en la base");
			e.printStackTrace();
		}
		System.out.println("\n*****************************\n");
		
		System.out.println("Agur, nos vemos otro dia");
		

	}

}
