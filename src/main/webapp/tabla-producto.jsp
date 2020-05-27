<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%! String title = "Productos";  %>
<%@include file="includes/cabecera.jsp" %>


<div class="container pt-5">
     
        <h1 class="text-primary text-center mb-5">Lista de productos</h1>
        <p class="text-center mb-5">
          <a href="formulario-producto2.jsp" class="btn bg-primary text-white">Registrar nuevo producto</a>
       	  <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
        </p>
		
		<p>${mensaje}</p>
        <table class="tabla table table-striped">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Precio</th>
                <th scope="col">Descuento</th>
                <th scope="col">Cantidad</th>
                <th scope="col">Imagen</th>
                <th scope="col"></th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${productos}" var="p">
				<tr>
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td>    -      </td>
					<td>    -      </td>
					<td>    -      </td>
					<td><img src="https://picsum.photos/75/75" alt="imagen aleatoria"></td>
					<td><a href="eliminar-prod?id=${p.id}">ELIMINAR</a></td>
					<td><a href="editarProducto2.jsp?id=${p.id}&nombre=${p.nombre}">EDITAR</a></td>
				</tr>
			  </c:forEach>
             
            </tbody>
          </table>
  
    </div>


<%@include file="includes/pie.jsp" %> 