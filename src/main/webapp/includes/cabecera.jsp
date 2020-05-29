<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    
    <!-- datatables -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

    <!-- Estilos para la cabecera-->
    <link rel="stylesheet" type="text/css" href="css/nav.css">
    
    <!-- Estilos para el footer-->
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    
    <!-- Estilio inicio -->
    <link rel="stylesheet" type="text/css" href="css/index2.css">
    
    <!-- Estilio para el curriculum -->
    <link rel="stylesheet" type="text/css" href="css/curriculum2.css">
    
    <!-- Estilio para la CARD de INICIO -->
    <link rel="stylesheet" type="text/css" href="css/productos.css">

	<!-- Estilio para el formulario completado -->
    <link rel="stylesheet" href="css/formulario-resumen2.css">
    
    <!-- Estilio para tablas -->
    <link rel="stylesheet" href="css/tabla.css">
    
    <title>${param.title} | Supermercado</title>
  </head>
  <body>
    <header class="mb-5">
        <!---Barra de navegacion-->

        <nav class="navbar navbar-expand-md navbar-dark fixed-top pl-5 pr-5">

          <a class="navbar-brand" href="index.jsp"><img src="img/logoEmpresa.gif" alt="logo"></a>

          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item ${ ( 'Inicio' eq param.pagina ) ? 'active' : '' } ">
                <a class="nav-link" href="index.jsp">Inicio</a>
              </li>
            
              <li class="nav-item ${ ( 'Productos' eq param.pagina ) ? 'active' : '' } }">
                <a class="nav-link" href="lista-productos" tabindex="-1" aria-disabled="true">Productos</a>
              </li>
              
              <li class="nav-item ${ ( 'Usuarios' eq param.pagina ) ? 'active' : '' } }">
                <a class="nav-link" href="lista-usuarios" tabindex="-1" aria-disabled="true">Usuarios</a>
              </li>
              
              <li class="nav-item ${ ( 'Administrador' eq param.pagina ) ? 'active' : '' } }">
                <a class="nav-link" href="login.jsp" tabindex="-1" aria-disabled="true">Administrador</a>
              </li>
            </ul>
            <form class="form-inline mt-2 mt-md-0">
              <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-light bg-success my-2 my-sm-0" type="submit">Search</button>
            </form>
          </div>
        </nav>
    </header>

   
    <main role="main" class="container">
    	
    	