<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Productos" />
 
<jsp:param name="title" value="Lista productos" /> 
 
</jsp:include>


<div class="container pt-5">

		<jsp:include page="includes/alerta.jsp"></jsp:include>
     
        <h1 class="text-primary text-center mb-5">Lista de productos</h1>
        <p class="text-center mb-5">
          <a href="formulario-producto2.jsp" class="btn bg-primary text-white">Registrar nuevo producto</a>
       	  <a href="panel-administrador.jsp" class="btn bg-primary text-white">Ir al panel de control</a>
        </p>
		
		
        <table class="tabla table table-striped">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Precio</th>
                <th scope="col">Descuento</th>
                <th scope="col">Cantidad</th>
                <th scope="col">Imagen</th>
                <th scope="col">Eliminar</th>
                <th scope="col">Editar</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${productos}" var="p">
				<tr>
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td>${p.precio} €</td>
					<td>    -      </td>
					<td>    -      </td>
					<td>
						<img src="${p.foto}" alt="foto del producto">
					</td>
					<td>
						<a href="eliminar-prod?id=${p.id}">
							<i class="fas fa-trash"></i>
						</a>
					</td>
					<td>
						<a href="editar-prod?id=${p.id}">
							<i class="fas fa-edit"></i>
						</a>
					</td>
				</tr>
			  </c:forEach>
             
            </tbody>
          </table>
  
    </div>


<jsp:include page="includes/pie.jsp"/> 