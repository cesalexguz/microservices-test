package com.syntaxerror.demo.service;

import java.util.List;

import com.syntaxerror.demo.entity.Cuenta;

public interface CuentaService {

	public List<Cuenta> obtenerCuentas() throws Exception;
	
	public Cuenta obtenerCuentaPorId(int cuentaId) throws Exception;
	
	public Cuenta crearOActualizarCuenta(Cuenta cuenta) throws Exception;
	
	public Cuenta borrarCuenta(int cuentaId) throws Exception;
	
	public Cuenta obtenerCuentaPorNumeroCuenta(String numeroCuenta) throws Exception;
	
	public List<Cuenta> obtenerCuentaPorClienteId(int clienteId) throws Exception;
	
}
