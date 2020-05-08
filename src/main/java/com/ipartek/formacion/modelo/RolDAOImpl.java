package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.hibernate.validator.internal.util.IgnoreJava6Requirement;

public class RolDAOImpl implements CrudAble<Rol> {

	private static RolDAOImpl INSTANCE = null;

	private RolDAOImpl() {
		super();
	}

	public static synchronized RolDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RolDAOImpl();
		}

		return INSTANCE;
	}

	private final String SQL_GETALL = "SELECT id,nombre FROM rol";
	private final String SQL_GETBYID = "SELECT id,nombre FROM rol WHERE id=?";
	private final String SQL_DELETEBYID = "DELETE FROM rol WHERE id=?";
	private final String SQL_INSERT ="INSERT INTO rol (nombre) VALUES(?)";
	private final String SQL_UPDATE= "UPDATE rol SET nombre=? WHERE id=?";
	private final String SQL_GETBYNAME= "SELECT id,nombre FROM rol WHERE nombre LIKE ?";

	/**
	 * @return Array List de todos los usuarios en la base de datos
	 * @throws Mensaje de la excepcion
	 */
	@Override
	public ArrayList<Rol> getAll() throws Exception {

		ArrayList<Rol> registros = new ArrayList<Rol>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				Rol r = new Rol();
				r.setId(rs.getInt("id"));
				r.setNombre(rs.getString("nombre"));
				registros.add(r);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return registros;

	}

	/**
	 * @param Recibe el ID a buscar
	 * @return Objeto de tipo usuario cuyo id es igual al que recibe por parametro
	 * @throws Mensaje en caso de no existir ningun registro con el id recibido por parametro 
	 */
	@Override
	public Rol getById(int id) throws Exception {

		Rol r = new Rol();

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GETBYID);

		) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					r.setId(rs.getInt("id"));
					r.setNombre(rs.getString("nombre"));

				}

				// si no encuentra registros lanza el siguiente mensaje
				if (rs.last() == false) {
					throw new Exception("\nLo sentimos no existen registros con el ID " + id+"\n");
				}
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return r;
	}

	/**
	 * @param Recibe el ID a borrar
	 * @return Objeto de tipo usuario cuyo ID es el mismo que recibe por parametro
	 * @throws Mensaje cuando no existe un usuario con el ID recibido por parametro
	 */
	@Override
	public Rol delete(int id) throws Exception {
		Rol r= new Rol();
		try (
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst= con.prepareStatement(SQL_DELETEBYID);
		){
			pst.setInt(1, id);
			r= getById(id);
			
			int filaborrada=pst.executeUpdate();
			
			if (filaborrada==2) {
				throw new Exception("\nNo se ha encontrado ningun usuario con ID "+id+"\n");
			}
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return r;
	}

	/**
	 * @param Recibe un Objeto de tipo Usuario inicializado con sus atributos
	 * @return Objeto de tipo Usuario pero esta vez indicando el ID que se le ha asignado en la base de datos
	 * @throws Mensaje cuando un usuario con el mismo nombre ya exista en la base de datos
	 */
	@Override
	public Rol insert(Rol pojo) throws Exception {
		try(
			Connection con= ConnectionManager.getConnection();
			PreparedStatement pst=con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);	
		
		){
			pst.setString(1, pojo.getNombre());
			try{
				int filaInsertada= pst.executeUpdate();
				if (filaInsertada==1) {
					try(ResultSet rs=pst.getGeneratedKeys();){
						if (rs.next()) {
							int generatedKey= rs.getInt(1);
							pojo.setId(generatedKey);
						}
						
					}
				}
			}catch (Exception duplicatedQException) {
				throw new Exception("\nYa existe un usuario con el NOMBRE "+pojo.getNombre()+"\n");
			}
				
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return pojo;
	}

	/**
	 * @param Recibe un Objeto de tipo Usuario inicializado con sus atributos
	 * @return Objeto de tipo Usuario indicando el los datos antes que se han actualizado en la base de datos
	 * @throws Mensaje cuando el id del objeto recibido por parametro no exista en la base de datos
	 */
	public Rol update(Rol pojo) throws Exception {
		
		Rol u= getById(pojo.getId());
		try(
			Connection con= ConnectionManager.getConnection();
			PreparedStatement pst= con.prepareStatement(SQL_UPDATE);
		){
			
			pst.setString(1,pojo.getNombre());
			pst.setInt(2, pojo.getId());
			int filaActualizada=pst.executeUpdate();
			
			if (filaActualizada==2) {
				throw new Exception("\nLo sentimos, no existen registros con el ID "+ pojo.getId()+"\n");
			}
				
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return u;
	}

	/**
	 * @param Recibe como parametro el nombre a buscar en la base de datos
	 * @return Arraylist con Objeto/s cuyo nombre coincidan con el nombre recibido por parametro
	 * @throws Mensaje en caso que no existiera ningun registro con el nombre recibido por parametro
	 */
	public ArrayList<Rol> getAllByNombre(String palabraBuscada) throws Exception {
		
		
		ArrayList<Rol> registroNombres= new ArrayList<Rol>();
		
			try (
					Connection con = ConnectionManager.getConnection();
					PreparedStatement pst = con.prepareStatement(SQL_GETBYNAME);

			) {
				
				pst.setString(1,"%"+palabraBuscada+"%");
				try (ResultSet rs = pst.executeQuery()) {

					while (rs.next()) {
						Rol u = new Rol();
						u.setId(rs.getInt("id"));
						u.setNombre(rs.getString("nombre"));
						registroNombres.add(u);

					}
					
					if (rs.last()==false) {
						throw new Exception("\nLo sentimos, no se han encontrado usuarios con el NOMBRE \""+palabraBuscada+"\""+"\n");
					}

				}

			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		
	
		return registroNombres;
	}



}
