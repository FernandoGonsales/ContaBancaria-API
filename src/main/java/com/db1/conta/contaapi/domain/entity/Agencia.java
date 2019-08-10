package com.db1.conta.contaapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "agencia")
public class Agencia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero", length = 20, nullable = false, unique = true)
	private String numero;
	
	@Column(name = "digito", length = 2, nullable =false)
	private String digito;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id", nullable = false)
	private Cidade cidade;
	
	protected Agencia() {}
	
	public Agencia(String numero, String digito, Cidade cidade) {	
		Assert.hasText(numero, "Número da conta é obrigatório");
		Assert.hasText(digito, "Dígito da conta é obrigatório");
		Assert.notNull(cidade, "Cidade é obrigatório");
		this.numero = numero;
		this.digito = digito;
		this.cidade = cidade;
	}
	
	public void alterar(String numero, String digito, Cidade cidade) {
		this.validateAgencia(numero, digito, cidade);
		this.numero = numero;
		this.digito = digito;
		this.cidade = cidade;
	}
	
	public void validateAgencia(String numero, String digito, Cidade cidade) {
		Assert.hasText(numero, "Numero é obrigatorio");
		Assert.hasText(digito, "Digito é obrigatorio");
		Assert.notNull(cidade, "Cidade é obrigatorio");	
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public String getDigito() {
		return digito;
	}

	public Cidade getCidade() {
		return cidade;
	}
}
