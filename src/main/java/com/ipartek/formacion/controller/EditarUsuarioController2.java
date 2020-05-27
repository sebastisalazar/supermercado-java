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
 * Servlet implementation class EditarUsuarioController
 */
@WebServlet("/editar-usu")
public class EditarUsuarioController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevoNombre=request.getParameter("nombrenuevo");
		String ids= request.getParameter("id");
		int id= Integer.parseInt(ids);
		
		Usuario u= new Usuario();
		u.setNombre(nuevoNombre);
		u.setId(id);
		
		UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		
		String mensaje="";
		
		try {
			
			u=dao.update(u);
			usuarios=dao.getAll();
			mensaje="Usuario actualizado correctamente";
		} catch (Exception e) {
			mensaje="Error, no se ha podido actualizar el usuario. "+e.getMessage();
			e.printStackTrace();
		}
		
		
		
		request.setAttribute("mensaje",mensaje);
		request.setAttribute("usuarios",usuarios);
		request.getRequestDispatcher("lista-usuarios.jsp").forward(request, response);
	}

}
