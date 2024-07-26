package com.syntaxerror.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente extends Persona {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cliente_id")
    private int clienteId;
	
	@Column(nullable = false, length = 100)
	private String contrasena;
	
	@Column
    private boolean estado;

	public Cliente() {
		super();
	}

	public Cliente(String identificacion, String nombre, String genero, int edad, String direccion,
			String telefono, int clienteId, String contrasena, boolean estado) {
		super(identificacion, nombre, genero, edad, direccion, telefono);
		this.clienteId = clienteId;
		this.contrasena = contrasena;
		this.estado = estado;
	}

	public Cliente(int clienteId, String contrasena, boolean estado) {
		super();
		this.clienteId = clienteId;
		this.contrasena = contrasena;
		this.estado = estado;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cliente [identificacion=" + identificacion + 
				", nombre=" + nombre + ", genero=" + genero + ", edad=" + edad + 
				", direccion=" + direccion + ", telefono=" + telefono + 
				", clienteId=" + clienteId + ", contrasena=" + contrasena + 
				", estado=" + estado + "]";
	}

}
