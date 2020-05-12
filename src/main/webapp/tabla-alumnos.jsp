
<%@page import="com.ipartek.formacion.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Alumnos</title>
	<%
	// recogemos la informacion "atributo" enviado desde el controlador
	ArrayList<Usuario> alumnos = (ArrayList<Usuario>)request.getAttribute("alumnos");

	%>

	<style>
	
		

		tr th{
			background-color: black;
			color: white;
		}
		td { border:1px solid black }
		table{
			border-collapse: collapse;
			background-color: beige;
			
		}
	</style>
</head>
<body>

	<a href="index.jsp">VOLVER</a>
	<br>
	<h1>Tabla de alumnos</h1>
	<table style="width:100%; border:1px solid black;">
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














