package testAnder.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class apartadoAController
 */
@WebServlet("/apartado-a")
public class apartadoAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoge los datos del formulario
		String nombre=request.getParameter("nombre");
		String colorFavorito=request.getParameter("colorFavorito");
		
		//creacion de cookies
		Cookie cNombre= new Cookie("nombre", nombre);
		Cookie cColorFavorito= new Cookie("nombre", colorFavorito);
		
		//limite de las cookies
		cNombre.setMaxAge( 60 * 1 * 60 * 24 * 365  );  // 1 año
		cColorFavorito.setMaxAge( 60 * 1 * 60 * 24 * 365  );  // 1 año
		
		//se añaden
		response.addCookie(cNombre);
		response.addCookie(cColorFavorito);
		
		// recoger todas las cookies en el servidor
		Cookie[] arrayCookies = request.getCookies();
		
		//se pasa los atributos a la vista
		request.setAttribute("nombre", nombre);
		request.setAttribute("colorFavorito", colorFavorito);
		
		
		
		//se redirecciona
		request.getRequestDispatcher("resultadoA.jsp").forward(request, response);
	}

}
