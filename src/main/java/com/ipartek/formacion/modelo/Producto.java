
package com.ipartek.formacion.modelo;

public class Producto {

	private int id;
	private String nombre;
	private String foto;
	private float precio;
	
	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
		this.foto="";
		this.precio=0;
	}

	public Producto(String nombre) {
		this();
		this.nombre = nombre;
		this.id = 0;
		this.foto="";
		this.precio=0;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", precio=" + precio + "]";
	}

	
	
}
