package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SumarController
 */
@WebServlet("/sumar2")
public class SumarController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//recoger parametros del formulario
		String parametro1 = request.getParameter("op1");
		String parametro2 = request.getParameter("op2");
		
		//Parsear a int y sumar
	
		int resultado =Integer.parseInt(parametro1)+Integer.parseInt(parametro2);
		
		
		//volver a enviar los PARAMETROS recibido como ATRIBUTOS
		request.setAttribute("op1", parametro1);		
		request.setAttribute("op2", parametro2);	
		
		request.setAttribute("resultado", resultado);		
		request.getRequestDispatcher("getYpost2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//recoger parametros del formulario
		String parametro1 = request.getParameter("op1");
		String parametro2 = request.getParameter("op2");
		request.setAttribute("op1",request.getParameter("op1"));		
		request.setAttribute("op2",request.getParameter("op2"));
		String mensaje="";
		int resultado=0;
		//volver a enviar los PARAMETROS recibido como ATRIBUTOS
		
		
		try {
			
			
			if (parametro1.equals("")==true && parametro2.equals("")==true) {
				
				throw new Exception("Campos en blanco");
			}else {
				
					try {
						
						
						resultado+=Integer.parseInt(parametro1);
						if (parametro1.equals("")==true) {
							
							throw new Exception("Error, el primer campo está en blanco");
							
						}
					} catch (Exception e) {
						throw new Exception("El primer campo no contiene un numero");
					}
				
				
					try {
						resultado+=Integer.parseInt(parametro2);
						
						if (parametro2.equals("")==true ) {
							
							throw new Exception("Error, el segundo campo está en blanco");
			
						}
						
						
					} catch (Exception e) {
						throw new Exception("El segundo campo no contiene un numero");
					}
				
			
					request.setAttribute("resultado", resultado);
			}
			
			
			
				
			

			
				
		}catch(Exception e) {
			
			mensaje=e.getMessage();
			request.setAttribute("mensaje", mensaje);
			
		}finally {
			
			request.getRequestDispatcher("getYpost2.jsp").forward(request, response);
		}
		

		
	}

}
