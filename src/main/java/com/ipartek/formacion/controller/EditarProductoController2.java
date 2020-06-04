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
		
		if(session.getAttribute("usuario_logeado")==null) {
			
			Alerta alerta= new Alerta("warning","Vista sólo disponible para usuarios logeados.");
			request.setAttribute("alerta", alerta);
			// ir a la nueva vista o jsp
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			 
			//obtiene el ID del formulario
			int id= Integer.parseInt(request.getParameter("id"));
			
			//iniciliacion para llamar al getbyid
			ProductoDAOImp dao= ProductoDAOImp.getInstance();
			
			try {
				//obtenemos el producto mediante el id y lo guardamos
				Producto producto= dao.getById(id);
				
				//se pasa el objeto producto obtenido con todos sus atributos a la vista
				request.setAttribute("producto", producto);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
				//finalmente se redirecciona
				request.getRequestDispatcher("editarProducto2.jsp").forward(request, response);
			}
		}
		
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//iniciliacion para guardas mensajes de alerta
		Alerta alerta = new Alerta();
		
		//iniciliacion para operar contra bbdd
		ProductoDAOImp dao= ProductoDAOImp.getInstance();
		
		//Recoge los datos en los campos
		String nombre;
		String foto;
		float precio;
		
		//producto vacio a rellenar con los datos recogidos
		Producto p= new Producto();
	
		//Comprobaciones de campos vacios
		
		//campo nombre
		if (("").equalsIgnoreCase(request.getParameter("nombre"))==true) {
			nombre="-";
		}else{
			nombre=request.getParameter("nombre");
		}
		
		//campo foto
		if (("").equalsIgnoreCase(request.getParameter("foto"))==true) {
			foto="https://picsum.photos/75/75";
		}else{
			foto=request.getParameter("foto");
		}
		
		//campo precio
		if (("").equalsIgnoreCase(request.getParameter("precio"))==true) {
			precio=0f;
		}else{
			precio=Float.parseFloat(request.getParameter("precio"));
		}
		
		
		//Asercion de datos al producto
		p.setId(Integer.parseInt(request.getParameter("id")));
		p.setNombre(nombre);
		p.setPrecio(precio);
		p.setFoto(foto);
		
		//ejecucuon del update
		try {
			dao.update(p);
			alerta = new Alerta( "success", "Producto actualizado con exito");
		} catch (Exception e) {
			alerta = new Alerta( "danger", "Error, el producto no se ha podido editar. " + e.getMessage());
			e.printStackTrace();
		}finally {
			
			//Se obtiene el estado de la lista despues del update
			ArrayList<Producto> productos= dao.getAll();
			
			//se pasa el estado de la lista despues del update y los mensajes de alerta obtenidos
			request.setAttribute("productos", productos);
			request.setAttribute("alerta", alerta);
			
			//Finalmente se redirecciona
			request.getRequestDispatcher("tabla-producto.jsp").forward(request, response);
		}
		
		
	}

}
