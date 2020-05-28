<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<String> datos=(ArrayList<String>)request.getAttribute("datos");
	String title = "Productos";  

%>
<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Administrador" />
 
<jsp:param name="title" value="Administrador" /> 
 
</jsp:include>

	    

%>

<div class="container pt-5">
	
    <h1 class="text-primary text-center mb-2 py-2">Resumen CV</h1>
    <p class="text-center mb-5">
          <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
   </p>
    <form action="curriculum-completo?edit=yes" method="post">
        <table class="table">
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Edad</th>
                <th>Fecha de nacimiento</th>
                <th>Genero</th>
            </tr>
        <tr>
            <td><input class="btn" type="text" name="nombre" value="<% out.print(datos.get(0)); %>" readonly></td>
            <td><input class="btn" type="text" name="ape" value="<% out.print(datos.get(1)); %>" readonly></td>
            <td><input class="btn" type="text" name="edad" value="<% out.print(datos.get(2)); %>" readonly></td>
            <td><input class="btn" type="text" name="fnacimiento" value="<% out.print(datos.get(3)); %>" readonly></td>
            <td><input class="btn" type="text" name="genero" value="<% out.print(datos.get(6)); %>" readonly></td>
            
        </tr>
        <tr>
        	
            <th colspan="2">Estudios</th>
            <th colspan="3">Jornada Preferida</th>
        </tr>
        <tr>
            <td colspan="2"><input class="btn" type="text" name="estudios" value="<% out.print(datos.get(4)); %>" readonly></td>
            <td colspan="3"><input class="btn" type="text" name="jornada" value="<% out.print(datos.get(5)); %>" readonly></td>
        </tr>
        <tr>
            <th colspan="5">Resumen</th>

        </tr>
        <tr>
         
            <td colspan="5">
                <textarea 
                	  class="btn text-left" 
                	  name="mensaje" 
                      cols="100" 
                      rows="3" 
                      id="mensaje" 
                      value="<% out.print(datos.get(7)); %>" readonly><% out.print(datos.get(7)); %></textarea>

            </td>
            
        </tr>
        <tr>
            <td colspan="5" class="text-center">
				
				<input  class="btn bg-primary text-white boton-CV" type="submit" value="Editar CV">
		
            </td>
            
        </tr>
    
        </table>
    </form>
</div>
<%@include file="includes/pie.jsp" %>