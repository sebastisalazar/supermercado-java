package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class EliminarAlumnosController
 */
@WebServlet("/eliminar-usu")
public class EliminarUsuariosController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recogemos los parametros de los campos del formulario
		String ids= request.getParameter("id");
		int id= Integer.parseInt(ids);
		
		//iniciliacion de crud
		UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
		
		//inciliacion para guardas los mensajes de la respuesta
		Alerta alerta= new Alerta();
		
		//delete y creacion de alerta con mensajes
		try {
		
			dao.delete(id);
			alerta = new Alerta( "success", "Usuario eliminado con exito");

		} catch (Exception e) {
			alerta = new Alerta( "danger", "Error, no se ha podido borrar el usuario. "+e.getMessage());
			e.printStackTrace();
		}finally {
			//iniciliacion para guardar la respuesta
			ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
			try {
				usuarios = dao.getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//se pasan los mensajes de la respuesta y el estado de la lista actual despues del update a la vista
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("alerta", alerta);
			
			//se redirecciona
			request.getRequestDispatcher("lista-usuarios.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
