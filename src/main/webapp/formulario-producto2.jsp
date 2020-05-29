<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Productos" />
 
<jsp:param name="title" value="Crear producto" /> 
 
</jsp:include>

	<div class="container pt-5">
	
		<jsp:include page="includes/alerta.jsp"></jsp:include>
		
	    <h1 class="text-primary text-center mb-5">Registrar nuevo producto</h1>
        <p class="text-center mb-5">
          <a href="lista-productos" class="btn bg-primary text-white">Ver todos los productos</a>
          <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
        </p>
		
		<p>${mensaje}</p>
	    
	    
	    <div class="container">   
			<form action="crear-prod" method="POST">
				<table class="tabla table">
					<thead>
						<th scope="col">Nombre</th>
						<th scope="col">Imagen del producto</th>
					</thead>
					
				  	<tbody>
						
						<tr>				
							<td>
								<input class="text-center" id="nombre" type="text" name="nombre" placeholder="Nombre del producto">
							</td>
							<td rowspan="3">
								
								<input id="foto" type="file" name="foto" >
							
							</td>
						</tr>
						
										
						<tr>
							<th scope="col">Precio</th>
						</tr>
						<tr>
							<td>
								<input class="text-center" id="precio" type="number" step="any" name="precio" placeholder="€">
							</td>
						</tr>
											
						<tr>
							<td colspan="5"><input class="btn btn-primary" id="boton" type="submit" value="Crear producto"></td>
						</tr>
								

					</tbody>
				</table>
			</form>	
		</div>
	    
	    
	</div>
	
<jsp:include page="includes/pie.jsp"/> 