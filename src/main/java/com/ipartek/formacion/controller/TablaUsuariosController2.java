package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class TablaAlumnosController
 */
@WebServlet("/lista-usuarios")
public class TablaUsuariosController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		//obtiene la sesion creada por el navegador
		HttpSession session = request.getSession();
		
		//si no existe ssesion con logeo
		if(session.getAttribute("usuario_logeado")==null) {
			
			Alerta alerta= new Alerta("warning","Vista sólo disponible para usuarios logeados.");
			
			//pasa la alerta a la vista
			session.setAttribute("alerta", alerta);
			
			// redireccion a login
			response.sendRedirect("login.jsp");
		}else{
			doPost(request, response);
		}
		
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtiene la sesion creada por el navegador
				HttpSession session = request.getSession();
		
		// conseguir los alumnos de la bbdd
		
				UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();		
				ArrayList<Usuario> usuarios=null;
				try {
					usuarios = dao.getAll();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// enviar la informacion a la vista		
				session.setAttribute("usuarios", usuarios );
				
				//se redirecciona otra vez al panel de administrador
				response.sendRedirect("lista-usuarios.jsp");
				
	}

}
