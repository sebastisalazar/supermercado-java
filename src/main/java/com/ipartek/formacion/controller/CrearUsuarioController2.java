package com.ipartek.formacion.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
				
				//si no existe un logeo
				if(session.getAttribute("usuario_logeado")==null) {
					
					Alerta alerta= new Alerta("warning","Vista sólo disponible para usuarios logeados.");
					
					session.setAttribute("alerta", alerta);
					
					// ir a la nueva vista o jsp
					response.sendRedirect("login.jsp");
				}else{
					response.sendRedirect("formulario-usuario2.jsp");
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//se obtiene la session creada por el navegador
		HttpSession session= request.getSession();
		
//iniciliacion para operar contra bbdd
		UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
		
//Inicializacion para guardar mensajes de alerta
		Alerta alerta= new Alerta();
		
//Guarda el value de los campos del formulario
		String nombre="";
		String contrasenia="";
		String contraseniaSinCifrar="";
		int id_rol=1;
		
		
//Array para indicar los campos requeridos
		ArrayList<String> requeridos= new ArrayList<String>();
		
		
//objeto usuario vacio para rellenar con los datos
		Usuario u= new Usuario();
		
//comprobacion de campos vacios
		
		
	//campo nombre
		if (("").equalsIgnoreCase(request.getParameter("nombre"))) {
			
			//agrega un mensaje al array
			requeridos.add("El campo nombre es requerido");
			
		}else {
			nombre=request.getParameter("nombre");
		}
		
	//campo contraseña
		 if (("").equalsIgnoreCase(request.getParameter("contraseniaCifrada"))==true) {
			 
			//agrega un mensaje al array
			requeridos.add("El campo contraseña es requerido");
		 }else{
			contrasenia=request.getParameter("contraseniaCifrada");
			contraseniaSinCifrar=request.getParameter("contraseniaSinCifrar");
		 }//fin if
		 
	//campo id_rol
		 if (("").equalsIgnoreCase(request.getParameter("id_rol"))==true) {
			//agrega un mensaje al array
			requeridos.add("Elige un tipo de requerido");
		 }else{
			id_rol=Integer.parseInt(request.getParameter("id_rol"));
		 }//fin if
		 
		 
//verificacion de campos erroneos
		 
		 //si existen mensajes se redirecciona al formulario conservando lo que el usuario haya introducido
		 if (requeridos.size()!=0) {
			
			 //se guardan en la session para que en la vista se puedan leer
			 session.setAttribute("nombreIntroducido", nombre);
			 
			 //esta contraseña es la del campo oculto, solo se usa para cuando exista un error de campo y poder devolver lo que se escribrio
			 session.setAttribute("contraseniaIntroducida", contraseniaSinCifrar);
			 session.setAttribute("idRolIntroducido", id_rol);
			 session.setAttribute("requeridos", requeridos);
			 
			 //redireccion al formulario
			 response.sendRedirect("formulario-usuario2.jsp");
			 
//SI NO EXISTEN mensajes para campos requeridos
		}else {
			
			//asercion de atributos al objeto vacio
			 
			 u.setNombre(nombre);
			 u.setNombre(nombre);
			 u.setContrasenia(contrasenia);
			 u.setId_rol(new Rol(id_rol));
			
			 //ejecucion de insert y creacion de alertas
			 
			try {
				
				u=dao.insert(u);
				alerta = new Alerta( "success", "Usuario creado con exito");
				
			} catch (Exception e) {
				
				alerta = new Alerta( "danger",e.getMessage());
				
			}finally{
				//se envian los mensajes de alerta a la vista
				session.setAttribute("alerta", alerta);
				//se redireccion al formulario
				response.sendRedirect("formulario-usuario2.jsp");
			}
			
			
		}
		 
		 
		

		
		
		
	}

}
