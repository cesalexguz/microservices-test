package com.syntaxerror.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntaxerror.demo.entity.Cliente;
import com.syntaxerror.demo.error.ErrorMessage;
import com.syntaxerror.demo.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/obtenerClientes")
	public ResponseEntity<?> obtenerClientes() throws Exception {
		List<Cliente> clientes = null;
		try {
			clientes = clienteService.obtenerClientes();
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "No se encontraron registros. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/obtenerCliente/{id}")
	public ResponseEntity<?> obtenerClientePorId(@PathVariable("id") int clienteId) throws Exception {
		Cliente clientes = null;
		try {
			clientes = clienteService.obtenerClientePorId(clienteId);
			return new ResponseEntity<Cliente>(clientes, HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Registro no encontrado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/crearOActualizar")
	public ResponseEntity<?> crearOActualizarCliente(@RequestBody Cliente cliente) throws Exception {
		Cliente clientes = null;
		try {
			clientes = clienteService.crearOActualizarCliente(cliente);
			return new ResponseEntity<Cliente>(clientes, HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Registro no creado o actualizado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrarCliente(@PathVariable("id") int clienteId) throws Exception {
		Cliente clientes = null;
		try {
			clientes = clienteService.borrarCliente(clienteId);
			return new ResponseEntity<Cliente>(clientes, HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_MODIFIED, "Registro no eliminado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_MODIFIED);
		}
	}
	
	@GetMapping("/obtenerClientePorNombre/{nombre}")
	public ResponseEntity<?> obtenerClientePorNombre(@PathVariable("nombre") String nombre) throws Exception {
		Cliente clientes = null;
		try {
			clientes = clienteService.obtenerClientePorNombre(nombre);
			return new ResponseEntity<Cliente>(clientes, HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Registro no encontrado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
		}
	}
}
