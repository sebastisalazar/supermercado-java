package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

/**
 * Servlet implementation class CrearProductoController
 */
@WebServlet("/crear-producto")
public class CrearProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//para conseguir los datos de la base de datos
		  ProductoDAO dao= ProductoDAO.getInstance();
		  Producto p= new Producto();
		  String nombre=request.getParameter("nombre");
		  p.setNombre(nombre);
		  String mensaje="";
		  
		  try {
			dao.insert(p);
			mensaje="Producto registrado correctamente";
		} catch (Exception e) {
			mensaje="Error, se ha producito un error. "+e.getMessage();
			e.printStackTrace();
		}
		  
		  request.setAttribute("mensaje", mensaje);
		  request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);
		  
		 
		
	}

}
