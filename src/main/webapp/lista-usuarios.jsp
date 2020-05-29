<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Usuarios" />
 
<jsp:param name="title" value="Usuarios" /> 
 
</jsp:include>


<div class="container pt-5">
     
     	<jsp:include page="includes/alerta.jsp"></jsp:include>
        <h1 class="text-primary text-center mb-5">Lista de Usuarios</h1>
        <p class="text-center mb-5">
          <a href="formulario-usuario2.jsp" class="btn bg-primary text-white">Registrar nuevo usuario</a>
          <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
        </p>
		
		
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
              <c:forEach items="${usuarios}" var="u">
				<tr>
					<td>${u.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${u.nombre}</td>
					<td>${u.contrasenia}</td>
					<td>
						 ${ ( '1' eq u.id_rol ) ? 'Usuario' : '' }
						 ${ ( '2' eq u.id_rol ) ? 'Administrador' : '' }
								
					</td>
					<td>
						<a href="eliminar-usu?id=${u.id}">
							<i class="fas fa-trash"></i>
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