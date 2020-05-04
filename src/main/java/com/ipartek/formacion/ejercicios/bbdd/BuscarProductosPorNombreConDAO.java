package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

public class BuscarProductosPorNombreConDAO {
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ProductoDAO dao = ProductoDAO.getInstance();
		System.out.println("Dime nombre a buscar:");
		String nombreAbuscar = sc.nextLine();
		ArrayList<Producto> productos = dao.getAllByNombre(nombreAbuscar);
		
		for (Producto p : productos) {
			System.out.println(p);
		}
		
		
		
		

	}// main

 
}
