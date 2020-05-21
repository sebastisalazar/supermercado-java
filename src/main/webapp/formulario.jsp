<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/curriculum.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>CV</h1>
	
   <a href="index.jsp">Volver a inicio</a>
	<c:if test="${not empty requeridos}">
		<div>
			<ul>
				<c:forEach items="${requeridos}" var="e">
					<li style="color:red;font-weight:600">${e}</li>
				</c:forEach>
	
			</ul>
		</div>
	</c:if>
	
	
	<form action="formulario-completo" method="post">

		<label for="nombre">Nombre</label><input type="text" name="nombre" placeholder="Introduce tu nombre" id="nombre" value="${nombre}">
		<br>
		<label for="ape">Apellidos</label><input type="text" name="ape" placeholder="Introduce tu apellido" id="ape" value="${ape}">
		<br>
		<label for="edad">Edad</label><input type="number" name="edad" placeholder="Introduce tu edad" id="edad" value="${edad}">
		<br>
		<label for="fnacimiento">Fecha de nacimiento</label><input type="date" name="fnacimiento" placeholder="Introduce tu fecha" id="fnacimiento" value="${fnacimiento}">
		<br>
		
		<label for="estudios">Estudios</label>
            <select name="estudios" id="estudios">
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

			<input type="radio" id="masculino" name="genero" value="masculino" ${(genero eq "masculino") ?"checked":""}>
			<label for="masculino"> Masculino</label><br>
			<input type="radio" id="femenido" name="genero" value="femenino" ${(genero eq "femenino") ?"checked":""}>
			<label for="femenino"> Femenino</label><br>
			<input type="radio" id="otro" name="genero" value="otro" ${(genero eq "otro") ?"checked":""}>
			<label for="otro" > Otro</label><br>

			
		</fieldset>
		
		<label for="text">Comments:</label><br>
            <textarea name="mensaje" 
                      cols="50" 
                      rows="10" 
                      id="text" 
                      placeholder="Introduce tu comentario..">${mensaje}</textarea>

			<br>

		<label for="foto" >Add your photo</label><br>
        <input type="file" name="foto" id="foto"><br>

        <br>
        <input type="submit" value="Guardar">
        
		
	</form>



	
	
</body>
</html>