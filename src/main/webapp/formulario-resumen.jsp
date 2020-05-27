<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/formulario-completo.css">
    <link rel="stylesheet" href="css/formulario-resumen.css">
<meta charset="UTF-8">
<title>Insert title here</title>
	<% 
	    ArrayList<String> datos;
		datos=(ArrayList<String>)request.getAttribute("datos");
	    
	%>
</head>
<body>

    
    <h1>Resumen CV</h1>
    
    <form action="formulario-completo?edit=yes" method="post">
        <table>
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Edad</th>
                <th>Fecha de nacimiento</th>
                <th>Genero</th>
            </tr>
        <tr>
            <td><input type="text" name="nombre" value="<% out.print(datos.get(0)); %>" readonly></td>
            <td><input type="text" name="ape" value="<% out.print(datos.get(1)); %>" readonly></td>
            <td><input type="text" name="edad" value="<% out.print(datos.get(2)); %>" readonly></td>
            <td><input type="text" name="fnacimiento" value="<% out.print(datos.get(3)); %>" readonly></td>
            <td><input type="text" name="genero" value="<% out.print(datos.get(6)); %>" readonly></td>
            
        </tr>
        <tr>
        	
            <th colspan="2">Estudios</th>
            <th colspan="3">Jornada Preferida</th>
        </tr>
        <tr>
            <td colspan="2"><input type="text" name="estudios" value="<% out.print(datos.get(4)); %>" readonly></td>
            <td colspan="3"><input type="text" name="jornada" value="<% out.print(datos.get(5)); %>" readonly></td>
        </tr>
        <tr>
            <th colspan="5">Resumen</th>

        </tr>
        <tr>
         
            <td colspan="5">
                <textarea name="mensaje" 
                      cols="100" 
                      rows="10" 
                      id="mensaje" 
                      value="<% out.print(datos.get(7)); %>" readonly><% out.print(datos.get(7)); %></textarea>

            </td>
            
        </tr>
        <tr>
            <td colspan="5">

                <input type="submit" value="Editar CV">
                <a href="index2.jsp">Ir a inicio</a>

            </td>
            
        </tr>
    
        </table>
    </form>



</body>
</html>