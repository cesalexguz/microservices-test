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

import com.syntaxerror.demo.entity.Cuenta;
import com.syntaxerror.demo.error.ErrorMessage;
import com.syntaxerror.demo.service.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;
	
	@GetMapping("/obtenerCuentas")
	public ResponseEntity<?> obtenerCuentas() throws Exception {
		List<Cuenta> cuentas = null;
		try {
			cuentas = cuentaService.obtenerCuentas();
			return new ResponseEntity<List<Cuenta>>(cuentas,HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "No se encontraron registros. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/obtenerCuentaPorId/{id}")
	public ResponseEntity<?> obtenerCuentaPorId(@PathVariable("id") int cuentaId) throws Exception {
		Cuenta cuentas = null;
		try {
			cuentas = cuentaService.obtenerCuentaPorId(cuentaId);
			return new ResponseEntity<Cuenta>(cuentas,HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Registro no encontrado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/crearOActualizar")
	public ResponseEntity<?> crearOActualizarCuenta(@RequestBody Cuenta cuenta) throws Exception {
		Cuenta cuentas = null;
		try {
			cuentas = cuentaService.crearOActualizarCuenta(cuenta);
			return new ResponseEntity<Cuenta>(cuentas,HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Registro no creado o actualizado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrarCuenta(@PathVariable("id") int cuentaId) throws Exception {
		Cuenta cuentas = null;
		try {
			cuentas = cuentaService.borrarCuenta(cuentaId);
			return new ResponseEntity<Cuenta>(cuentas,HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_MODIFIED, "Registro no eliminado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_MODIFIED);
		}
	}
	
	@GetMapping("/obtenerCuentaPorNumero/{numeroCuenta}")
	public ResponseEntity<?> obtenerCuentaPorNumero(@PathVariable("numeroCuenta") String numeroCuenta) throws Exception {
		Cuenta cuentas = null;
		try {
			cuentas = cuentaService.obtenerCuentaPorNumeroCuenta(numeroCuenta);
			return new ResponseEntity<Cuenta>(cuentas,HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Registro no encontrado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/obtenerCuentaPorClienteId/{id}")
	public ResponseEntity<?> obtenerCuentaPorClienteId(@PathVariable("id") int clienteId) throws Exception {
		List<Cuenta> cuentas = null;
		try {
			cuentas = cuentaService.obtenerCuentaPorClienteId(clienteId);
			return new ResponseEntity<List<Cuenta>>(cuentas,HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Registro no encontrado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
		}
	}
	
}
