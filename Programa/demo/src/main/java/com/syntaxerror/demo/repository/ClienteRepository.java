package com.syntaxerror.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.syntaxerror.demo.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

	@Query("SELECT l FROM Cliente l WHERE l.nombre=:nombre")
	public Cliente findByName(@Param("nombre") String nombre) throws Exception;
}
