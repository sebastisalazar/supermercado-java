<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Usuarios" />
 
<jsp:param name="title" value="Usuarios" /> 
 
</jsp:include>

<div class="container pt-5">
    <h1 class="text-primary text-center mb-5">Editar Usuario</h1>
        <p class="text-center mb-5">
          <a href="lista-usuarios" class="btn bg-primary text-white">Ver todos los usuarios</a>
          <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
    	</p>
    
    
    <div class="container">   
			<form action="editar-usu" method="POST" onsubmit="cifrar()">
				<table class="tabla table ">
					<thead>
						<th scope="col">ID</th>
						<th scope="col">Nombre</th>
					</thead>
					
				  	<tbody>
						
						<tr>				
							<td>
								<input class="text-center" id="id" type="text" name="id" value="${usuario.id}" readonly>
							</td>
							<td>
								<input class="text-center" id="nombre" type="text" name="nombre" value="${usuario.nombre}">
							</td>
						</tr>
										
						<tr>
							<th scope="col">Contrasenia</th>
							<th scope="col">Rol</th>
						</tr>
						
						
						
						
						<tr>
							<td>
								<input class="text-center" id="passwordantigua" type="password" name="contraseniaantigua" value="${usuario.contrasenia}" readonly>
							</td>
							
	
							<td rowspan="3">
								<select class="text-center" name="id_rol" id="id_rol">
								  <option value="1" ${ ( '1' eq usuario.id_rol ) ? 'selected' : '' }>Usuario</option>
								  <option value="2" ${ ( '2' eq usuario.id_rol ) ? 'selected' : '' }>Administrador</option>
								</select>
							</td>
						</tr>
						
						<tr >
							<th scope="col">Cambiar Contrasenia</th>
						</tr>
						
						<tr>
							<td>
								<input class="text-center" id="password" type="password" name="contrasenianueva"  placeholder="Introduce una contraseña nueva">
							</td>
						</tr>
											
						<tr>
							<td colspan="2"><input class="btn btn-primary" id="boton" type="submit" value="Actualizar usuario"></td>
						</tr>
								

					</tbody>
				</table>
			</form>	
		</div>
    
    
</div> 
<jsp:include page="includes/pie.jsp"/>