package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImp;

public class BuscarProductosPorIDConDAO {
	
	
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			ProductoDAOImp dao = ProductoDAOImp.getInstance();
			System.out.print("Dime el id a buscar:");
			int id = Integer.parseInt(sc.nextLine());
			Producto p=new Producto();
			p=dao.getById(id);
			System.out.println("\nProducto encontrado, nombre= "+p.getNombre()+" id= "+p.getId());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		

	}// main

 
}
