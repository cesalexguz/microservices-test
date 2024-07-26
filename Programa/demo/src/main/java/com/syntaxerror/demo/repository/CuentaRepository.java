package com.syntaxerror.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.syntaxerror.demo.entity.Cuenta;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Integer> {

	@Query("SELECT l FROM Cuenta l WHERE l.numeroCuenta=:numeroCuenta")
	public Cuenta findByNumeroCuenta(@Param("numeroCuenta") String numeroCuenta) throws Exception;
	
	@Query("SELECT l FROM Cuenta l WHERE l.clienteId=:clienteId")
	public List<Cuenta> findByClienteId(@Param("clienteId") int clienteId) throws Exception;
	
}
