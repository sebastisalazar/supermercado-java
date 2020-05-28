package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImp;

/**
 * Servlet implementation class ProductosConrtoller
 */
@WebServlet("/lista-productos")
public class ProductosController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//para conseguir los datos de la base de datos
		ProductoDAOImp p= ProductoDAOImp.getInstance();
		ArrayList<Producto> productos= p.getAll();
		
		//datos para enviar a la vista
		request.setAttribute("productos", productos);
		
		//ir a la nueva vista o jsp
		request.getRequestDispatcher("tabla-producto.jsp").forward(request, response);
	}

}
