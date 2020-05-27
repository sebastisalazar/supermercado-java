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
@WebServlet("/eliminar-usuario")
public class EliminarUsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje="";
		ArrayList<Usuario> alumnos= new ArrayList<>();
		try {
			String ids= request.getParameter("id");
			int id= Integer.parseInt(ids);
			UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
			dao.delete(id);
			
			
			alumnos=dao.getAll();
			
			
			mensaje="Usuario borrado correctamente";
			
			
			
		} catch (Exception e) {
			mensaje="Error, no se ha podido eliminar el usuario. "+e.getMessage();
			e.printStackTrace();
		}
		request.setAttribute("alumnos", alumnos);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("tabla-usuarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
