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
 * Servlet implementation class TablaAlumnoController
 */
@WebServlet("/ver-tabla-alumnos")
public class TablaAlumnoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// conseguir los alumnos de la bbdd
		
		UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();		
		ArrayList<Usuario> alumnos=null;
		try {
			alumnos = dao.getAll();
			// enviar la informacion a la vista		
			request.setAttribute( "alumnos" , alumnos );
			
			// ir a la nueva vista o jsp
			request.getRequestDispatcher("tabla-alumnos.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
