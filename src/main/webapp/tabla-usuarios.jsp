
<%@page import="com.ipartek.formacion.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/tablaAlumnos.css">	
	<title>Usuarios</title>
	<%
	// recogemos la informacion "atributo" enviado desde el controlador
	ArrayList<Usuario> alumnos = (ArrayList<Usuario>)request.getAttribute("alumnos");

	%>

</head>
<body>

	<a href="index2.jsp">VOLVER</a>
	<br>
	<h1>Tabla de usuarios</h1>
	<p>${mensaje}</p>
	<table >
		<tr>
		  <th>id</th>
		  <th>Nombre</th> 
		  <th colspan="2">Opciones</th>    
		</tr>
		
		<% for( Usuario u : alumnos ){ %>
		
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getNombre()%></td>
				<td><a href="eliminar-usuario?id=<%= u.getId()%>&nombre=<%=u.getNombre()%>">Eliminar</a></td>
				<td><a href="editarUsuario.jsp?id=<%= u.getId()%>&nombre=<%=u.getNombre()%>">Editar</a></td>
			</tr>
		
		<% } %>
		
	  </table>	
</body>
</html>














