package com.syntaxerror.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.syntaxerror.demo.entity.Movimiento;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Integer> {

	@Query("SELECT l FROM Movimiento l WHERE l.numeroCuenta=:numeroCuenta")
	public List<Movimiento> findByNumeroCuenta(@Param("numeroCuenta") String numeroCuenta) throws Exception;

}
