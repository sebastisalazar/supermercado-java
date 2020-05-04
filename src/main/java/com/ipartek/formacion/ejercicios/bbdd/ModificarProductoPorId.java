package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;

public class ModificarProductoPorId {
	static final String SQL = "UPDATE supermercado.producto SET nombre =? WHERE nombre LIKE ? AND id =?;";
	static int id;
	static String nombre;
	static String nuevoNombre;

	public static void main(String[] args) {
		ListaProductos.listarProductos();
		modificarProducto();
	}

	public static void modificarProducto() {

		boolean seguir = true;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL);
				Scanner sc = new Scanner(System.in);

		) {

			do {
				System.out.print("\nEscribe el nombre del producto: ");
				nombre = sc.nextLine();
				System.out.print("\nEscribe el id del producto: ");
				id = Integer.parseInt(sc.nextLine());
				System.out.print("\nEscribe el nuevo nombre del producto: ");
				nuevoNombre = sc.nextLine();
				pst.setString(1, nuevoNombre);
				pst.setInt(3, id);
				pst.setString(2, nombre);

				int beenupdated = pst.executeUpdate();

				if (beenupdated == 1) {
					System.out.println("El producto " + nombre + " con id=" + id
							+ " ha sido modificado correctamente a " + nuevoNombre);

					ListaProductos.listarProductos();
					seguir = false;
				} else {
					System.out.println("El producto " + nombre + " con id=0" + id + "no ha sido encontrado. ");
				}
			} while (seguir);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// preguntar el ID del que quiere eliminar y el nombre

}
