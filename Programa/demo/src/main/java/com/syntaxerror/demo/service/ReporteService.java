package com.syntaxerror.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.syntaxerror.demo.entity.Reporte;

public interface ReporteService {

	public List<Reporte> generarReportePorCliente(LocalDate fecha1, LocalDate fecha2, String nombre) throws Exception;
}
