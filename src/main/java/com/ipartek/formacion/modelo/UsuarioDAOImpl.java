package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.validator.internal.util.IgnoreJava6Requirement;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static UsuarioDAOImpl INSTANCE = null;

	private UsuarioDAOImpl() {
		super();
	}

	public static synchronized UsuarioDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOImpl();
		}

		return INSTANCE;
	}

	
	
	
	private final String SQL_GETALL     = "SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol' FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id ORDER BY u.id DESC; ";
	private final String SQL_GETBYID    = "SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol' FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id WHERE u.id = ? ; ";
	private final String SQL_EXISTE     = "SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol' FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id WHERE u.nombre = ? AND contrasenia = ? ; ";
	private final String SQL_GETBYNAME  = "SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol' FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id WHERE nombre LIKE ? ;";
	
	
	private final String SQL_DELETEBYID = "DELETE FROM usuario WHERE id=?";
	private final String SQL_INSERT ="INSERT INTO usuario (nombre, contrasenia, id_rol) VALUES(?,?,1)";
	private final String SQL_UPDATE= "UPDATE usuario SET nombre=?, contrasenia=?, id_rol=? WHERE id=?";
	
	

	/**
	 * @return Array List de todos los usuarios en la base de datos
	 * @throws Mensaje de la excepcion
	 */
	@Override
	public ArrayList<Usuario> getAll() throws Exception {

		//Arraylist vacio para guardar todos los usuarios
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery();
		) {

			while (rs.next()) {
				
				usuarios.add( mapper(rs) );

			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return usuarios;

	}

	/**
	 * @param Recibe el ID a buscar
	 * @return Objeto de tipo usuario cuyo id es igual al que recibe por parametro
	 * @throws Mensaje en caso de no existir ningun registro con el id recibido por parametro 
	 */
	@Override
	public Usuario getById(int id) throws Exception {

		//Iniciliazacion de usuario vacio
		Usuario usuario = new Usuario();

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GETBYID);

		) {
			//se especifica el usuario con id que queremos
			pst.setInt(1, id);
			
			//Ejecucion del select
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					usuario = mapper(rs);

				}

				// si no encuentra registros lanza el siguiente mensaje
				if (rs.last() == false) {
					throw new Exception("\nLo sentimos no existen registros con el ID " + id+"\n");
				}
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return usuario;
	}

	/**
	 * @param Recibe el ID a borrar
	 * @return Objeto de tipo usuario cuyo ID es el mismo que recibe por parametro
	 * @throws Mensaje cuando no existe un usuario con el ID recibido por parametro
	 */
	@Override
	public Usuario delete(int id) throws Exception {
		Usuario u= new Usuario();
		try (
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst= con.prepareStatement(SQL_DELETEBYID);
		){
			pst.setInt(1, id);
			u= getById(id);
			
			int filaborrada=pst.executeUpdate();
			
			if (filaborrada==2) {
				throw new Exception("\nNo se ha encontrado ningun usuario con ID "+id+"\n");
			}
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return u;
	}

	/**
	 * @param Recibe un Objeto de tipo Usuario inicializado con sus atributos
	 * @return Objeto de tipo Usuario pero esta vez indicando el ID que se le ha asignado en la base de datos
	 * @throws Mensaje cuando un usuario con el mismo nombre ya exista en la base de datos
	 */
	@Override
	public Usuario insert(Usuario pojo) throws Exception {
		try(
			Connection con= ConnectionManager.getConnection();
			PreparedStatement pst=con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);	
		
		){
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenia());
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
				throw new Exception("\nLo sentimos, el usuario "+pojo.getNombre()+"\n ya está registrado");
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
	public Usuario update(Usuario pojo) throws Exception {
		
		
		Usuario u= getById(pojo.getId());
		
			
			try(
				Connection con= ConnectionManager.getConnection();
					
				
				PreparedStatement pst= con.prepareStatement(SQL_UPDATE);
			){
				
				pst.setString(1, pojo.getNombre());
				pst.setString(2, pojo.getContrasenia());
				pst.setInt(3, pojo.getId_rol().getId());
				pst.setInt(4, pojo.getId());
				
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
	public ArrayList<Usuario> getAllByNombre(String palabraBuscada) throws Exception {
		
		
		ArrayList<Usuario> registroNombres= new ArrayList<Usuario>();
		
			try (
					Connection con = ConnectionManager.getConnection();
					PreparedStatement pst = con.prepareStatement(SQL_GETBYNAME);

			) {
				
				pst.setString(1,"%"+palabraBuscada+"%");
				try (ResultSet rs = pst.executeQuery()) {

					while (rs.next()) {
						Usuario u = new Usuario();
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

	
	
	/**
	 * @param Recibe el nombre del usuario y el password a buscar
	 * @return Objeto de tipo usuario cuyo nombre y contraseña es igual al que recibe por parametro
	 * @throws Mensaje en caso de no existir ningun registro con el nombre y password recibido por parametro 
	 */
	@Override
	public Usuario getExiste(String nombre, String password) throws Exception {

		//Iniciliazacion de usuario vacio
		Usuario usuario = null;

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_EXISTE);

		) {
			//se especifica el usuario con nombre y el password que queremos
			pst.setString(1,nombre);
			pst.setString(2,password);
			
			//Ejecucion del select
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					usuario = mapper(rs);

				}

				// si no encuentra registros lanza el siguiente mensaje
				if (rs.last() == false) {
					throw new Exception("\nLo sentimos no existe usuario con el nombre " + nombre+ " y contrasenia "+password+"\n");
				}
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return usuario;
	}
	
	
	private Usuario mapper( ResultSet rs ) throws SQLException {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(rs.getInt("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setContrasenia( rs.getString("contrasenia"));
		
		//rol
		Rol rol = new Rol();
		rol.setId(rs.getInt("id_rol"));
		rol.setNombre(rs.getString("nombre_rol"));
		
		// setear el rol al usuario
		usuario.setId_rol(rol);
		
		return usuario;
		
	}
}
