package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;



/**
 * Ejemplo de como cerrar los recursos abiertos con versiones anteriores a Java 7
 * @see https://www.arquitecturajava.com/jdbc-java-try-with-resources/
 * 
 * Usamos executeQuery() siempre que usamos una SQL con SELECT y nos retorna los resultados en ResultSet
 * 
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */
public class ListaProductosUsandoDAO {

	public static void main(String[] args) {
		
		// ProductoDAO dao = new ProductoDAO(); 
		ProductoDAO dao = ProductoDAO.getInstance();
		
		ArrayList<Producto> productos = dao.getAll();
		
		System.out.println("Listado de productos");
		System.out.println("--------------------------------------");
		
		for (Producto p : productos) {
			System.out.println(p);
		}
		
		
				

	}

}
