package com.syntaxerror.demo.service;

import java.util.List;

import com.syntaxerror.demo.entity.Movimiento;

public interface MovimientoService {

	public List<Movimiento> obtenerMovimientos() throws Exception;
	
	public Movimiento obtenerMovimientoPorId(int movimientoId) throws Exception;
	
	public Movimiento crearOActualizarMovimiento(Movimiento movimiento) throws Exception;
	
	public Movimiento borrarMovimiento(int movimientoId) throws Exception;
	
	public List<Movimiento> obtenerMovimientosPorNumeroCuenta(String numeroCuenta) throws Exception;;
	
}
