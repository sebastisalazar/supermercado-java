
 // ejecuta la funcion cuando todo el documento de html DOM este listo y cargado
$(document).ready(function() {
    // seleccion por id => #example y ejecuta el plugin .DataTable();
    $('.tabla').DataTable();
    
});

function init() {
	console.log('Documento cargado y listo');
	
}

function confirmar(nombre) {
	
	// The confirm() method returns true if the user clicked "OK", and false otherwise. 
	if ( confirm('¿ Estas seguro que quires eliminar ' + nombre + ' ?') ){
		
		console.debug(' continua el evento por defceto del ancla ');
		
	}else {
		console.debug(' prevenimos o detenemos el evento del ancla ');
		event.preventDefault();
	}
	
}

//Cifrar contraseña de usuario al LOGEARSE
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

function CrearCifrar() {
	
	console.log('cifrar y conseguir hash');
	
	//recupero la contraseña del input a atves de su ID
	var contrasenia = document.getElementById('password').value;
	
	//consigo el hash mediante la libreria incluida en el pie.jsp
	var hash = md5( contrasenia);
	
	if (contrasenia) {
		//guardo en el inpput el codigo hash en el input escondido (hidden)
		document.getElementById('password2').value = contrasenia;
		//guardo en el inpput el codigo hash en el input escondido (hidden)
		document.getElementById('password').value = hash;
	}
	
	
	
	//enviar formulario
	return true; // si ponemos false no se envia el formulario
	
}



//cifrar nueva password al editar un usuario
function Updatecifrar() {
	
	console.log('cifrar y conseguir hash');
	
	//recupero la contraseña del input a atves de su ID
	var contrasenia1 = document.getElementById('password1').value;
	//recupero la contraseña del input a atves de su ID
	var contrasenia2 = document.getElementById('password2').value;
	
	//si la variable contiene algo (si se ha escrito el campo)
	if (contrasenia1 && contrasenia2) {
		
		
		//consigo el hash mediante la libreria incluida en el pie.jsp
		var hash1 = md5(contrasenia1);
		//consigo el hash mediante la libreria incluida en el pie.jsp
		var hash2 = md5(contrasenia2);
		//guardo en el inpput el codigo hash
		document.getElementById('password1').value = hash1
		//guardo en el inpput el codigo hash
		document.getElementById('password2').value = hash2;
	}
	
	
	
	//enviar formulario
	return true; // si ponemos false no se envia el formulario
	
}


//function para editar password de un usuario existente
var correcto=true;

function Iguales(){
	
	//guarda el dato de los campos password 1 y 2
    var clave1 = document.getElementById('password1').value;
    var clave2 = document.getElementById('password2').value;
    
    //si se rellena el campo password1 se obliga a que el segundo sea requerido
    if (clave1) {
    	$("#password2").attr( "required","true");
    	
    	
	}else{
		//si no se ha escrito nada se quita el required
		$("#password2").removeAttr( "required");

		//si el campo esta vacio se da por correcto
		correcto=true;
	}
    
    
    
    //comprobamos si al menos se ha rellenado el segundo campo
    if (clave2) {
    	
    	//se evalua si los datos NO son iguales
    	if (clave1 != clave2){
        	
    		//se pinta el mensaje quitando el style
        	$("#mensaje").removeAttr("style");
        	
        	//se pinta en color los campos que no coincidan
        	$("#password1").attr( "style", "background-color: rgba(255,0,0,0.2)" );
        	$("#password2").attr( "style", "background-color: rgba(255,0,0,0.2)" );
        	
        	//si los campos no son iguales se avisa que no es correcto
        	correcto=false;
        	
        	
        	//si son iguales
        }else{
        	
        	//se quita el color rojo a ambos campos
        	$("#password1").removeAttr("style");
        	$("#password2").removeAttr("style");
        	
        	//se vuelve a pintar en verde para mostrar que ahora si coinciden
        	$("#password1").attr( "style", "background-color: rgba(0,153,51,0.2)" );
        	$("#password2").attr( "style", "background-color: rgba(0,153,51,0.2)" );
        	
        	//Se oculta el mensaje
        	$("#mensaje").attr( "style", "visibility:hidden" );
        	
        	//si los campos coinciden se da por correcto
        	correcto=true;
        	
        }
    	
    	
    	//si no se ha rellenado el segundo campo o si esta vacio
	}else{
		
		
		//se quita el color rojo a ambos campos
		$("#password1").removeAttr("style");
    	$("#password2").removeAttr("style");
    	
    	//Se oculta el mensaje
		$("#mensaje").attr( "style", "visibility:hidden" );
		
		//si el campo esta vacio se da por correcto
		correcto=true;
		
	}
    
    
   
    
    
} 




