package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

public class EliminarProductoPorIdConDAO {

	public static void main(String[] args) {

		try {
			ListaProductos.listarProductos();
			Scanner sc = new Scanner(System.in);
			ProductoDAO dao = ProductoDAO.getInstance();
			Producto p= new Producto();
			
			System.out.print("\nDime el id a borrar:");
			int id=Integer.parseInt(sc.nextLine());
			p=dao.delete(id);
			
			System.out.print("\nEl producto:"+p.getNombre()+" con id "+p.getId()+" se ha borrado con exito");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
			
		

	}// main

}
