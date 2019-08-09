package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero", length = 20, nullable = false, unique = true)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "agencia_id", nullable = false)
	private Agencia agencia;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	private TipoConta tipo;
	
	@Column(name = "saldo", nullable = false, precision = 14, scale = 2)
	private Double saldo;
	
	@ElementCollection	
	private List<Historico> historicos = new ArrayList<Historico>();

	protected Conta() {}
	
	public Conta(String numero, Agencia agencia, Cliente cliente, TipoConta tipo) {
		Assert.hasText(numero, "Número da conta é obrigatório");
		Assert.notNull(agencia, "Agência é obrigatório");
		Assert.notNull(cliente, "Cliente é obrigatório");
		Assert.notNull(tipo, "Tipo da conta é obrigatório");
		this.numero = numero;
		this.agencia = agencia;
		this.cliente = cliente;
		this.tipo = tipo;
		this.saldo = 0.0;
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public TipoConta getTipo() {
		return tipo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}
	
	public void depositar(double valor) {		
		this.saldo += valor;
		this.historicos.add(new Historico(TipoHistorico.ENTRADA, valor, this.saldo));
	}	
}
