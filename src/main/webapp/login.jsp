<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! String title = "Login";  %>
<%@include file="includes/cabecera.jsp" %>

<div class="container pb-4">
            
            <div class="container d-flex justify-content-center my-2 pb-4">
                
                <div class="row row-cols mt-5">
                    
                    <!--Formulario login-->
                    <form class="mt-5" action="panel-administrador.jsp" method="POST">
                        <h1 class="text-primary text-center pt-20">Portal del Administrador</h1> 
                        <div class="form-group mt-5">
                        <label for="exampleInputEmail1">Email</label>
                        <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                       
                        </div>
                        <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" name="password" class="form-control" id="exampleInputPassword1" required>
                        </div>
                        <div class="form-group form-check">
                        <input type="checkbox" name="recordarcontra" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Recordar Contraseña</label>
                        </div>
                        <button type="submit" class="btn btn-primary">Entrar</button>
                    </form>
                </div>
                

            </div>
        
        </div>

<%@include file="includes/pie.jsp" %> 