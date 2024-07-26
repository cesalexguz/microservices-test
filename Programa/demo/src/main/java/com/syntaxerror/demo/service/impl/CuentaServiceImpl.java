package com.syntaxerror.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.demo.entity.Cuenta;
import com.syntaxerror.demo.repository.CuentaRepository;
import com.syntaxerror.demo.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	public List<Cuenta> obtenerCuentas() throws Exception {
		List<Cuenta> cuentas = (List<Cuenta>) cuentaRepository.findAll();
		if(cuentas.isEmpty()) {
			throw new Exception("No existen cuentas registradas");
		}
		return cuentas;
	}

	@Override
	public Cuenta obtenerCuentaPorId(int cuentaId) throws Exception {
		Cuenta cuenta = cuentaRepository.findById(cuentaId).orElse(null);
		if(cuenta == null) {
			throw new Exception("No se encontro una cuenta con ese id");
		}
		return cuenta;
	}

	@Override
	public Cuenta crearOActualizarCuenta(Cuenta cuenta) throws Exception {
		Cuenta cuentaCreada = null;
		try {
			cuentaCreada = cuentaRepository.save(cuenta);
			if(cuentaCreada == null) {
				throw new Exception("Fallo al crear o actualizar la cuenta");
			}
		}catch(Exception ex) {
			throw ex;
		}
		return cuentaCreada;
	}

	@Override
	public Cuenta borrarCuenta(int cuentaId) throws Exception {
		Cuenta cuentaBorrada = null;
		try {
			cuentaBorrada = cuentaRepository.findById(cuentaId).orElse(null);
			if(cuentaBorrada == null) {
				throw new Exception("Cuenta no encontrada");
			} else {
				cuentaRepository.deleteById(cuentaId);
			}
		}catch(Exception ex) {
			throw ex;
		}
		return cuentaBorrada;
	}

	@Override
	public Cuenta obtenerCuentaPorNumeroCuenta(String numeroCuenta) throws Exception {
		Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
		if(cuenta == null) {
			throw new Exception("No se encontro una cuenta con ese numero");
		}
		return cuenta;
	}

	@Override
	public List<Cuenta> obtenerCuentaPorClienteId(int clienteId) throws Exception {
		List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);
		if(cuentas.isEmpty()) {
			throw new Exception("No se encontro una cuenta con ese id de cliente");
		}
		return cuentas;
	}
}
