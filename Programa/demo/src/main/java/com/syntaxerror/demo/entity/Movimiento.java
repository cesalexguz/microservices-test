package com.syntaxerror.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movimientos")
public class Movimiento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movimiento_id")
    private int movimientoId;

	@Column(name = "fecha", updatable = false)
	@CreationTimestamp
    private LocalDateTime fecha;

    @Column(name = "tipo_movimiento", nullable = false, length = 1)
    private String tipoMovimiento;
    
    @Column(name="numero_cuenta", nullable = false)
    private String numeroCuenta;
    
    @Column(name = "valor", nullable = false)
    private double valor;
    
    @Column(name = "saldo")
    private double saldo;

	public Movimiento() {
		super();
	}

	public Movimiento(int movimientoId, LocalDateTime fecha, String tipoMovimiento, String numeroCuenta, double valor,
			double saldo) {
		super();
		this.movimientoId = movimientoId;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.numeroCuenta = numeroCuenta;
		this.valor = valor;
		this.saldo = saldo;
	}

	public int getMovimientoId() {
		return movimientoId;
	}

	public void setMovimientoId(int movimientoId) {
		this.movimientoId = movimientoId;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Movimiento [movimientoId=" + movimientoId + 
				", fecha=" + fecha + ", tipoMovimiento=" + tipoMovimiento + 
				", numeroCuenta=" + numeroCuenta + ", valor=" + valor + 
				", saldo=" + saldo + "]";
	}
    
}
