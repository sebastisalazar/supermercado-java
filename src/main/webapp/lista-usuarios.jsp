<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Usuarios" />
 
<jsp:param name="title" value="Lista usuarios" /> 
 
</jsp:include>


<div class="container pt-5">
     
     	<!-- Importa el jsp alerta que contiene los mensajes para las interacciones -->
     	<jsp:include page="includes/alerta.jsp"></jsp:include>
     	
        <h1 class="text-primary text-center mb-5">Lista de Usuarios</h1>
        
        <!-- Opciones extras -->
        <p class="text-center mb-5">
          <a href="crear-usu" class="btn bg-primary text-white">Registrar nuevo usuario</a>
          <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
        </p>
		
		<!-- Tabla con datos -->
        <table class="tabla table table-striped">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Contraseña</th>
                <th scope="col">Rol</th>
                <th scope="col">Eliminar</th>
                <th scope="col">Editar</th>
              </tr>
            </thead>
            <tbody>
            
            	<!-- Recoge el array usuarios y lo recorre -->
              <c:forEach items="${usuarios}" var="u">
              
              	<!-- Por cada uno pinta una fila con 6 columnas -->
				<tr>
					<td>${u.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${u.nombre}</td>
					<td>${u.contrasenia}</td>
					<td>
						 ${u.id_rol.nombre}
								
					</td>
					<td>
						<a onclick="confirm('¿ Deseas borrar el usuario ${u.nombre}?')" href="eliminar-usu?id=${u.id}">
							<i class="fas fa-trash text-danger"></i>
						</a>
					</td>
					<td>
						<a href="editar-usu?id=${u.id}">
							<i class="fas fa-edit"></i>
						</a>
					
					</td>
				</tr>
			  </c:forEach>
			  
             
            </tbody>
         </table>
  
</div>

<jsp:include page="includes/pie.jsp"/> 