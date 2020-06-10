
<%@page import="com.ipartek.formacion.controller.Alerta"%>
<%@page import="javax.servlet.jsp.jstl.sql.ResultSupport"%>
<%@page import="com.mysql.fabric.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    
    <!-- Si el usuario NO esta logeado no podrá visitar las siguientes paginas-->
    <c:if test="${empty usuario_logeado}">
    	
    	
    	<c:choose>
         
	         <c:when test = "${'Panel de Control' eq param.title}">
	         	
	         	<% session.setAttribute("restringido",new Alerta("warning","Debes logearte para poder ver la pagina solicitada."));%>
	         	
	            <meta http-equiv="refresh" content="0; url=login.jsp">
	            
	         </c:when>
	         
	         <c:when test = "${'Lista productos' eq param.title}">
	         	
	         	<% session.setAttribute("restringido",new Alerta("warning","Debes logearte para poder ver la pagina solicitada."));%>
	            <meta http-equiv="refresh" content="0; url=login.jsp">
	         </c:when>
	         
	         <c:when test = "${'Lista usuarios' eq param.title}">
	         	<% session.setAttribute("restringido",new Alerta("warning","Debes logearte para poder ver la pagina solicitada."));%>
	            <meta http-equiv="refresh" content="0; url=login.jsp">
	         </c:when>
	         
	         <c:when test = "${'Crear producto' eq param.title}">
	         	<% session.setAttribute("restringido",new Alerta("warning","Debes logearte para poder ver la pagina solicitada."));%>
	            <meta http-equiv="refresh" content="0; url=login.jsp">
	         </c:when>
	         
	         <c:when test = "${'Crear usuario' eq param.title}">
	         	<% session.setAttribute("restringido",new Alerta("warning","Debes logearte para poder ver la pagina solicitada."));%>
	            <meta http-equiv="refresh" content="0; url=login.jsp">
	         </c:when>
	         	
	         <c:when test = "${'Productos' eq param.title}">
	         	<% session.setAttribute("restringido",new Alerta("warning","Debes logearte para poder ver la pagina solicitada."));%>
	            <meta http-equiv="refresh" content="0; url=login.jsp">
	         </c:when>
	         
	         <c:when test = "${'Usuarios' eq param.title}">
	         	<% session.setAttribute("restringido",new Alerta("warning","Debes logearte para poder ver la pagina solicitada."));%>
	            <meta http-equiv="refresh" content="0; url=login.jsp">
	         </c:when>
	         
	         
     	 </c:choose>
     	 
    
    </c:if>
    
    <!-- Si el usuario esta logeado no podrá visitar la pagina login -->
    <c:if test="${not empty usuario_logeado}">
    	
    	<c:if test = "${'Iniciar sesion' eq param.title}">
	        <meta http-equiv="refresh" content="0; url=panel-administrador.jsp">
	    </c:if>
	    
	   
    </c:if>
    
   

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"/>
    
    <!-- datatables -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"/>

    <!-- Estilos para la cabecera-->
    <link rel="stylesheet" type="text/css" href="css/nav.css"/>
    
    <!-- Estilos para el footer-->
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    
    <!-- Estilio inicio -->
    <link rel="stylesheet" type="text/css" href="css/index2.css"/>
    
    <!-- Estilio para el curriculum -->
    <link rel="stylesheet" type="text/css" href="css/curriculum2.css"/>
    
    <!-- Estilio para la CARD de INICIO -->
    <link rel="stylesheet" type="text/css" href="css/productos.css"/>

	<!-- Estilio para el formulario completado -->
    <link rel="stylesheet" href="css/formulario-resumen2.css" />
    
    <!-- Estilio para tablas -->
    <link rel="stylesheet" href="css/tabla.css" />
    
    <!-- Estilio para el menu -->
    <link rel="stylesheet" href="css/cabecera.css" />
    
    <title>${param.title} | Supermercado</title>
  </head>
  
  <body onload="init()">
    <header class="mb-5">
        <!---Barra de navegacion-->

        <nav class="navbar navbar-expand-md navbar-dark fixed-top pl-5 pr-5">

		 
		  <!-- Logo -->
          <a class="navbar-brand" href="index.jsp"><img src="img/logoEmpresa.gif" alt="logo"></a>

		  <!-- Boton para vistas moviles -->
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          
          <!-- Contenedor de opciones de la cabecera -->
          <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item text-center ${ ( 'Inicio' eq param.pagina ) ? 'active' : '' } ">
                <a class="nav-link text-white px-2 " href="index.jsp">Inicio</a>
              </li>
            
            	
            <!-- Oculta el menu si no hay usuarios logeados -->
	            <c:if test="${ not empty usuario_logeado }">
	            
	            	 <li class="nav-item text-center ${ ( 'PanelControl' eq param.pagina ) ? 'active' : '' } ">
		                <a class="nav-link text-white px-2 " href="panel-administrador.jsp">Panel Administrador</a>
		             </li>
		         </c:if>    
		             
		    <!-- Esta opcion la muestra exista o no un usuario logeado -->   
		        <div class="dropdown mr-1 ${ ( 'Ejemplos' eq param.pagina ) ? 'active' : '' }">
					    <button type="button" class="btn btn-primary dropdown-toggle itemMenu itemMenu-tooggle ${ ( 'Ejemplos' eq param.pagina ) ? 'active' : '' } " id="dropdownMenuOffset" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-offset="10,20">
					      Ejemplos
					    </button>
					    <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
					      <a class="dropdown-item text-white " href="getYpost2.jsp">Get y Post</a>
					      <a class="dropdown-item text-white" href="formulario2.jsp">Formulario CV</a>
					    </div>
				</div>
		         
		     <!-- Oculta el menu si no hay usuarios logeados -->    
		        <c:if test="${ not empty usuario_logeado }">    
	            	 <div class="dropdown mr-1 ${ ( 'Productos' eq param.pagina ) ? 'active' : '' }">
					    <button type="button" class="btn btn-primary dropdown-toggle itemMenu itemMenu-tooggle ${ ( 'Productos' eq param.pagina ) ? 'active' : '' } " id="dropdownMenuOffset" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-offset="10,20">
					      Productos
					    </button>
					    <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
					      <a class="dropdown-item text-white " href="lista-productos">Listar productos</a>
					      <a class="dropdown-item text-white " href="crear-prod">Registrar productos</a>
					    </div>
					 </div>
				 
					 <div class="dropdown mr-1 ${ ( 'Usuarios' eq param.pagina ) ? 'active' : '' }">
					    <button type="button" class="btn btn-primary dropdown-toggle itemMenu itemMenu-tooggle ${ ( 'Usuarios' eq param.pagina ) ? 'active' : '' } " id="dropdownMenuOffset" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-offset="10,20">
					      Usuarios
					    </button>
					    <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
					      <a class="dropdown-item text-white " href="lista-usuarios">Listar usuarios</a>
					      <a class="dropdown-item text-white" href="crear-usu">Registrar usuarios</a>
					    </div>
					 </div>
	            </c:if>
	           
            </ul>
            
            
            <!-- enseña el boton de logout o iniciar sesion si el usuario no esta logeado -->
         	<c:if test="${ empty usuario_logeado }">
         		<span class="form-inline">
            	  <a class="nav-link  btn btn-outline-success bg-success text-white" href="login.jsp">Iniciar Sesión</a>
            	</span>
            </c:if>	  
            
            <!-- Si el usuario se logea enseña su usuario + un boton para cerrar sesion -->
            <c:if test="${ not empty usuario_logeado }">
            	<span class="badge badge-pill badge-light "></span>
            		<a class="nav-link  btn btn-outline-success bg-success text-white" href="panel-administrador.jsp">${usuario_logeado}</a>
            	</span>
            	
            	<span class="badge badge-pill badge-light"></span>
            		<a class="nav-link  btn btn-outline-success bg-success text-white ml-3" href="logout">Cerrar Sesión</a>
            	</span>
            </c:if>
              
            
          </div>
        </nav>
    </header>

   
    <main role="main" class="container">
    	
		    	
		
		
    	