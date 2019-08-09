package com.db1.conta.contaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1.conta.contaapi.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
