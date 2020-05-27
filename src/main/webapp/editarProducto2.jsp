<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%! String title = "Productos";  %>
<%@include file="includes/cabecera.jsp" %>

<div class="container pt-5">
    <h1 class="text-primary text-center mb-5">Editar producto</h1>
        <p class="text-center mb-5">
          <a href="lista-productos" class="btn bg-primary text-white">Ver todos los productos</a>
          <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
   		</p>
    
    <form action="editar-prod?id=<%= request.getParameter("id") %>&nombre=<%= request.getParameter("nombre") %>" method="POST">
   		<table class="tabla table table-striped">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
              </tr>
            </thead>
         	<tbody>
				<tr>
                	<td><label for="id">Id: </label><input id="id" type="text" name="id" placeholder="<%= request.getParameter("id") %>" readonly></td>
                	<td><label for="nombre" >Nombre: </label><input id="nombre" type="text" name="nombrenuevo" value="<%= request.getParameter("nombre") %>"></td>
            	</tr>
            
	            <tr>
	                
	                <td colspan="2"><input id="boton" type="submit" value="Actualizar producto"></td>
	            </tr>
            </tbody>
   		</table>
    </form>
    
    
    
    
</div> 
<%@include file="includes/pie.jsp" %> 