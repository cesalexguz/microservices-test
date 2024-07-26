package com.syntaxerror.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentas")
public class Cuenta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cuenta_id")
    private int cuentaId;
	
	@Column(name="numero_cuenta")
    private String numeroCuenta;
	
	@Column(name = "tipo_cuenta")
    private String tipoCuenta;
    
    @Column(name = "saldo_inicial")
    private double saldoInicial;
    
    @Column(name = "saldo_disponible")
    private double saldoDisponible;
    
    @Column(name = "estado")
    private boolean estado;
    
    @Column(name="cliente_id")
    private int clienteId;

	public Cuenta() {
		super();
	}

	public Cuenta(int cuentaId, String numeroCuenta, String tipoCuenta, double saldoInicial, double saldoDisponible,
			boolean estado, int clienteId) {
		super();
		this.cuentaId = cuentaId;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoInicial = saldoInicial;
		this.saldoDisponible = saldoDisponible;
		this.estado = estado;
		this.clienteId = clienteId;
	}

	public int getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(int cuentaId) {
		this.cuentaId = cuentaId;
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

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + 
				", tipoCuenta=" + tipoCuenta + ", saldoInicial=" + saldoInicial + 
				", saldoDisponible=" + saldoDisponible + ", estado=" + estado + 
				", clienteId=" + clienteId + "]";
	}
    
}
