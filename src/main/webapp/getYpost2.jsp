<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Administrador" />
 
<jsp:param name="title" value="Administrador" /> 
 
</jsp:include>


<div class="container pt-5">

	<h1>Ejemplos de GET y POST</h1>

	<p class="text-center mb-5">
       <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
    </p>
	<h2>Ejemplo GET</h2>
	<p>Es necesario un enlace, aunque se puede hacer desde un formulario si cambiamos el METHOD.</p>
	<p>Normlamente es para solicitar informarcion al servidor, aunque tambien lo usaremos para eliminar</p>
	
	<a href="sumar2?op1=2&op2=3"> Vamos a sumar 2 + 3</a>

	<h2>Ejemplo POST</h2>
	<p>Siempre es necesario un formulario, normalmente las peticiones POST sriven para crear o modificar recursos en el servidor.</p>
	
	<form action="sumar2" method="post" novalidate >
	
		<input type="number" name="op1" value="${op1}" placeholder="introduce un numero" novalidate>
		<br>
		<input type="number" name="op2" value="${op2}" placeholder="introduce otro numero" novalidate>
		<br>
		<input type="submit" value="Sumar">
	
	</form>
	
	<h2>RESULTADO</h2>
	<span style="color:red">${mensaje}</span>
	${resultado}

</div>


<%@include file="includes/pie.jsp" %> 
