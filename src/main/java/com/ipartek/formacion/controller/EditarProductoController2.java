package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImp;

/**
 * Servlet implementation class EditarProductoController
 */
@WebServlet("/editar-prod")
public class EditarProductoController2 extends HttpServlet {
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
			 
				//obtiene el ID del formulario
				int id= Integer.parseInt(request.getParameter("id"));
				
				//iniciliacion para llamar al getbyid
				ProductoDAOImp dao= ProductoDAOImp.getInstance();
				
				try {
					//obtenemos el producto mediante el id y lo guardamos
					Producto producto= dao.getById(id);
					
					//se pasa el objeto producto obtenido con todos sus atributos a la vista
					session.setAttribute("producto", producto);
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					//se redirecciona
					response.sendRedirect("editarProducto2.jsp");
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
		
		//iniciliacion para operar contra bbdd
		ProductoDAOImp dao= ProductoDAOImp.getInstance();
		
		//Recoge los datos en los campos
		String id=request.getParameter("id");
		String nombre="";
		String foto="https://picsum.photos/75/75";
		float precio=0;
		
		//producto vacio a rellenar con los datos recogidos
		Producto p= new Producto();
		
		//mensaje requeridos
		
		ArrayList<String> requeridos=new ArrayList<String>();
	
		//Comprobaciones de campos vacios
		
		//campo nombre
		if (("").equalsIgnoreCase(request.getParameter("nombre"))==true) {
			requeridos.add("El campo nombre es requerido");
		}else{
			nombre=request.getParameter("nombre");
		}
		
		//campo foto
		if (("").equalsIgnoreCase(request.getParameter("foto"))==false) {
			foto=request.getParameter("foto");
		}
		
		//campo precio
		if (("").equalsIgnoreCase(request.getParameter("precio"))==true) {
			requeridos.add("El campo precio es requerido");
		}else{
			precio=Float.parseFloat(request.getParameter("precio"));
		}
		
		//si NO existen campos requeridos
		if (requeridos.size()==0) {
			
			//Asercion de datos al producto
			p.setId(Integer.parseInt(id));
			p.setNombre(nombre);
			p.setPrecio(precio);
			p.setFoto(foto);
			
			//ejecucuon del update
			try {
				dao.update(p);
				alerta = new Alerta( "success", "Producto actualizado con exito");
			} catch (Exception e) {
				alerta = new Alerta( "danger", "Error al actualizar, " + e.getMessage());
			}finally {
				
				//Se obtiene el estado de la lista despues del update
				ArrayList<Producto> productos= dao.getAll();
				
				//se pasa el estado de la lista despues del update y los mensajes de alerta obtenidos
				session.setAttribute("productos", productos);
				session.setAttribute("alerta", alerta);
				
				//Finalmente se redirecciona
				response.sendRedirect("tabla-producto.jsp");
			}
			
			
		//si existen campos requeridos
		}else {
			
			//se pasan los atributos escritos a la vista
			session.setAttribute("id",id);
			session.setAttribute("nombre", nombre);
			session.setAttribute("foto", foto);
			session.setAttribute("precio", precio);
			
			//se pasa los mensajes
			session.setAttribute("requeridos", requeridos);
			//se redirecciona
			response.sendRedirect("editarProducto2.jsp");
		}
		
		
		
		
		
	}

}
