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
		
		String mensaje;
		String idioma="ES";
		
		Cookie[] cookies = request.getCookies();
		for ( Cookie c : cookies ) {			
			if ( "cIdioma".equals(c.getName()) ) {   // cookie encontrada
				idioma = c.getValue();
				break;
			}			
		}
		
		switch (idioma) {
		case "EN":
			mensaje = "You have successfully signed out, See yo soon!";
			break;
			
		case "ES":
			mensaje = "Has cerrado sesión correctamente, ¡hasta pronto! ";
			break;	

		default:
			mensaje = "Ondo amaitu duzu saioa, laster arte!";
			break;
		}
	
		
		

		HttpSession session = request.getSession();
		session.invalidate();
		session = null;
		
		
		request.setAttribute("alerta", new Alerta("success", mensaje));
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
