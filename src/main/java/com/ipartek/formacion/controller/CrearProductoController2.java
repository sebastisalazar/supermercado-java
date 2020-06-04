package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImp;

/**
 * Servlet implementation class CrearProductoController
 */
@WebServlet("/crear-prod")
public class CrearProductoController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtiene la sesion creada por el navegador
		HttpSession session = request.getSession();
		
		if(session.getAttribute("usuario_logeado")==null) {
			
			Alerta alerta= new Alerta("warning","Vista sólo disponible para usuarios logeados.");
			request.setAttribute("alerta", alerta);
			// ir a la nueva vista o jsp
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("formulario-producto2.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Conseguir los datos de la base de datos
		  Alerta alerta= new Alerta();
		  ProductoDAOImp dao= ProductoDAOImp.getInstance();
		  Producto p= new Producto();
		  String nombre;
		  Float precio;
		  String foto;
		  
		  
		  	//comprobaciones de campos en blanco
		 
		  	//campo nombre
			 if (("").equalsIgnoreCase(request.getParameter("nombre"))==true) {
				nombre="-";
			 }else{
				nombre=request.getParameter("nombre");
			 }
			 
			//campo foto
			 if (("").equalsIgnoreCase(request.getParameter("foto"))==true) {
				foto="https://picsum.photos/75/75";
			 }else{
				foto=request.getParameter("foto");
			 }
			 
			//campo precio
			 if (("").equalsIgnoreCase(request.getParameter("precio"))==true) {
				precio=0f;
			 }else{
				precio= Float.parseFloat(request.getParameter("precio"));	
			 }
		  
		
		  // asercion de los datos en campo al objeto
			 
		  p.setNombre(nombre);
		  p.setFoto(foto);
		  p.setPrecio(precio);
		  
		 
		//insert
		try {
			dao.insert(p);
			alerta = new Alerta( "success", "Producto creado con exito");
		} catch (Exception e) {
			alerta = new Alerta( "danger", "Error, no se ha podido crear. "+e.getMessage());
		}
		  //Respuesta
		  request.setAttribute("alerta", alerta);
		  //redireccionamiento
		  request.getRequestDispatcher("formulario-producto2.jsp").forward(request, response);
		  
		 
		
	}

}
