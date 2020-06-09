<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<jsp:include page="includes/cabecera.jsp" >
 
<jsp:param name="pagina" value="Administrador" />
 
<jsp:param name="title" value="Administrador" /> 
 
</jsp:include>

<div class="container pb-4">
            
            <div class="container d-flex justify-content-center my-2 pb-4">
                
                <div class=" mt-5">
                    <jsp:include page="includes/alerta.jsp"></jsp:include>
                    <!--Formulario login-->
                    <form class="mt-5" action="login" method="POST" onsubmit="cifrar()">
                        <h1 class="text-primary text-center pt-20">Portal del Administrador</h1>
                        
                        
                        
                        <c:if test="${not empty cookie['cUltimaVisita']}">
                        	<p class="text-center">Ultima visita <span class="font-weight-bold">${cookie['cUltimaVisita'].value}</span></p>
                        </c:if>
                        
                        <div class="form-group mt-5">
	                        <label for="email">Email</label>
	                        <input type="email" name="email" class="form-control" id="email" aria-describedby="emailHelp" value="${ cookie['cEmail'].value }" required>
                        </div>
                        
                        <div class="form-group">
	                        <label for="password">Password</label>
	                        <input type="password" name="password" class="form-control" id="password" value="${ cookie['cPassword'].value }" required>
	                        <input type="hidden" name="passwordCifrar" class="form-control" id="passwordCifrar" value="">
                        </div>
                        
                        <div class="form-group">
	                        <label for="exampleInputPassword3">Idioma</label>
                       		<select name="idioma" id="idioma">
							  <option value="ES" ${ ( 'ES' eq cookie['cIdioma'].value ) ? 'selected' : '' }>Español</option>
							  <option value="EN" ${ ( 'EN' eq cookie['cIdioma'].value ) ? 'selected' : '' }>Ingles</option>
							  <option value="EU" ${ ( 'EU' eq cookie['cIdioma'].value ) ? 'selected' : '' }>Euskera</option>
							</select>
                       
                       
                        </div>
                        
                        <div class="form-group form-check">
	                        <input type="checkbox" name="recuerdame" class="form-check-input" ${ (not empty cookie['cEmail'].value) ? "checked" : ""  } id="exampleCheck1">
	                        <label class="form-check-label" for="exampleCheck1" >Recordar Contraseña</label>
                        </div>
                        
                        <button type="submit" class="btn btn-primary">Entrar</button>
                    </form>
                </div>
                

            </div>
        
        </div>

<jsp:include page="includes/pie.jsp"/> 