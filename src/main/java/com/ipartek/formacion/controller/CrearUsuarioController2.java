package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImp;
import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class CrearUsuarioController
 */
@WebServlet("/crear-usu")
public class CrearUsuarioController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuarioController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
		String mensaje="";
		try {
			String nombre= request.getParameter("nombre");
			Usuario u= new Usuario();
			u.setNombre(nombre);
			u=dao.insert(u);
			mensaje="Usuario creado satisfactoriamente";
		} catch (Exception e) {
			mensaje="Error, no se ha podido crear. "+e.getMessage();
			e.printStackTrace();
		}
		
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("formulario-usuario2.jsp").forward(request, response);
		
	}

}
