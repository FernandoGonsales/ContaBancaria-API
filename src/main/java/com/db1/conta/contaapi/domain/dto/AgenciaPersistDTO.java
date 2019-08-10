package com.db1.conta.contaapi.domain.dto;

import java.io.Serializable;

//ENTRADA
public class AgenciaPersistDTO implements Serializable {

	private static final long serialVersionUID = -3941166762402040704L;

	private String numero;
	
	private String digito;
	
	private Long cidadeId;

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