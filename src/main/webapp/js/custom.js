
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
		
		//consigo el hash mediante la libreria incluida en el pie.jsp
		var hash = md5(contrasenia);
		
		
		//guardo en el inpput el codigo hash
		document.getElementById('password').value = hash;		
		
		//enviar formulario
		return true; // si ponemos false no se envia el formulario
		
}

function descifrar() {
	
	console.log('cifrar y conseguir hash');
	
	//recupero la contraseña del input a atves de su ID
	var contrasenia = document.getElementById('password').value;
	
	//consigo el hash mediante la libreria incluida en el pie.jsp
	var hash = md5(contrasenia);
	
	
	//guardo en el inpput el codigo hash
	document.getElementById('password').value = hash;		
	
	//enviar formulario
	return true; // si ponemos false no se envia el formulario
	
}

