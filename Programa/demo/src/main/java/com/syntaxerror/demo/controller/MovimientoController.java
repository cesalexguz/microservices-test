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

import com.syntaxerror.demo.entity.Movimiento;
import com.syntaxerror.demo.error.ErrorMessage;
import com.syntaxerror.demo.service.MovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

	@Autowired
	private MovimientoService movimientoService;
	
	@GetMapping("/obtenerMovimientos")
	public ResponseEntity<?> obtenerMovimientos() throws Exception {
		List<Movimiento> movimientos = null;
		try {
			movimientos = movimientoService.obtenerMovimientos();
			return new ResponseEntity<List<Movimiento>>(movimientos, HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "No se encontraron registros. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/obtenerMovimiento/{id}")
	public ResponseEntity<?> obtenerMovimientoPorId(@PathVariable("id") int movimientoId) throws Exception {
		Movimiento movimientos = null;
		try {
			movimientos = movimientoService.obtenerMovimientoPorId(movimientoId);
			return new ResponseEntity<Movimiento>(movimientos, HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Registro no encontrado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/crearOActualizar")
	public ResponseEntity<?> crearOActualizarMovimiento(@RequestBody Movimiento movimiento) throws Exception {
		Movimiento movimientos = null;
		try {
			movimientos = movimientoService.crearOActualizarMovimiento(movimiento);
			return new ResponseEntity<Movimiento>(movimientos, HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Registro no creado o actualizado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrarMovimiento(@PathVariable("id") int movimientoId) throws Exception {
		Movimiento movimientos = null;
		try {
			movimientos = movimientoService.borrarMovimiento(movimientoId);
			return new ResponseEntity<Movimiento>(movimientos,HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_MODIFIED, "Registro no eliminado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_MODIFIED);
		}
	}
	
	@GetMapping("/obtenerMovimientos/{numeroCuenta}")
	public ResponseEntity<?> obtenerMovimientoPorNumeroCuenta(@PathVariable("numeroCuenta") String numeroCuenta) throws Exception {
		List<Movimiento> movimientos = null;
		try {
			movimientos = movimientoService.obtenerMovimientosPorNumeroCuenta(numeroCuenta);
			return new ResponseEntity<List<Movimiento>>(movimientos, HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Registro no encontrado. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
		}
	}
}
