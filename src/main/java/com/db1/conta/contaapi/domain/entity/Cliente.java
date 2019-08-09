package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 60, nullable = false)
	private String nome;
	
	@Column(name =  "cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Conta> contas = new ArrayList<>();
	
	protected Cliente() {}

	public Cliente(String nome, String cpf) {
		Assert.hasText(nome, "Nome é obrigatório");
		Assert.hasText(cpf, "CPF é obrigatório");
		Assert.isTrue(cpf.length() == 11, "CPF inválido");
		this.nome = nome;
		this.cpf = cpf;
	}

	public void addEndereco(Cidade cidade, String logradouro, String numero, String cep, String complemento, TipoEndereco tipo) {
		Endereco endereco = new Endereco(this, cidade, logradouro, numero, cep, complemento, tipo);
		this.enderecos.add(endereco);
	}
	
	public void addEnderecoCobranca(Cidade cidade, String logradouro, String numero, String cep, String complemento) {
		this.addEndereco(cidade, logradouro, numero, cep, complemento, TipoEndereco.COBRANCA);
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	
}
