package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

public class BuscarProductosPorIDConDAO {
	
	
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			ProductoDAO dao = ProductoDAO.getInstance();
			System.out.println("Dime el id a buscar:");
			int id = Integer.parseInt(sc.nextLine());
			Producto p=new Producto();
			p=dao.getById(id);
			System.out.println(p);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		

	}// main

 
}
