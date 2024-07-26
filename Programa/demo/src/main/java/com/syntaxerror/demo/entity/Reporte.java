package com.syntaxerror.demo.entity;

import java.time.LocalDateTime;

public class Reporte {

	private String nombreCliente;
	
	private String numeroCuenta;
	
	private String tipoCuenta;
	
	private double saldoInicial;
	
	private double saldoDisponible;
	
	private boolean estado;
	
	private LocalDateTime fecha;
	
	private String tipoMovimiento;
	
	private double valorMovimiento;

	public Reporte() {
		super();
	}

	public Reporte(String nombreCliente, String numeroCuenta, String tipoCuenta, double saldoInicial,
			double saldoDisponible, boolean estado, LocalDateTime fecha, String tipoMovimiento,
			double valorMovimiento) {
		super();
		this.nombreCliente = nombreCliente;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoInicial = saldoInicial;
		this.saldoDisponible = saldoDisponible;
		this.estado = estado;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.valorMovimiento = valorMovimiento;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public double getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getValorMovimiento() {
		return valorMovimiento;
	}

	public void setValorMovimiento(double valorMovimiento) {
		this.valorMovimiento = valorMovimiento;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	@Override
	public String toString() {
		return "Reporte [nombreCliente=" + nombreCliente + ", numeroCuenta=" + numeroCuenta + ", tipoCuenta="
				+ tipoCuenta + ", saldoInicial=" + saldoInicial + ", saldoDisponible=" + saldoDisponible + ", estado="
				+ estado + ", fecha=" + fecha + ", tipoMovimiento=" + tipoMovimiento + ", valorMovimiento="
				+ valorMovimiento + "]";
	}
	
}
