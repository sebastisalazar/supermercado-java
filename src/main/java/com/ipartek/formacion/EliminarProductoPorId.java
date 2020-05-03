package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;

public class EliminarProductoPorId {
	static final String SQL = "DELETE FROM producto WHERE id=?";
	static int id;

	public static void main(String[] args) {
		ListaProductos.listarProductos();
		borrarProducto();

	}

	public static void borrarProducto() {
		boolean seguir = true;

		try (

				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL);
				Scanner sc = new Scanner(System.in);

		) {

			do {
				System.out.print("\nindica el id del producto a borrar: ");
				id = Integer.parseInt(sc.nextLine());

				pst.setInt(1, id);
				int filaborrada = pst.executeUpdate();

				if (filaborrada == 1) {
					seguir = false;
					System.out.println("\nEl producto ha sido borrado con exito");
					ListaProductos.listarProductos();
				} else {
					System.out.println("error, id no encontrado");
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

}
