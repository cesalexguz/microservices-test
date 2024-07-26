package com.syntaxerror.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntaxerror.demo.entity.Reporte;
import com.syntaxerror.demo.error.ErrorMessage;
import com.syntaxerror.demo.service.ReporteService;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
	
	@Autowired
	private ReporteService reporteService;

	@GetMapping("/obtenerMovimientosPorFecha/{nombre}/{fecha1}/{fecha2}")
	public ResponseEntity<?> obtenerReportePorClientePorFechas(
			@PathVariable("nombre") String nombre,
			@PathVariable(value = "fecha1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha1, 
			@PathVariable(value = "fecha2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha2) throws Exception {
		List<Reporte> reportes = null;
		try {
			reportes = reporteService.generarReportePorCliente(fecha1, fecha2, nombre);
			return new ResponseEntity<List<Reporte>>(reportes, HttpStatus.OK);
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "No se pudo generar el reporte. Motivo: " + ex.getMessage());
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
		}	
	}
	
	

}
