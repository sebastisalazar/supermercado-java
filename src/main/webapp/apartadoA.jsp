<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>Apartado A</title>
  </head>
  <body>
    
    <main role="main">
			<div class="container mt-5 pt-5 px-5">
		
				<div class="container d-flex justify-content-center my-5 pb-4">
				
					<form action="apartado-a" method="POST">
						
						<h1>Apartado A</h1>
						<div class="form-group">
						  <label for="nombre">Nombre / Usuario</label>
						  <input type="text" class="form-control" id="nombre" name="nombre" placheholder="Introduce tu nombre">
						</div>
			
						<div class="form-group">
						  <label for="colorFavorito">Color Favorito</label>
						  <select id="colorFavorito" name="colorFavorito">
							<option value="rojo">Rojo</option> 
							<option value="verde">Verde</option>
							<option value="azul">Azul</option>
						  </select>
						</div>
						
						<button type="submit" class="btn btn-primary">Guardar</button>
						
					</form>
					
				</div>
				
				
			</div>
			
		</main>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>