package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutController
 */
@WebServlet("/logout")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//obtiene la sesion creada por el navegador
		HttpSession session1 = request.getSession();
				
		if(session1.getAttribute("usuario_logeado")==null) {
					
			Alerta alerta= new Alerta("warning","Vista sólo disponible para usuarios logeados.");
			request.setAttribute("alerta", alerta);
			// ir a la nueva vista o jsp
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else {
		
		
				//Variables a usar para pasar a la vista
				String mensaje;
				String idioma="ES";
				
				//obtiene todas las cookies creadas en un array
				Cookie[] cookies = request.getCookies();
				
				//se lee el array de cookies
				for ( Cookie c : cookies ) {
					
					//Se mira que idioma seleccionó el usuario y se guardo en la cookie
					if ( "cIdioma".equals(c.getName()) ) {   // cookie encontrada
						idioma = c.getValue();//se guarda el idioma
						break;//sale del for
					}			
				}
				
				//Se evalua el idioma el idioma
				switch (idioma) {
				case "EN":
					mensaje = "You have successfully signed out, See you soon!";
					break;
					
				case "ES":
					mensaje = "Has cerrado sesión correctamente, ¡hasta pronto! ";
					break;	
		
				default:
					mensaje = "Ondo amaitu duzu saioa, laster arte!";
					break;
				}
			
			 
				//se obtiene la session que se haya creado
				HttpSession session = request.getSession();
				
				//se mata /invalida la sesion
				session.invalidate();
				
				//Se inicializa a null para que no guarde nada
				session = null;
				
				//se pasa el mensaje de DESLOGEO mediante una alerta
				request.setAttribute("alerta", new Alerta("success", mensaje));
				
				//Se redirecciona a login
				request.getRequestDispatcher("login.jsp").forward(request, response);
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
