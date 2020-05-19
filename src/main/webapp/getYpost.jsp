<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Ejemplos de GET y POST</h1>

	<h2>Eejmplo GET</h2>
	<p>Es necesario un enlace, aunque se puede hacer desde un formulario si cambiamos el METHOD.</p>
	<p>Normlamente es para solicitar informarcion al servidor, aunque tambien lo usaremos para eliminar</p>
	
	<a href="sumar?op1=2&op2=3"> Vamos a sumar 2 + 3</a>

	<h2>Ejemplo POST</h2>
	<p>Siempre es necesario un formulario, normalmente las peticiones POST sriven para crear o modificar recursos en el servidor.</p>
	
	<form action="sumar" method="post" >
	
		<input type="number" name="op1" value="${op1}" placeholder="introduce un numero">
		<br>
		<input type="number" name="op2" value="${op2}" placeholder="introduce otro numero">
		<br>
		<input type="submit" value="Sumar">
	
	</form>
	
	<h2>RESULTADO</h2>
	${resultado}
	

</body>
</html>