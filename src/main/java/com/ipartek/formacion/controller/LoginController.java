package com.ipartek.formacion.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//parametros para sesion y cookies
		String email= request.getParameter("email");
		String password=request.getParameter("password");
		String idioma=request.getParameter("idioma");
		String recuerdame = request.getParameter("recuerdame");
		Alerta alerta;
		String mensaje;
		
		
		//obtiene la sesion creada por el navegador
		HttpSession session = request.getSession();
		
		//Validacion de usuario (si existe en la base de datos)
		UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
		Usuario usuario=null;
		
		try {
			usuario=dao.getExiste(email, password);
			
		} catch (Exception e) {
			alerta= new Alerta("danger",e.getMessage());
		}
		
		
		if (usuario!=null) {
			
		//COOKIE
			
			// gestionar cookie del email	 y password
			Cookie cEmail = new Cookie("cEmail", email );
			Cookie cPassword= new Cookie("cPassword", password );
			Cookie cIdioma= new Cookie("cIdioma", idioma );
			
			// Guardar una cookie con la ultima visita
			LocalDateTime tiempo = LocalDateTime.now();
			String formattedDate = tiempo.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy_HH:mm"));
			
			//la hora obtenida se guarda en la cookie
			Cookie cUltimaVisita = new Cookie("cUltimaVisita",formattedDate );
			
			
			//Se pone un tiempo de expiracion para las cookies
			if ( recuerdame != null ) {	 //si acepta el boton de recuerdame	se recordara sus datos hasta 1 año
				cEmail.setMaxAge( 60 * 1 *60 *24 * 365  );  // 1 año
				cPassword.setMaxAge( 60 * 1 *60 *24 * 365  );
				
			}else{
				cEmail.setMaxAge(0);  // invalidar
				cPassword.setMaxAge(0);	
				
			}
			
			//Se fija una experiacion para la cookie de visita
			cUltimaVisita.setMaxAge( 60 * 1 * 60 * 24 * 365  );  // 1 año
			
			//se añaden las cookies a la respuesta
			response.addCookie(cUltimaVisita);
			response.addCookie(cEmail);
			response.addCookie(cPassword);
			response.addCookie(cIdioma);
			
			// recoger todas las cookies en el servidor
			Cookie[] arrayCookies = request.getCookies();
			// para buscar una habrai que hacer un for y buscar por su identificador
			
			//Guardamos el nombre para mostrar quien esta logeado en la vista
			
			session.setAttribute("usuario_logeado", email);
			
			//Se evalua el idioma el idioma
			switch (idioma) {
			case "EN":
				mensaje = "You have successfully signed in, Glad to have you back here!";
				break;
				
			case "ES":
				mensaje = "Has iniciado sesion correctamente, ¡Encantados de tenerte de vuelta por aqui! ";
				break;	

			default:
				mensaje = "Sartu zara arrakastaz, atsegin baduzu berriro hemen!";
				break;
			}
			
			
			//se crea la alerta para informar del error con un mensaje
			alerta= new Alerta("success", mensaje);
			
			
			//Se pasa la alerta con mensajes a la vista
			request.setAttribute("alerta", alerta);
		
			//se redirecciona otra vez al login
			request.getRequestDispatcher("panel-administrador.jsp").forward(request, response);
			
		}else {//si no esta logeado
			
			
			//la session se invalida
			session.invalidate();
			
			//se crea la alerta para informar del error con un mensaje
			alerta= new Alerta("danger", "Usuario o password incorrectos");
			
			//se pasa la alerta con los mensajes para ser leidos en la vista
			request.setAttribute("alerta", alerta);
			
			
			//se redirecciona otra vez al login
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
