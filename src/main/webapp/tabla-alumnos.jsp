
<%@page import="com.ipartek.formacion.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/tablaAlumnos.css">	
	<title>Alumnos</title>
	<%
	// recogemos la informacion "atributo" enviado desde el controlador
	ArrayList<Usuario> alumnos = (ArrayList<Usuario>)request.getAttribute("alumnos");

	%>

</head>
<body>

	<a href="index.jsp">VOLVER</a>
	<br>
	<h1>Tabla de alumnos</h1>
	<table >
		<tr>
		  <th>id</th>
		  <th>Nombre</th>     
		</tr>
		
		<% for( Usuario u : alumnos ){ %>
		
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getNombre()%></td>
			</tr>
		
		<% } %>
		
	  </table>	
</body>
</html>














