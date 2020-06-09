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
 * Servlet implementation class EliminarProductoController
 */
@WebServlet("/eliminar-prod")
public class EliminarProductoController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recogemos los parametros de los campos del formulario
		String ids=request.getParameter("id");
		int id=Integer.parseInt(ids);
		
		//iniciliacion de crud
		ProductoDAOImp dao= ProductoDAOImp.getInstance();
		
		//inciliacion para guardas los mensajes de la respuesta
		Alerta alerta= new Alerta();
		
		//delete y creacion de alerta con mensajes
		try {
			dao.delete(id);
			alerta = new Alerta( "success", "Producto eliminado con exito");
		} catch (Exception e) {
			alerta = new Alerta( "danger", "Error, no se ha podido borrar el producto. "+e.getMessage());
			e.printStackTrace();
		}finally {
			
			//inicialiacion para guardar el estado de la lista despues del delete
			ArrayList<Producto> productos=dao.getAll();
			
			
			//obtiene la session creada
			HttpSession session=request.getSession();
			
			//se pasan los mensajes de la respuesta y el estado de la lista actual despues del update a la vista
			session.setAttribute("alerta", alerta);
			session.setAttribute("productos", productos);
			
		
			//se redirecciona
			response.sendRedirect("tabla-producto.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
