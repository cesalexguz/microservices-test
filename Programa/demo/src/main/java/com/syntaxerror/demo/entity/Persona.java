package com.syntaxerror.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona {
	
	@Column(nullable = false, length = 10)
	protected String identificacion;
	
	@Column(nullable = false, length = 75)
	protected String nombre;
	
	@Column(nullable = false, length = 1)
	protected String genero;
	
	@Column(nullable = false)
	protected int edad;
	
	@Column(nullable = false, length = 100)
	protected String direccion;
	
	@Column(nullable = false, length = 10)
	protected String telefono;

	public Persona() {
		super();
	}

	public Persona(String identificacion, String nombre, String genero, int edad, String direccion,
			String telefono) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [identificacion=" + identificacion + ", nombre=" + nombre + ", genero=" + genero
				+ ", edad=" + edad + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
}
