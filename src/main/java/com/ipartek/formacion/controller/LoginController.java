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
		
		
		
		HttpSession session = request.getSession();
		
		if (("sebastian@supermercado.es").equalsIgnoreCase(email) && ("admin").equalsIgnoreCase(password)) {
			
			//COOKIE
			
			// gestionar cookie del email	 y password
			
			Cookie cEmail = new Cookie("cEmail", email );
			Cookie cPassword= new Cookie("cPassword", password );
			Cookie cIdioma= new Cookie("cIdioma", idioma );
			
			// Guardar una cookie con la ultima visita
			
			LocalDateTime tiempo = LocalDateTime.now();
			String formattedDate = tiempo.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy_HH:mm"));		
			Cookie cUltimaVisita = new Cookie("cUltimaVisita",formattedDate );
			cUltimaVisita.setMaxAge( 60 * 1 * 60 * 24 * 365  );  // 1 año
			response.addCookie(cUltimaVisita);
			
			if ( recuerdame != null ) {			
				cEmail.setMaxAge( 60 * 1 *60 *24 * 365  );  // 1 año
				cPassword.setMaxAge( 60 * 1 *60 *24 * 365  );
				
			}else{
				cEmail.setMaxAge(0);  // invalidar
				cPassword.setMaxAge(0);	
			}
					
			response.addCookie(cEmail);
			response.addCookie(cPassword);
			response.addCookie(cIdioma);
			
			// recoger todas las cookies en el servidor
			Cookie[] arrayCookies = request.getCookies();
			// para buscar una habrai que hacer un for y buscar por su identificador
			
			
			
			//SESSION
			
			session.setMaxInactiveInterval( 60 * 5 ); // 5 minutos sin peticiones, se invalida la session del usuario
			session.setAttribute("isLogeado", true );
			session.setAttribute("usuario", email );
			
			
			switch (idioma) {
			case "EN":
				mensaje = "You have successfully signed in, nice to have you back here!";
				break;
				
			case "ES":
				mensaje = "¡Hola de Nuevo! te has logeado correctamente. ";
				break;	

			default:
				mensaje = "Kaixo berriro, ongi hasi zara saioa egiten.";
				break;
			}
			
			alerta= new Alerta("success", mensaje);
			request.setAttribute("alerta", alerta);
			request.getRequestDispatcher("panel-administrador.jsp").forward(request, response);
		}else {
			
			session.invalidate();
			alerta= new Alerta("danger", "Usuario o password incorrectos");
			request.setAttribute("alerta", alerta);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
