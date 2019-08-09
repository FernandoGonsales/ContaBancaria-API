package com.db1.conta.contaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1.conta.contaapi.domain.entity.Endereco;
import com.db1.conta.contaapi.domain.entity.Estado;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	List<Endereco> findByCidadeEstado(Estado estado);

}
