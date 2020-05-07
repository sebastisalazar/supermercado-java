package com.ipartek.formacion.ejercicios.bbdd;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAO;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Poder ver todos los alumnos, crear nuevos, eliminar, editar y buscar por
 * nombre
 * 
 * @author javaee
 *
 */
public class GestionUsuarios {

	static UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean seguir=true;
		int option=0;
		do {//bucle para repetir el menu hasta que el usuario salga
		
			menu();//imprimir menu
			
			do {//bucle para que se elija una opcion correcta
				System.out.print("\nElige una opcion: ");
				try {//control de excepcion en caso que se introduzca una letra
					option= Integer.parseInt(sc.nextLine());
					seguir=false;
				} catch (Exception NumberFormatException) {
					System.out.println("Error, has introducido una letra en lugar de un numero\n");
				}
			} while (seguir);
			
			seguir=true;//se vuelve a inicilizar para que no coja el ultimo valor
			
			if (option>7 || option<0) {//verifica si la opcion esta en el menu
				System.out.println("\nError, opcion no reconocida");
			}else {
				switch (option) {//lanza las opciones
				case 1:
					System.out.println("\n********************************");
					System.out.println(" LISTA COMPLETA DE USUARIOS\n");
					listarTodos();
					break;
				case 2:
					System.out.println("\n********************************");
					System.out.println(" BUSCAR POR ID\n");
					buscarPorID();
					break;
				case 3:
					System.out.println("\n********************************");
					System.out.println(" BUSCAR POR NOMBRE\n");
					buscarPorNombre();
					break;
				case 4:
					System.out.println("\n********************************");
					System.out.println(" MODIFICAR USUARIO POR ID\n");
					modificarUsuario();
					break;
				case 5:
					System.out.println("\n********************************");
					System.out.println(" CREAR POR ID\n");
					crearUsuario();
					break;
				case 6:
					System.out.println("\n********************************");
					System.out.println(" BORRAR POR ID\n");
					borrarPorID();
					break;
				case 7:
					seguir=false;//iniciliza a false para salir romper el bucle y salir
					System.out.println("\n********************************");
					System.out.println("\n\tFIN");
					sc.close();
				
				}//fin switch
			}//fin if
			
			
		} while (seguir);
		
		

	}

	static void menu() {
		System.out.println("\n********************************");
		System.out.println("\n\tMENU\n");
		System.out.println("1- Listar todos los usuarios");
		System.out.println("2- Buscar por ID");
		System.out.println("3- Buscar por Nombre");
		System.out.println("4. Modificar usuario por ID");
		System.out.println("5. Crear Usuario");
		System.out.println("6. Eliminar usuario por ID");
		System.out.println("7- Salir");
		
	}
	/**
	 * Lista todos los usuarios
	 */
	static void listarTodos() {
		try {
			ArrayList<Usuario> ListaTodos = new ArrayList<Usuario>();
			ListaTodos = dao.getAll();

			for (Usuario usuario : ListaTodos) {
				System.out.println(usuario);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * Lista por ID
	 */
	static void buscarPorID() {
		Usuario u = new Usuario();
		boolean seguir=true;
		do {
			try {

				System.out.print("Indica el id de usuario a buscar:");
				int id = Integer.parseInt(sc.nextLine());
				u = dao.getById(id);
				System.out.println("\n**************************");
				System.out.println(" LISTA DE USUARIOS CON ID " + id + "\n");
				System.out.println(u.toString());
				seguir=false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (seguir);
		
	}

	/**
	 * Borra usuario por ID
	 */
	static void borrarPorID() {
		Usuario u = new Usuario();
		boolean seguir=true;
		int id=0;
			do {
				
				try {
					System.out.print("Indica el id de usuario a borrar:");
					
					try {
						id = Integer.parseInt(sc.nextLine());
					} catch (Exception NumberFormatException) {
						throw new Exception ("Error, has introducido una letra en lugar de un numero\n");
					}
					
					u = dao.delete(id);
					System.out.println("\n**************************");
					System.out.println(" MOSTRANDO EL USUARIO BORRADO CON ID " + id + "\n");
					System.out.println(u.toString());
					seguir=false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}//fin try
				
			} while (seguir);

	}

	/**
	 * Crea un usuario nuevo
	 */
	static void crearUsuario() {
		Usuario u = new Usuario();
		boolean seguir=true;
		do {//bucle para que se introduzca un nombre valido(que no exista en la bbdd)
			try {
				System.out.print("\nIntroduce el nombre del usuario: ");
				String nombreusu = sc.nextLine();
				u.setNombre(nombreusu);
				u = dao.insert(u);

				System.out.print("\nUsuario registrado con exito, los datos son los suiguientes: ");
				System.out.println("\n\n"+u);
				seguir=false;

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (seguir);
		
	}
	
	/**
	 * Modifica un usuario
	 */
	static void modificarUsuario() {
		
		Usuario u1= new Usuario();
		boolean seguir=true;
		int id=0;
		do {//bucle para que se introduzca un id valido
			try {
				System.out.print("\nIntroduce el id del usuario a modificar: ");
				try {
					id= Integer.parseInt(sc.nextLine());
					
				} catch (Exception NumberFormatException) {
					throw new Exception ("Error, has introducido una letra en lugar de un numero");
				}
				
				u1=dao.getById(id);
				
				
				//hago una copia para enseñar los datos para enseñar el cambio que se ha hecho
				Usuario u2= u1;
				
				System.out.print("\n\nIntroduce el nuevo nombre: ");
				String nuevonombre=sc.nextLine();
				u1.setNombre(nuevonombre);
				u1=dao.update(u1);
				System.out.println("El usuario se ha modificado correctamente");
				System.out.println("\n Datos antiguos: "+u1);
				System.out.println("\n Datos nuevos: "+u2);
				seguir=false;
				
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (seguir);
		
	}

	/**
	 * Buscar por Nombre
	 */
	static void buscarPorNombre() {
		ArrayList<Usuario> registrosNombres= new ArrayList<Usuario>();

		try {

			System.out.print("Indica el nombre de usuario a buscar:");
			String nombre= sc.nextLine();
			registrosNombres= dao.getAllByNombre(nombre);
			System.out.println("\n**************************");
			System.out.println(" LISTA DE USUARIOS CON NOMBRES \"" + nombre + "\"\n");
			
			for (Usuario usuario : registrosNombres) {
				System.out.println(usuario.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
