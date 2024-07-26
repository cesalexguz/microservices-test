package com.syntaxerror.demo.service;

import java.util.List;

import com.syntaxerror.demo.entity.Cliente;

public interface ClienteService {

	public List<Cliente> obtenerClientes() throws Exception;
	
	public Cliente obtenerClientePorId(int clienteId) throws Exception;
	
	public Cliente crearOActualizarCliente(Cliente cliente) throws Exception;
	
	public Cliente borrarCliente(int clienteId) throws Exception;
	
	public Cliente obtenerClientePorNombre(String nombre) throws Exception;
}
