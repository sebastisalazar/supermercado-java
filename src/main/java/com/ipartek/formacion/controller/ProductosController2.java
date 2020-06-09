package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImp;

/**
 * Servlet implementation class ProductosConrtoller
 */
@WebServlet("/lista-productos")
public class ProductosController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//obtiene la sesion creada por el navegador
    			HttpSession session = request.getSession();
    			
    			//si no existe ssesion con logeo
    			if(session.getAttribute("usuario_logeado")==null) {
    				
    				//crea mensaje 
    				Alerta alerta= new Alerta("warning","Debes logearte para poder ver la pagina solicitada.");
    				
    				
    				//pasa el mensaje a la vista
    				session.setAttribute("alerta", alerta);
    				
    				
    				// redirecciona a login
    				response.sendRedirect("login.jsp");
    			}else{
    				doPost(request, response);
    			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//para conseguir los datos de la base de datos
		ProductoDAOImp p= ProductoDAOImp.getInstance();
		ArrayList<Producto> productos= p.getAll();
		
		//datos para enviar a la vista
		session.setAttribute("productos", productos);
		
		//ir a la nueva vista o jsp
		response.sendRedirect("tabla-producto.jsp");
	}

}
