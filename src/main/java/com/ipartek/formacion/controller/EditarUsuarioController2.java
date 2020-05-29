package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.ProductoDAOImp;
import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class EditarUsuarioController
 */
@WebServlet("/editar-usu")
public class EditarUsuarioController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recogemos el id pasado por parametro
		int id= Integer.parseInt(request.getParameter("id"));
		
		//Inicializacion para operar contra bbdd
		UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
		
		//Inicilizacion de usario
		Usuario usuario= new Usuario();
		
		//ejecucion del select by id 
		try {
			usuario= dao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("usuario",usuario);
			request.getRequestDispatcher("editarUsuario2.jsp").forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//iniciliacion para guardas mensajes de alerta
		Alerta alerta = new Alerta();
		
		//Usuario vacio que se asignara los campos del formulario
		Usuario u= new Usuario();
		
		//Guarda el value de los campos del formulario
		String nombre;
		String contrasenia;
		int id_rol;
		
		//Iniciliacion para operar contra la bbdd
		UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
		
		
		//comprobaciones de campos en blanco
		 
	  	//campo nombre
		 if (("").equalsIgnoreCase(request.getParameter("nombre"))==true) {
			nombre="-";
		 }else{
			nombre=request.getParameter("nombre");
		 }//fin if
		 
		//campo contraseña
		 if (("").equalsIgnoreCase(request.getParameter("contrasenia"))==true) {
			contrasenia="12345";
		 }else{
			contrasenia=request.getParameter("contrasenia");
		 }//fin if
		 
		 //campo id_rol
		 if (("").equalsIgnoreCase(request.getParameter("id_rol"))==true) {
			id_rol=1;
		 }else{
			id_rol=Integer.parseInt(request.getParameter("id_rol"));
		 }//fin if
		 
		 //asercion de datos despues de comprobaciones
		 u.setId(Integer.parseInt(request.getParameter("id")));
		 u.setNombre(nombre);
		 u.setContrasenia(contrasenia);
		 u.setId_rol(id_rol);
		
		 //ejecucion update y creacion de mensajes de alerta
		try {
			
			u=dao.update(u);
			alerta = new Alerta( "success", "Usuario actualizado con exito");
		} catch (Exception e) {
			alerta = new Alerta( "danger", "Error, el usario no se ha podido editar. " + e.getMessage());
			e.printStackTrace();
		}finally {
			
			//obtiene el estado de la lista des 
			ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
			try {
				usuarios = dao.getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}//fin try catch
			
			//Se pasa los mensajes de alerta y el estado de la lista despues del update
			request.setAttribute("alerta",alerta);
			request.setAttribute("usuarios",usuarios);
			
			//se redirecciona
			request.getRequestDispatcher("lista-usuarios.jsp").forward(request, response);
			
		}//fin try catch
		
		
		
		
		
	}//fin DOPOST

}//FIN CLASE
