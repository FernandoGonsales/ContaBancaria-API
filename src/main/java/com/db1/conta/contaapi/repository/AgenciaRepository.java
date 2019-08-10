package com.db1.conta.contaapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Estado;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
	
	List<Agencia> findByCidadeEstado(Estado estado);

	@Query(nativeQuery = true, value = "select * from agencia where numero = :numero")
	Optional<Agencia> findByNumeroOptional(@Param("numero") String numero);
	
}
