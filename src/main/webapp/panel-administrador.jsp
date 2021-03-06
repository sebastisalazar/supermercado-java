<%@page import="com.ipartek.formacion.controller.Alerta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="PanelControl" />
 
<jsp:param name="title" value="Panel de Control" /> 
 
</jsp:include>


<div class="container pb-4">
	<div class="container pt-5">
		<jsp:include page="includes/alerta.jsp"></jsp:include>
	</div>

	<div id="contenedor">
		
		<div id="caja">
			
			<h1 class="text-primary text-center pt-20 d-block" style="flex: 0 1 100%;">Panel de control</h1><br>
			<a class="boton" href="getYpost2.jsp">GET y POST</a>
			<a class="boton" href="formulario2.jsp">Ejemplo Formulario Completo</a>
				<a  class="boton" href="lista-usuarios"> Ver tabla usuarios </a>
				<br>
				<a class="boton" href="lista-productos"> Ver tabla productos </a> 
				<br>
				<a class="boton" href="crear-prod"> Crear productos </a>
				<br>
				<a class="boton" href="crear-usu"> Crear Usuarios </a> 
			
	 	</div>

	</div>
</div>	

<jsp:include page="includes/pie.jsp"/>