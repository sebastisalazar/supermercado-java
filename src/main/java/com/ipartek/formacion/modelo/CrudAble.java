package com.ipartek.formacion.modelo;

import java.util.ArrayList;

/**
 * Vamos a definir la operaciones Básicas de CRUD
 * P es una clase GENERICA se diferencia porque siempre un una LETRA MAYUSCULA
 * Esa P luego podemos sustituirla por cualquier Clase
 * @author javaee
 *
 */
public interface CrudAble<P> {

	
	ArrayList<P> getAll();
	
	P getById(int id) throws Exception;
	
	P delete(int id)  throws Exception;
	
	P insert( P pojo )  throws Exception;
	
	P update ( P pojo )  throws Exception;
	
}
