package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;

public class BuscarProductosPorNombre {
	static Scanner sc = new Scanner(System.in);
	static String sql = "SELECT id, nombre FROM producto WHERE nombre LIKE ? ;";
	static String nombre;
	static boolean encontrado = true;

	public static void main(String[] args) {
		BuscarPRoductos();
	}

	public static void BuscarPRoductos() {
		try {
			Connection conexion = ConnectionManager.getConnection();

			do {
				System.out.print("Introduce el nombre a buscar: ");
				nombre = sc.nextLine();

				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, "%" + nombre + "%");

				try (ResultSet rs = pst.executeQuery();) {

					// Mostrando resultados

					while (rs.next()) {
						Producto producto = new Producto();
						producto.setId(rs.getInt("id"));
						producto.setNombre(rs.getString("nombre"));

						System.out.println("\n" + producto);
						encontrado = false;
					}

					if (rs.last() == false) {
						System.out.println("\nNo se han encontrado resultados para " + nombre + " \n");

					}

				}
			} while (encontrado);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
