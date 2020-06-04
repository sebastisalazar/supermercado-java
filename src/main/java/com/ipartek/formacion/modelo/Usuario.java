package com.ipartek.formacion.modelo;

public class Usuario {
	
	private int id;
	private String nombre;
	private String contrasenia;
	private Rol id_rol;
	
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.id_rol=new Rol();;
		this.contrasenia="";
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Rol getId_rol() {
		return id_rol;
	}

	public void setId_rol(Rol id_rol) {
		this.id_rol = id_rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenia=" + contrasenia + ", id_rol=" + id_rol + "]";
	}

	
	

}
