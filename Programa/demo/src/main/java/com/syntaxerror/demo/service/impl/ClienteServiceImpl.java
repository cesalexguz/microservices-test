package com.syntaxerror.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.demo.entity.Cliente;
import com.syntaxerror.demo.repository.ClienteRepository;
import com.syntaxerror.demo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> obtenerClientes() throws Exception {
		List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
		if(clientes.isEmpty()) {
			throw new Exception("No existen clientes registrados");
		}
		return clientes;
	}

	@Override
	public Cliente obtenerClientePorId(int clienteId) throws Exception {
		Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
		if(cliente == null) {
			throw new Exception("No se encontro un cliente con ese id");
		}
		return cliente;
	}

	@Override
	public Cliente crearOActualizarCliente(Cliente cliente) throws Exception {
		Cliente clienteCreado = null;
		try {
			clienteCreado = clienteRepository.save(cliente);
			if (cliente == null) {
				throw new Exception("Fallo al crear o actualizar el cliente");
			}
		} catch(Exception ex) {
			throw ex;
		}
		return clienteCreado;
	}

	@Override
	public Cliente borrarCliente(int clienteId) throws Exception {
		Cliente clienteBorrado = null;
		try {
			clienteBorrado = clienteRepository.findById(clienteId).orElse(null);
			if (clienteBorrado == null) {
				throw new Exception("Cliente no encontrado");
			} else {
				clienteRepository.deleteById(clienteId);
			}
		} catch(Exception ex) {
			throw ex;
		}
		return clienteBorrado;
	}

	@Override
	public Cliente obtenerClientePorNombre(String nombre) throws Exception {
		Cliente cliente = clienteRepository.findByName(nombre);
		if(cliente == null) {
			throw new Exception("No se encontro un cliente con ese nombre");
		}
		return cliente;
	}

}
