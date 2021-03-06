<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


 
<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Usuarios" />
 
<jsp:param name="title" value="Crear usuario" /> 
 
</jsp:include>


<div class="container pt-5">
		<jsp:include page="includes/alerta.jsp"></jsp:include>
		
	    <h1 class="text-primary text-center mb-5">Registrar nuevo usuario</h1>
        <p class="text-center mb-5">
           <a href="lista-usuarios" class="btn bg-primary text-white">Ver todos los usuarios</a>
          <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
        </p>
		
		
	    <div class="container">
	    
	    	<c:if test="${not empty requeridos}">
	    		<c:forEach items="${requeridos}" var="r">
	    			<p class="text-center text-danger">${r}</p>
	    		</c:forEach>
	    	
	    	</c:if>
			<form action="crear-usu" method="POST" onsubmit="CrearCifrar()">
				<table class="tabla table ">
					<thead>
						<th scope="col">Nombre</th>
						<th scope="col">Tipo de usuario</th>
						
					</thead>
					
				  	<tbody>
						
						<tr>				
							<td>
								<input class="text-center" id="nombre" type="text" name="nombre" placeholder="Escribe el usuario" value="${nombreIntroducido}">
							</td>
							
							<td rowspan="3">
								
								<select class="text-center" name="id_rol" id="id_rol">
								  <option value="1" ${(idRolIntroducido==1)? 'selected':''} >Usuario</option>
								  <option value="2" ${(idRolIntroducido==2)? 'selected':''}>Administrador</option>
								</select>
							</td>
						</tr>
										
						<tr>
							<th scope="col">Contrasenia</th>
						</tr>
						<tr>
							
							<td>
								<input class="text-center" id="password" type="password" name="contraseniaCifrada" placeholder="Escribe la contraseña" value="${contraseniaIntroducida}">
								<input class="text-center" id="password2" type="hidden" name="contraseniaSinCifrar">
							
							</td>
							
						</tr>
											
						<tr>
							<td colspan="2"><input class="btn btn-primary" id="boton" type="submit" value="Crear usuario"></td>
						</tr>
						
						<c:if test="${not empty requeridos}">
							
							<%session.removeAttribute("requeridos"); %>
						
						</c:if>
							
					</tbody>
				</table>
			</form>	
		</div>
	    
	    
</div>
<jsp:include page="includes/pie.jsp"></jsp:include>	
