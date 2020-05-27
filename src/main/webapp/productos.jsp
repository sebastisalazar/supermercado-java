<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/productos2.css">	
<title>Productos</title>
</head>
<body>


<a href="index2.jsp">VOLVER</a>
<br>	
	<h1>Listado Productos</h1>
	<p>${mensaje}</p>

	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>	
	
	<table>
	
		
		<tr>
			<th>id</th>
		    <th>Nombre</th> 
		    <th colspan="2">Opciones</th> 
		</tr>
		<c:forEach items="${productos}" var="p">
				<tr>
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td><a href="eliminar-producto?id=${p.id}">ELIMINAR</a></td>
					<td><a href="editarProducto.jsp?id=${p.id}&nombre=${p.nombre}">EDITAR</a></td>
				</tr>
		</c:forEach>
		
	</table>
	
</body>
</html>