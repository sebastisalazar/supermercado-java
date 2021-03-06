package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImp;

public class BuscarProductosPorNombreConDAO {
	
	
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			ProductoDAOImp dao = ProductoDAOImp.getInstance();
			System.out.print("Dime nombre a buscar:");
			String nombreAbuscar = sc.nextLine();
			ArrayList<Producto> productos = dao.getAllByNombre(nombreAbuscar);
			
			System.out.println("Producto/s encontrados con el nombre "+nombreAbuscar+":\n");
			for (Producto p : productos) {
				System.out.println(p);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		

	}// main

 
}
