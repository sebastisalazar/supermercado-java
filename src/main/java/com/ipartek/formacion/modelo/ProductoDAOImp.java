/**
 * @author Sebastian Salazar
 * @see https://github.com/sebastisalazar/supermercado-java/tree/master/src/main/java/com/ipartek/formacion/ejercicios/bbdd
 * @see https://github.com/sebastisalazar/supermercado-java/blob/master/src/main/java/com/ipartek/formacion/modelo/ProductoDAO.java
 */

package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductoDAOImp implements CrudAble<Producto> {

	private static ProductoDAOImp INSTANCE = null;

	private ProductoDAOImp() {
		super();
	}

	public static synchronized ProductoDAOImp getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ProductoDAOImp();
		}

		return INSTANCE;
	}

	private final String SQL_GET_ALL = " SELECT id, nombre FROM producto ORDER BY id DESC; ";
	private final String SQL_INSERT = "INSERT INTO producto(nombre, id_usuario) VALUES(?,1)";
	private final String SQL_SELECTBYBOMBRE = "SELECT id, nombre FROM supermercado.producto WHERE nombre LIKE ?;";
	private final String SQL_SELECTBYID = "SELECT id, nombre FROM supermercado.producto WHERE id=?;";
	private final String SQL_DELETE = "DELETE FROM producto WHERE id=?";
	private final String SQL_UPDATE = "UPDATE supermercado.producto SET nombre=? WHERE id=?";

	/**
	 * 
	 * @param Recibe el parametro Nombre que es el que se va a buscar en la base de
	 *               datos
	 * @return Array list pudiendo contener uno o varios registros acorde al nombre
	 *         pasado por parametro
	 * @throws Mensaje de excepcion si no encuentra ningun registro con el parametro
	 *                 recibido(nombre)
	 */
	public ArrayList<Producto> getAllByNombre(String nombre) throws Exception {

		ArrayList<Producto> registrosPorNombre = new ArrayList<Producto>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_SELECTBYBOMBRE);

		) {
			pst.setString(1, "%" + nombre + "%");

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					Producto p = new Producto();
					int id = rs.getInt("id");
					String nombrep = rs.getString("nombre");
					p.setNombre(nombrep);
					p.setId(id);
					registrosPorNombre.add(p);

				}

				/**
				 * si la SQL está bien pero no encuuentra ningun registro
				 */
				if (rs.last() == false) {
					throw new Exception("No se han encontrado registros con el nombre " + nombre);
				}
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return registrosPorNombre;
	}

	/**
	 * @return Array list conteniendo todos los registros actuales en la base de
	 *         datos
	 */
	@Override
	public ArrayList<Producto> getAll() {

		ArrayList<Producto> registros = new ArrayList<Producto>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();

		) {

			while (rs.next()) {

				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				Producto p = new Producto(nombre);
				p.setId(id);

				// guardar en lista
				registros.add(p);

			} // while

		} catch (Exception e) {

			e.printStackTrace();

		}

		return registros;
	}

	/**
	 * @param Recibe por parametro el ID, el cual se buscará en la base de datos
	 * @return Objeto cuyo ID coincida con el pasasado por parametro
	 * @throws Mensaje de excepcion si no se encuentran registros con el id indicado
	 */
	public Producto getById(int id) throws Exception {

		Producto p = new Producto();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_SELECTBYID);

		) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));

				}

				// si no existe el id
				if (rs.last() == false) {
					throw new Exception("No se han encontrado registros con el id " + id);
				}

			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}

		return p;
	}

	/**
	 * @param Recibe por parametro el ID, que se buscara en la base de datos para
	 *               borrar
	 * @return Objeto producto con sus atributos id y nombre para hacer saber qué
	 *         registro se ha borrado
	 * @throws Mensaje en caso de que el id indicado a buscar no exista en la base
	 *                 de datos
	 */
	public Producto delete(int id) throws Exception {

		Producto p = getById(id);
		try (

				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				Scanner sc = new Scanner(System.in);

		) {
			pst.setInt(1, p.getId());
			int filaborrada = pst.executeUpdate();

			if (filaborrada == 2) {
				throw new Exception("No se ha encontrado el producto con id " + id);
			}
		} catch (Exception e) {

			e.getMessage();
		}

		return p;

	}

	/**
	 * @param Recibe por parametro un Objeto de tipo Producto inicializado con sus
	 *               atributos
	 * @return Objeto de tipo producto con el id introducido en base de datos
	 * @throws Mensaje de excepcion en caso de que ya exista un producto con ese
	 *                 nombre
	 */
	public Producto insert(Producto pojo) throws Exception {

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT,
						PreparedStatement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, pojo.getNombre());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {

				try (ResultSet rs = pst.getGeneratedKeys();) {
					if (rs.next()) {
						int id = rs.getInt(1);
						pojo.setId(id);
					}
				}

			}

		} catch (Exception e) {
			throw new Exception("Error, el producto " + pojo.getNombre() + " ya existe");

		}
		return pojo;
	}

	/**
	 * @param Recibe por parametro un Objeto de tipo producto inicializado con sus
	 *               atributos
	 * @return Objeto de tipo producto para saber/indicar que nombre tenía
	 *         anteriormente ese producto
	 * @throws Mensaje de Excepcion en caso que el el objeto indicado por parametro
	 *                 no exista en la base de datos
	 */
	public Producto update(Producto pojo) throws Exception {

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
				Scanner sc = new Scanner(System.in);

		) {

			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getId());

			int beenUpdated = pst.executeUpdate();

			// si no ha actualizado nada porque no existe el id
			if (beenUpdated == 2) {

				throw new Exception("El producto" + pojo.getNombre() + " con id " + pojo.getId()
						+ " No existe en la base de datos");
			}

		}

		return pojo;
	}

}
