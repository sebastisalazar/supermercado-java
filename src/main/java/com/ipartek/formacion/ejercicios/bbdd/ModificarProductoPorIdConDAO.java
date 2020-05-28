package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImp;

public class ModificarProductoPorIdConDAO {

	public static void main(String[] args) {
	
		try {
			Scanner sc = new Scanner(System.in);
			ProductoDAOImp dao = ProductoDAOImp.getInstance();
			Producto p= new Producto();
			
			ListaProductos.listarProductos();
			
			System.out.print("\nDime el id a modificar:");
			int id= Integer.parseInt(sc.nextLine());
			System.out.print("\nDime el nuevo nombre del producto: ");
			String nuevonombre=sc.nextLine();
			p=dao.getById(id);
			
			System.out.print("\nEl producto: "+p.getNombre()+" con id "+p.getId()+" se ha modificado su nombre a -> "+nuevonombre);
			p.setId(id);
			p.setNombre(nuevonombre);
			p=dao.update(p);
			
			
			//ListaProductos.listarProductos();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
				

	}
	
}
