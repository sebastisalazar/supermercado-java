package com.ipartek.formacion.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioCompletoController
 */
@WebServlet("/curriculum-completo")
public class FormularioCompletoController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DATOS PERSONALES
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Guarda los parametros recibidos por POST del formulario
		String nombre=request.getParameter("nombre");
		String ape=request.getParameter("ape");
		String edadString=request.getParameter("edad");
		String fnacimiento=request.getParameter("fnacimiento");
		String estudios=request.getParameter("estudios");
		String jornada=request.getParameter("jornada");
		String genero=request.getParameter("genero");
		String mensaje=request.getParameter("mensaje");
		String foto=request.getParameter("foto");
		String edit=request.getParameter("edit");
	
		//los guarda en array
		ArrayList<String> datos=new ArrayList<String>();
		
		//Array para errores
		ArrayList<String> errores= new ArrayList<String>();
		
		
		//los vuelve a enviar
				request.setAttribute("nombre", nombre);
				request.setAttribute("ape", ape);
				request.setAttribute("edad", edadString);
				request.setAttribute("fnacimiento", fnacimiento);
				request.setAttribute("estudios", estudios);
				request.setAttribute("jornada", jornada);
				request.setAttribute("genero", genero);
				request.setAttribute("mensaje", mensaje);
		
		//Si se quiere editar el CV ya rellenado	
		if (("yes").equalsIgnoreCase(edit)==true) {
			request.getRequestDispatcher("formulario2.jsp").forward(request, response);
		
		//Si se quiere rellenar el CV vacio
		}else {
			//Validaciones
			if (("").equalsIgnoreCase(nombre)==true) {
				errores.add("El campo nombre es requerido");
			}else {
				datos.add(nombre);
			}
			if (("").equalsIgnoreCase(ape)==true) {
				errores.add("El campo apellido es requerido");
			}else {
				datos.add(ape);
			}
			if (("").equalsIgnoreCase(edadString)==true) {
				errores.add("El campo edad es requerido");
			}else {
				datos.add(edadString);
			}
			if (("").equalsIgnoreCase(fnacimiento)==true) {
				errores.add("El campo fecha de nacimiento es requerido");
			}else {
				datos.add(fnacimiento);
			}
			if (("").equalsIgnoreCase(estudios)==true) {
				errores.add("El campo estudios es requerido");
			}else {
				datos.add(estudios);
			}
			
			if (jornada==null) {
				errores.add("El campo jornada es requerido");
			}else {
				datos.add(jornada);
			}
			
			if (genero==null) {
				errores.add("El campo genero es requerido");
			}else {
				datos.add(genero);
			}
			
			if (("").equalsIgnoreCase(mensaje)==true) {
				errores.add("El campo comentario es requerido");
			}else {
				datos.add(mensaje);
			}
			
			//Recoge los datos introducidos y los envia la vista
			request.setAttribute("datos", datos);
			
			//si NO existen errores se muestra el resumen
			if (errores.size()==0) {
				request.getRequestDispatcher("formulario-resumen2.jsp").forward(request, response);
			}else {
				
				//SI existen errores se redirecciona al mismo formulario indicando los errores
				request.setAttribute("requeridos", errores);
				request.getRequestDispatcher("formulario2.jsp").forward(request, response);
			}
			
		}
			
			
			
		
		
	}

}
