<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Usuarios" />
 
<jsp:param name="title" value="Crear usuario" /> 
 
</jsp:include>

	<div class="container pt-5">
	    <h1 class="text-primary text-center mb-5">Registrar nuevo usuario</h1>
        <p class="text-center mb-5">
           <a href="lista-usuarios" class="btn bg-primary text-white">Ver todos los usuarios</a>
          <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
        </p>
		
		<p>${mensaje}</p>
	   
	    <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Nombre</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
				<tr>
					<form action="crear-usu" method="post">
						<td>
							<input type="text" name="nombre" placeholder="Introduce el nombre del Usuario">
						</td> 
						<td>
							<input type="submit" value="Crear">
						</td>
					</form>
				</tr>
            </tbody>
         </table>
	    
	    
	</div>
	
<%@include file="includes/pie.jsp" %>