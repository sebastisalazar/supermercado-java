package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImp;

/**
 * Servlet implementation class EditarProductoController
 */
@WebServlet("/editar-producto")
public class EditarProductoController extends HttpServlet {
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
		String idString= request.getParameter("id");
		String nombre= request.getParameter("nombrenuevo");
		int id= Integer.parseInt(idString);
		
		Producto p= new Producto();
		p.setId(id);
		p.setNombre(nombre);
		
		String mensaje="";
		
		ProductoDAOImp dao= ProductoDAOImp.getInstance();
		try {
			dao.update(p);
			mensaje="Producto editado satisfactoriamente.";
		} catch (Exception e) {
			mensaje="Error, el producto no se ha podido editar. "+e.getMessage();
			e.printStackTrace();
		}
		
		ArrayList<Producto> productos= dao.getAll();
		request.setAttribute("productos", productos);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}

}
