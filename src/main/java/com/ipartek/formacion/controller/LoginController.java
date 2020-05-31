package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		
		String email= request.getParameter("email");
		String password=request.getParameter("password");
		Alerta alerta;
		
		if (email.equalsIgnoreCase("sebastian@supermercado.es") && password.equalsIgnoreCase("admin")) {
			
			HttpSession session = request.getSession();
			request.setAttribute("isLogeado", true);
			request.setAttribute("usuario", email);
			
			alerta= new Alerta("success", "Bienvenido, te has logeado correctamente");
			request.setAttribute("alerta", alerta);
			request.getRequestDispatcher("panel-administrador.jsp").forward(request, response);
		}else {
			alerta= new Alerta("danger", "Usuario o password incorrectos");
			request.setAttribute("alerta", alerta);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
