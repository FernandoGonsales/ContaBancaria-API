package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.util.Assert;

@Embeddable
public class Historico {
	
	@Column(name = "data", nullable = false, length = 30)
	private LocalDateTime data;
	
	@Column(name = "tipo", nullable = false, length = 30)
	private TipoHistorico tipo;
	
	@Column(name = "valor", nullable = false, precision = 14, scale = 2)
	private Double valor;
	
	@Column(name = "saldo_atual", nullable = false, precision = 14, scale = 2)
	private Double saldoAtual;

	protected Historico() {}
	
	public Historico(TipoHistorico tipo, Double valor, Double saldoAtual) {		
		Assert.notNull(tipo, "Tipo histórico é obrigatório");
		Assert.notNull(valor, "Valor é obrigatório");
		Assert.notNull(saldoAtual, "Saldo atual é obrigatório");
		this.data = LocalDateTime.now();
		this.tipo = tipo;
		this.valor = valor;
		this.saldoAtual = saldoAtual;
	}
	
	public LocalDateTime getData() {
		return data;
	}

	public TipoHistorico getTipo() {
		return tipo;
	}

	public Double getValor() {
		return valor;
	}

	public Double getSaldoAtual() {
		return saldoAtual;
	}
}
