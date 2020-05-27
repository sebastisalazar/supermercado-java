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
	<h1>Crear producto</h1>
	<p>${mensaje}</p>
    <form action="crear-producto" method="post">
        <input type="text" name="nombre" placeholder="Introduce el nombre del producto">
        <input type="submit" value="Crear">
    </form>
</body>
</html>