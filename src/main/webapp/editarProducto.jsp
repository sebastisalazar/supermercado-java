<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Producto</title>
    <link rel="stylesheet" href="css/editarProducto.css">
</head>
<body>
    <a href="index.jsp">VOLVER</a>
	<br>
	<h1>Editar producto</h1>
    
    <form action="editar-producto?id=<%= request.getParameter("id") %>&nombre=<%= request.getParameter("nombre") %>" method="POST">

        <table>
            <tr>
                <td><label for="nombre" >Nombre: </label><input id="nombre" type="text" name="nombrenuevo" placeholder="<%= request.getParameter("nombre") %>"></td>
                <td><label for="id">Id: </label><input id="id" type="text" name="id" placeholder="<%= request.getParameter("id") %>" readonly></td>
            </tr>
            
            <tr>
                
                <td colspan="2"><input id="boton" type="submit" value="Actualizar producto"></td>
            </tr>
        </table>


    </form>
	
   

    
</body>
</html>