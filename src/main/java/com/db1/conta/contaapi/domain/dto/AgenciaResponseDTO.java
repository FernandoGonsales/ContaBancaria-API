package com.db1.conta.contaapi.domain.dto;

import java.io.Serializable;

//SAIDA
public class AgenciaResponseDTO implements Serializable {

	private static final long serialVersionUID = -6728365271597369847L;

	private Long id;
	
	private String numero;
	
	private String digito;
	
	private Long cidadeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDigito() {
		return digito;
	}

	public void setDigito(String digito) {
		this.digito = digito;
	}

	public Long getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Long cidadeId) {
		this.cidadeId = cidadeId;
	}

}