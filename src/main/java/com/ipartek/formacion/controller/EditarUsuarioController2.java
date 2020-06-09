package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.ProductoDAOImp;
import com.ipartek.formacion.modelo.Rol;
import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class EditarUsuarioController
 */
@WebServlet("/editar-usu")
public class EditarUsuarioController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtiene la sesion creada por el navegador
		HttpSession session = request.getSession();
		
		//si no existe ssesion con logeo
		if(session.getAttribute("usuario_logeado")==null) {
							
			//crea mensajes para mostrar
			Alerta alerta= new Alerta("warning","Debes logearte para poder ver la pagina solicitada.");
							
			//los guarda en la sesion
			session.setAttribute("alerta", alerta);
							
			// redirecciona a login
			response.sendRedirect("login.jsp");
							
				//si esta logeado da permiso a ver el formulario
		}else{
			
			//recogemos el id pasado por parametro
			int id= Integer.parseInt(request.getParameter("id"));
			
			//Inicializacion para operar contra bbdd
			UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
			
			
			//ejecucion del select by id 
			try {
				//obtenemos el producto mediante el id y lo guardamos
				Usuario usuario= dao.getById(id);
				
				//se pasa el objeto producto obtenido con todos sus atributos a la vista
				session.setAttribute("usuario",usuario);
				

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				//se redirecciona
				response.sendRedirect("editarUsuario2.jsp");
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtiene la session abierta
		 HttpSession session= request.getSession();
		
		//iniciliacion para guardas mensajes de alerta
		Alerta alerta = new Alerta();
		
		//Usuario vacio que se asignara los campos del formulario
		Usuario u= new Usuario();
		
		//Guarda el value de los campos del formulario
		String nombre="";
		String contrasenia=request.getParameter("contraseniaactual");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		String id=request.getParameter("id");
		int id_rol;
		
		//Iniciliacion para operar contra la bbdd
		UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
		
		
		//mensaje requeridos
		
		ArrayList<String> requeridos=new ArrayList<String>();
		
		
		//comprobaciones de campos en blanco
		 
	  	//campo nombre
		 if (("").equalsIgnoreCase(request.getParameter("nombre"))==true) {
			requeridos.add("El campo nombre es requerido");
		 }else{
			nombre=request.getParameter("nombre");
		 }//fin if
		 
		 
		 
		//campo contraseña
		 if (!("").equalsIgnoreCase(password1) && !("").equalsIgnoreCase(password2)) {
			 
			 if(password1.equalsIgnoreCase(password2)) {
				 
				 if(!password1.equalsIgnoreCase(contrasenia)) {
					 contrasenia=password1; 
				 }
					 
			 }else {
				 
				requeridos.add("Los campos de nueva contraseña no coinciden");
				 
			 }
			 
		 }//fin if
		 
		 //campo id_rol
		 if (("").equalsIgnoreCase(request.getParameter("id_rol"))==true) {
			id_rol=1;
		 }else{
			id_rol=Integer.parseInt(request.getParameter("id_rol"));
		 }//fin if
		 
		 //si NO existen campos requeridos
		 if (requeridos.size()==0) {
			
			//asercion de datos despues de comprobaciones
			 u.setId(Integer.parseInt(id));
			 u.setNombre(nombre);
			 u.setContrasenia(contrasenia);
			 u.setId_rol(new Rol(id_rol));
			
			 //ejecucion update y creacion de mensajes de alerta
			try {
				
				u=dao.update(u);
				alerta = new Alerta( "success", "Usuario actualizado con exito");
			} catch (Exception e) {
				alerta = new Alerta( "danger", "Error, el usario no se ha podido editar. " + e.getMessage());
				e.printStackTrace();
			}finally {
				
				//obtiene el estado de la lista des 
				ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
				try {
					usuarios = dao.getAll();
				} catch (Exception e) {
					e.printStackTrace();
				}//fin try catch
				
				//Se pasa los mensajes de alerta y el estado de la lista despues del update
				session.setAttribute("alerta",alerta);
				session.setAttribute("usuarios",usuarios);
				
				//Finalmente se redirecciona
				response.sendRedirect("lista-usuarios.jsp");
				
				
			}//fin try catch
			 
			 
		//si existen campos requeridos	 
		}else {
			
			//se pasan los atributos escritos a la vista
			session.setAttribute("id",id);
			session.setAttribute("nombreIntroducido", nombre);
			session.setAttribute("id_rolIntroducido", id_rol);
			
			//se pasa los mensajes
			session.setAttribute("requeridos", requeridos);
			//se redirecciona
			response.sendRedirect("editarUsuario2.jsp");
		}
		 
		 
		
		
		
		
		
	}//fin DOPOST

}//FIN CLASE
