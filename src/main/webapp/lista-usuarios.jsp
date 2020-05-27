<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%! String title = "Productos";  %>
<%@include file="includes/cabecera.jsp" %>


<div class="container pt-5">
     
        <h1 class="text-primary text-center mb-5">Lista de Usuarios</h1>
        <p class="text-center mb-5">
          <a href="formulario-usuario2.jsp" class="btn bg-primary text-white">Registrar nuevo usuario</a>
          <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
        </p>
		
		<p>${mensaje}</p>
        <table class="tabla table table-striped">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th   scope="col"> </th>
                <th   scope="col"> </th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${usuarios}" var="u">
				<tr>
					<td>${u.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${u.nombre}</td>
					<td><a href="eliminar-usu?id=${u.id}">ELIMINAR</a></td>
					<td><a href="editarUsuario2.jsp?id=${u.id}&nombre=${u.nombre}">EDITAR</a></td>
				</tr>
			  </c:forEach>
			  
             
            </tbody>
         </table>
  
</div>


<%@include file="includes/pie.jsp" %> 