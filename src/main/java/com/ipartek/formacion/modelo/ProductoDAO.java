package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAO implements CrudAble<Producto> {
	
	private static ProductoDAO INSTANCE = null;
	
	private ProductoDAO() {
		super();	
	}
	
	public static synchronized ProductoDAO getInstance() {
		
		if ( INSTANCE == null ) {
			INSTANCE = new ProductoDAO();
		}
		
		return INSTANCE;
	}
	

	private final String SQL_GET_ALL = " SELECT id, nombre FROM producto ORDER BY id DESC; ";
	//TODO resto de SQLs
	
	public ArrayList<Producto> getAllByNombre( String nombre ) {
		//SQL a ejecutar
				String SQL = "SELECT id, nombre FROM producto WHERE nombre LIKE '%"+nombre+"%';";
				//array list que se devolvera
				ArrayList<Producto> registrosPorNombre = new ArrayList<Producto>();
				
				//control de recursos
				try (
						Connection conexion = ConnectionManager.getConnection();
						PreparedStatement pst = conexion.prepareStatement(SQL);

				) {
					
					try( ResultSet rs = pst.executeQuery() ){
						
						// consultar 1 a 1 los resultados, hasta que no existan mas registros
						while (rs.next()) {
			
							int id = rs.getInt("id");
							String nombrep = rs.getString("nombre");
							Producto p = new Producto(nombrep);
							p.setId(id);
							registrosPorNombre.add(p);
			
						} // while
					}	

				

				} catch (Exception e) {
					
					e.printStackTrace();

				}
				
				return registrosPorNombre;
	}
	
	@Override
	public ArrayList<Producto> getAll() {
		
		ArrayList<Producto> registros = new ArrayList<Producto>();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();
				
			) {
			
			while ( rs.next() ) {
				
				int id        = rs.getInt("id");
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

	@Override
	public Producto getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto insert(Producto pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto update(Producto pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
