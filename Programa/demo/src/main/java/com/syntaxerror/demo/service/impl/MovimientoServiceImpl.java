package com.syntaxerror.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.demo.entity.Cuenta;
import com.syntaxerror.demo.entity.Movimiento;
import com.syntaxerror.demo.repository.CuentaRepository;
import com.syntaxerror.demo.repository.MovimientoRepository;
import com.syntaxerror.demo.service.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService {

	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	public List<Movimiento> obtenerMovimientos() throws Exception {
		List<Movimiento> movimientos = (List<Movimiento>) movimientoRepository.findAll();
		if(movimientos.isEmpty()) {
			throw new Exception("No existen movimientos registrados");
		}
		return movimientos;
	}

	@Override
	public Movimiento obtenerMovimientoPorId(int movimientoId) throws Exception {
		Movimiento movimiento = movimientoRepository.findById(movimientoId).orElse(null);
		if(movimiento == null) {
			throw new Exception("No se encontro un movimiento con ese id");
		}
		return movimiento;
	}

	@Override
	public Movimiento crearOActualizarMovimiento(Movimiento movimiento) throws Exception {
		try {
			Cuenta cuenta = cuentaRepository.findByNumeroCuenta(movimiento.getNumeroCuenta());
			if(cuenta != null) {
				if(movimiento.getTipoMovimiento().equals("D") && cuenta.getSaldoInicial() - Math.abs(movimiento.getValor()) < 0) {
					throw new Exception("No existe suficiente saldo en la cuenta para este movimiento");
				} else {
					if(movimiento.getTipoMovimiento().equals("D")) {
						movimiento.setSaldo(cuenta.getSaldoInicial() - Math.abs(movimiento.getValor()));
					} else if(movimiento.getTipoMovimiento().equals("C")) {
						movimiento.setSaldo(cuenta.getSaldoInicial() + Math.abs(movimiento.getValor()));
					} else {
						throw new Exception("Tipo de movimiento no valido");
					}
					cuenta.setSaldoDisponible(movimiento.getSaldo());
					movimientoRepository.save(movimiento);
					cuentaRepository.save(cuenta);
				}
				
			} else {
				throw new Exception("No existe la cuenta a la que se quiere realizar el movimiento o los datos estan incompletos");
			}
		}catch(Exception ex) {
			throw ex;
		}
		return movimiento;
	}

	@Override
	public Movimiento borrarMovimiento(int movimientoId) throws Exception {
		Movimiento movimientoBorrado = null;
		try {
			movimientoBorrado = movimientoRepository.findById(movimientoId).orElse(null);
			if(movimientoBorrado == null) {
				throw new Exception("Movimiento no encontrado");
			}else {
				movimientoRepository.deleteById(movimientoId);
			}
		}catch(Exception ex) {
			throw ex;
		}
		return movimientoBorrado;
	}

	@Override
	public List<Movimiento> obtenerMovimientosPorNumeroCuenta(String numeroCuenta) throws Exception {
		List<Movimiento> movimientos = (List<Movimiento>) movimientoRepository.findByNumeroCuenta(numeroCuenta);
		if(movimientos.isEmpty()) {
			throw new Exception("No existen movimientos registrados");
		}
		return movimientos;
	}
	
	
}
