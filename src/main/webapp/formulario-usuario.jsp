<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <a href="index2.jsp">VOLVER</a>
	<br>
	<h1>Crear usuario</h1>
	<p>${mensaje}</p>
    <form action="crear-usuario" method="post">
        <input type="text" name="nombre" placeholder="Introduce el nombre del Usuario">
        <input type="submit" value="Crear">
    </form>
</body>
</html>