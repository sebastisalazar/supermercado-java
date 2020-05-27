package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

/**
 * Servlet implementation class EliminarProductoController
 */
@WebServlet("/eliminar-prod")
public class EliminarProductoController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		int id=Integer.parseInt(ids);
		
		ProductoDAO dao= ProductoDAO.getInstance();
		Producto p= new Producto();
		
		String mensaje="";
		try {
			p=dao.delete(id);
			mensaje= "Producto borrado con exito";
		} catch (Exception e) {
			mensaje="Error, no se ha podido borrar el producto. "+e.getMessage();
			e.printStackTrace();
		}
		ArrayList<Producto> productos=dao.getAll();
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("productos", productos);
		
		
		request.getRequestDispatcher("tabla-producto.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
