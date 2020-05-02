package com.ipartek.formacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;

public class BuscarProductosPorNombre {
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String sql = "SELECT id, nombre FROM producto WHERE nombre LIKE ? ;";
		String nombre;
		
		try {
			Connection conexion= ConnectionManager.getConnection();
			
			System.out.println("Introduce el nombre a buscar: ");
			nombre=sc.nextLine();
			
			PreparedStatement pst= conexion.prepareStatement(sql);
			pst.setString( 1, "%" + nombre + "%");
			 
			try(ResultSet rs=pst.executeQuery();) {
				
				//Mostrando resultados
				System.out.println("");
				while (rs.next()) {
					Producto producto = new Producto();
					producto.setId(rs.getInt("id"));
					producto.setNombre(rs.getString("nombre"));
					
					System.out.println(producto);
					
				}
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
 
}
