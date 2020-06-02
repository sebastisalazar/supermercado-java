package com.ipartek.formacion.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class apartadoAController
 */
@WebServlet("/apartado-b")
public class apartadoBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//REcoge los parametros de la vista
		String nombre=request.getParameter("nombre");
		String colorFavorito=request.getParameter("colorFavorito");
		
		//obtiene la fecha
		LocalDateTime tiempo = LocalDateTime.now();
		String horaInicio = tiempo.format(DateTimeFormatter.ofPattern("HH:mm"));
		
		//navegador
		String navegador=request.getHeader("User-Agent");
	
		
		//Creacion de la sesion
		HttpSession session = request.getSession();
		
		//Asersicon de atributos para recoger en la vista
		session.setAttribute("nombre", nombre);
		session.setAttribute("color", colorFavorito);
		session.setAttribute("horaInicio", horaInicio) ;
		session.setAttribute("navegador",navegador);
		
		//se redirecciona a la vista
		request.getRequestDispatcher("resultadoB.jsp").forward(request, response);
	}

}
