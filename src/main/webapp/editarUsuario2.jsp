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
    		
    		<!-- Si existen campos requeridos los pinta -->
    		<c:if test="${not empty requeridos}">
	    		<c:forEach items="${requeridos}" var="r">
	    			<p class="text-center text-danger">${r}</p>
	    		</c:forEach>
	    		<!-- Una vez pintado borra los mensajes -->
	    		<%session.setAttribute("requeridos", null); %>
	    	</c:if>
      
			<form id="formularioUpdate" action="editar-usu" method="POST" onsubmit="Updatecifrar()" >
				<table class="tabla table ">
					<thead>
						<th scope="col">ID</th>
						<th scope="col">Contrasenia</th>
					</thead>
					
				  	<tbody>
						
						<tr >				
							<td>
								<input class="text-center" id="id" type="text" name="id" value="${usuario.id}" readonly>
							</td>
							<td rowspan="5">
								
								<label for="contraeniaactual">Contraseña actual: </label>
								<input class="text-center" id="contraseniaactual" type="password" name="contraseniaactual" value="${usuario.contrasenia}" readonly>
							
									<div class="accordion" id="accordionExample">
										  <div class="card caja-contrasenia">
										    <div class="card-header btn-contrasenia" id="headingOne">
										      <h2 class="mb-0">
										        <button class="btn btn-link btn-block text-center collapsed" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
										          Cambiar contraseña
										        </button>
										      </h2>
										    </div>
										
										    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
										      <div class="card-body">
										      	
										         <label for="password1">Escribe la nueva contraseña: </label><input class="text-center" id="password1" type="password" name="password1" oninput="Iguales()" >
										     	 <br> <br>
										     	 <label for="password2">Rescribe la nueva contraseña: </label><input class="text-center" id="password2" type="password" name="password2" oninput="Iguales()" >
										      	  <input class="text-center" id="password1copia" type="hidden" name="password1copia">
										      	  <input class="text-center" id="password2copia" type="hidden" name="password2copia">
										      	  <small id="mensaje" class="text-danger d-block" style="visibility:hidden">Las contraseñas no coinciden</small>
										      </div>
										    </div>
										  </div>
										 
									</div>
							</td>
						</tr>
						
						<tr>
							<th scope="col">Nombre</th>
						</tr>
						<tr>
							<td>
								<input class="text-center" id="nombre" type="text" name="nombre" placeholder="${usuario.nombre}" value="${usuario.nombre}">
							</td>
							
						</tr>
						
										
						<tr>
							<th scope="col">Rol de usuario</th>
						</tr>
						
						<tr>
							<td>
								<select class="text-center" name="id_rol" id="id_rol">
								  <option value="1" ${ ( '1' eq usuario.id_rol.id ) ? 'selected' : '' }>Usuario</option>
								  <option value="2" ${ ( '2' eq usuario.id_rol.id) ? 'selected' : '' }>Administrador</option>
								</select>
							</td>
							
						</tr>
						
						
						
											
						<tr>
							<td colspan="2"><input id="actualizarUsuario" class="btn btn-primary" id="boton" type="submit" value="Actualizar usuario" ></td>
						</tr>
								

					</tbody>
				</table>
			</form>	
		</div>
    
    
</div> 
<jsp:include page="includes/pie.jsp"/>