package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

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

		try {
			Scanner sc = new Scanner(System.in);
			ProductoDAO dao = ProductoDAO.getInstance();
			Producto p= new Producto();
			
			System.out.println("Dime el nombre a introducir:");
			p.setNombre(sc.nextLine());
			dao.insert(p);
			
			System.out.println("El producto se ha insertado con exito, los datos son los siguientes");
			System.out.println(p);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
}
