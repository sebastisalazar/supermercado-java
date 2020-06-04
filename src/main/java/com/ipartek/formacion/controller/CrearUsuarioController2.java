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
import com.ipartek.formacion.modelo.Rol;
import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class CrearUsuarioController
 */
@WebServlet("/crear-usu")
public class CrearUsuarioController2 extends HttpServlet {
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
					request.getRequestDispatcher("formulario-usuario2.jsp").forward(request, response);
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//iniciliacion para operar contra bbdd
		UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
		
		//Inicializacion para guardar mensajes de alerta
		Alerta alerta= new Alerta();
		
		//Guarda el value de los campos del formulario
		String nombre;
		String contrasenia;
		int id_rol;
		
		//objeto usuario vacio para rellenar con los datos
		Usuario u= new Usuario();
		
		//comprobacion de campos vacios
		
		//campo nombre
		
		if (("").equalsIgnoreCase(request.getParameter("nombre"))) {
			nombre="-";
		}else {
			nombre=request.getParameter("nombre");
		}
		
		//campo contraseña
		 if (("").equalsIgnoreCase(request.getParameter("contrasenia"))==true) {
			contrasenia="12345";
		 }else{
			contrasenia=request.getParameter("contrasenia");
		 }//fin if
		 
		 //campo id_rol
		 if (("").equalsIgnoreCase(request.getParameter("id_rol"))==true) {
			id_rol=1;
		 }else{
			id_rol=Integer.parseInt(request.getParameter("id_rol"));
		 }//fin if
		
		//asercion de atributos al objeto vacio
		 u.setNombre(nombre);
		//asercion de datos despues de comprobaciones
		 u.setNombre(nombre);
		 u.setContrasenia(contrasenia);
		 u.setId_rol(new Rol(id_rol));
		
		//ejecucion de insert y creacion de alertas
		try {
			
			u=dao.insert(u);
			alerta = new Alerta( "success", "Usuario creado con exito");
			
		} catch (Exception e) {
			
			alerta = new Alerta( "danger", "Error, El Usuario no se ha podido crear. "+e.getMessage());
			e.printStackTrace();
			
		}finally{
			//se envian los mensajes de alerta a la vista
			request.setAttribute("alerta", alerta);
			//se redirecciona
			request.getRequestDispatcher("formulario-usuario2.jsp").forward(request, response);
		}
		
		
		
	}

}
