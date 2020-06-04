
 // ejecuta la funcion cuando todo el documento de html DOM este listo y cargado
$(document).ready(function() {
    // seleccion por id => #example y ejecuta el plugin .DataTable();
    $('.tabla').DataTable();
    
});

function init() {
	console.log('Documento cargado y listo');
	
}


function cifrar() {
		
		console.log('cifrar y conseguir hash');
		
		//recupero la contraseña del input a atves de su ID
		var contrasenia = document.getElementById('password').value;
		
		//creo una copia de la variable anterior para poder operar con ella
		var contraseniaCifrada= contrasenia;
		
		//consigo el hash mediante la libreria incluida en el pie.jsp
		var hash = md5( contraseniaCifrada);
		
		
		//guardo en el inpput el codigo hash en el input escondido (hidden)
		document.getElementById('passwordCifrar').value = hash;
		
		
		//enviar formulario
		return true; // si ponemos false no se envia el formulario
		
}

function Updatecifrar() {
	
	console.log('cifrar y conseguir hash');
	
	//recupero la contraseña del input a atves de su ID
	var contrasenia1 = document.getElementById('password1').value;
	
	//si la variable contiene algo (si se ha escrito el campo)
	if (contrasenia1) {
		//consigo el hash mediante la libreria incluida en el pie.jsp
		var hash1 = md5(contrasenia1);
		//guardo en el inpput el codigo hash
		document.getElementById('password1').value = hash1
	}
	
	
	//recupero la contraseña del input a atves de su ID
	var contrasenia2 = document.getElementById('password2').value;
	
	//consigo el hash mediante la libreria incluida en el pie.jsp
	if (contrasenia2) {
		//consigo el hash mediante la libreria incluida en el pie.jsp
		var hash2 = md5(contrasenia2);
		//guardo en el inpput el codigo hash
		document.getElementById('password2').value = hash2;
	}
	
	
	//enviar formulario
	return true; // si ponemos false no se envia el formulario
	
}

function Iguales(){
    var clave1 = document.getElementById('password1').value;
    var clave2 = document.getElementById('password2').value;
    
    
    
    if (clave2) {
    	if (clave1 != clave2){
        	
        	$("#mensaje").removeAttr("style");
        	$("#formularioUpdate").removeAttr("action");
        	$("#password1").attr( "style", "background-color: rgba(255,0,0,0.2)" );
        	$("#password2").attr( "style", "background-color: rgba(255,0,0,0.2)" );
        	
        }else{
        	
        	
        	
        	$("#password1").removeAttr("style");
        	$("#password2").removeAttr("style");
        	
        	$("#password1").attr( "style", "background-color: rgba(0,153,51,0.2)" );
        	$("#password2").attr( "style", "background-color: rgba(0,153,51,0.2)" );
        	
        	
        	$("#mensaje").attr( "style", "visibility:hidden" );
        	$( "#formularioUpdate" ).attr( "action", "editar-usu" );
        }
	}else{
		$("#password1").removeAttr("style");
    	$("#password2").removeAttr("style");
		$("#mensaje").attr( "style", "visibility:hidden" );
    	$( "#formularioUpdate" ).attr( "action", "editar-usu" );
	}
    
    
} 


