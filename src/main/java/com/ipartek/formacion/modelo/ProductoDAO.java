package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface ProductoDAO extends CrudAble<Usuario> {
	
	ArrayList<Producto> getAllByNombre( String palabraBuscada ) throws Exception;
}
