<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Productos" />
 
<jsp:param name="title" value="Productos" /> 
 
</jsp:include>

<div class="container pt-5">
    	<h1 class="text-primary text-center mb-5">Editar producto</h1>
        <p class="text-center mb-5">
          <a href="lista-productos" class="btn bg-primary text-white">Ver todos los productos</a>
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
	    	
	    	
			<form action="editar-prod" method="POST">
				<table class="tabla table">
					<thead>
					   
						<th scope="col">ID</th>
						<th scope="col">Imagen del producto</th>
					   
					</thead>
					
				  	<tbody>
						
						<tr>				
							<td>
								<input id="id" type="text" name="id" value="${producto.id}" readonly>
							</td>
							<td rowspan="3">
								<img class="fotoProd" src="${producto.foto}" alt="foto producto" placeholder="">
								<br><br>
								
							</td>
						</tr>
											
											
						<tr>
							<th scope="col">Nombre</th>
						</tr>
						<tr>
							<td>
								<input id="nombre" type="text" name="nombre" placeholder="${producto.nombre}" value="${nombre}">
							</td>
						</tr>
										
						<tr>
							<th scope="col">Precio</th>
							<th scope="col">Cambiar foto</th>
						</tr>
						<tr>
							<td>
								<input id="precio" type="text" name="precio" placeholder="${producto.precio}" value="${(precio!=0)?precio:''}">
							</td>
							<td>
								<input id="foto" type="file" name="foto" readonly>
							</td>
						</tr>
											
						<tr>
							<td colspan="5"><input class="btn btn-primary" id="boton" type="submit" value="Actualizar producto"></td>
						</tr>
								

					</tbody>
				</table>
			</form>	
		</div>
	</div>
</div>
<jsp:include page="includes/pie.jsp"/> 