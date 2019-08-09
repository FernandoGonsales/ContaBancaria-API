package com.db1.conta.contaapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.util.Assert;

@Entity
@Table(name = "cidade", 
	uniqueConstraints = @UniqueConstraint(columnNames = { "nome", "estado" }))
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", length = 60, nullable = false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado", length = 2, nullable = false)
	private Estado estado;
	
	protected Cidade() {}
	
	public Cidade(String nome, Estado estado) {
		Assert.hasText(nome, "Nome é obrigatório");
		Assert.notNull(estado, "Estado é obrigatório");
		this.nome = nome;
		this.estado = estado;
	}

	public void alterar(String nome, Estado estado) {
		this.validateCidade(nome, estado);
		this.nome = nome;
		this.estado = estado;
	}
	
	private void validateCidade(String nome, Estado estado) {
		Assert.hasText(nome, "Nome ´obrigatório");
		Assert.notNull(estado, "Estado é obrigatório");
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Estado getEstado() {
		return estado;
	}
}
