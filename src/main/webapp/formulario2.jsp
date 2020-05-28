<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Administrador" />
 
<jsp:param name="title" value="Administrador" /> 
 
</jsp:include>


<div class="container pt-5">

   <h1 class="text-primary text-center mb-2 py-2">CV</h1>
	
   <p class="text-center mb-5">
          <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
   </p>
	<c:if test="${not empty requeridos}">
		<div>
			<ul >
				<c:forEach items="${requeridos}" var="e">
					<li class="text-danger text-center">${e}</li>
				</c:forEach>
	
			</ul>
		</div>
	</c:if>
	
	
	<form action="curriculum-completo" class="formulario-cv" method="post">

		<label class="etiquetaCV" for="nombre">Nombre</label><input class="btnCV" type="text" name="nombre" placeholder="Introduce tu nombre" id="nombre" value="${nombre}">
		<br>
		<label class="etiquetaCV" for="ape">Apellidos</label><input class="btnCV" type="text" name="ape" placeholder="Introduce tu apellido" id="ape" value="${ape}">
		<br>
		<label class="etiquetaCV" for="edad">Edad</label><input class="btnCV" type="number" name="edad" placeholder="Introduce tu edad" id="edad" value="${edad}">
		<br>
		<label class="etiquetaCV" for="fnacimiento">Fecha de nacimiento</label><input class="btnCV" type="date" name="fnacimiento" placeholder="Introduce tu fecha" id="fnacimiento" value="${fnacimiento}">
		<br>
		
		<label class="etiquetaCV" for="estudios">Estudios</label>
            <select class="btnCV" name="estudios" id="estudios">
                <option value="universidad" ${(estudios eq "universidad") ?"selected":""}>Universidad</option>
                <option value="profesional" ${(estudios eq "profesional") ?"selected":""}>Profesional</option>
                <option value="otro" ${(estudios eq "otro") ?"selected":""}>Otro</option>
        	</select>
		<br>
			<fieldset>
				<legend>Jornada preferida:</legend>
	
				<input type="checkbox" id="completa" name="jornada" value="jornada completa" ${(jornada eq "jornada completa") ?"checked":""}>
				<label for="completa"> Completa</label><br>
	
				<input type="checkbox" id="mediaj" name="jornada" value="media jornada" ${(jornada eq "media jornada") ?"checked":""}>
				<label for="mediaj"> Media</label><br>
	
				<input type="checkbox" id="todas" name="jornada" value="ambas(media y completa)" ${(jornada eq "ambas(media y completa)") ?"checked":""}>
				<label for="todas"> Todas</label><br>
			</fieldset>


		<fieldset>
			<legend>Genero:</legend>

			<input class="btnCVRadio" type="radio" id="masculino" name="genero" value="masculino" ${(genero eq "masculino") ?"checked":""}>
			<label for="masculino"> Masculino</label><br>
			<input class="btnCVRadio" type="radio" id="femenido" name="genero" value="femenino" ${(genero eq "femenino") ?"checked":""}>
			<label for="femenino"> Femenino</label><br>
			<input class="btnCVRadio" type="radio" id="otro" name="genero" value="otro" ${(genero eq "otro") ?"checked":""}>
			<label for="otro" > Otro</label><br>

			
		</fieldset>
		
		<label class="etiquetaCV" for="text">Comentario:</label><br>
            <textarea 
            		  
            		  name="mensaje" 
                      cols="50" 
                      rows="10" 
                      id="text" 
                      placeholder="Introduce tu comentario..">${mensaje}</textarea>

			<br>

		<label class="etiquetaCV" for="foto" >Add your photo</label><br>
        <input class="btnCV" type="file" name="foto" id="foto"><br>

        <br>
        <input  class="btnCV" type="submit" value="Guardar">
        
		
	</form>
</div>


<%@include file="includes/pie.jsp" %>
