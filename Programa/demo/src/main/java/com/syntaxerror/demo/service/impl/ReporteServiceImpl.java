package com.syntaxerror.demo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.demo.entity.Cliente;
import com.syntaxerror.demo.entity.Cuenta;
import com.syntaxerror.demo.entity.Movimiento;
import com.syntaxerror.demo.entity.Reporte;
import com.syntaxerror.demo.repository.ClienteRepository;
import com.syntaxerror.demo.repository.CuentaRepository;
import com.syntaxerror.demo.repository.MovimientoRepository;
import com.syntaxerror.demo.service.ReporteService;

@Service
public class ReporteServiceImpl implements ReporteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Override
	public List<Reporte> generarReportePorCliente(LocalDate fecha1, LocalDate fecha2, String nombre) throws Exception {
		List<Reporte> reportes = new ArrayList<>();
		
		Cliente cliente = clienteRepository.findByName(nombre);
		if(cliente == null) {
			throw new Exception("No se encontro un cliente con ese nombre");
		} else {
			List<Cuenta> cuentas = cuentaRepository.findByClienteId(cliente.getClienteId());
			if(cuentas.isEmpty()) {
				throw new Exception("No se encontro ninguna cuenta con ese id de cliente");
			} else {
				for(Cuenta cuenta : cuentas) {
					List<Movimiento> movimientos = (List<Movimiento>) movimientoRepository.findByNumeroCuenta(cuenta.getNumeroCuenta());
					if(!movimientos.isEmpty()) {
						for(Movimiento movimiento : movimientos) {
							LocalDate fechaMovimiento = movimiento.getFecha().toLocalDate();
							if((fechaMovimiento.equals(fecha1) || fechaMovimiento.isAfter(fecha1)) &&
								(fechaMovimiento.equals(fecha2) || fechaMovimiento.isBefore(fecha1))) {
								Reporte reporte = new Reporte(cliente.getNombre(), cuenta.getNumeroCuenta(), 
										cuenta.getTipoCuenta(), cuenta.getSaldoInicial(), movimiento.getSaldo(),
										cuenta.getEstado(), movimiento.getFecha(), 
										movimiento.getTipoMovimiento(),movimiento.getValor());
								reportes.add(reporte);
							}
						}
					}
				}
			}
		}
		
		return reportes;
	}

}
