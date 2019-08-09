package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
	
	@Test
	public void deveRetornarNomeObrigatório() {
		String mensagem = null;
		try {
			new Cliente(null, "12345678");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Nome é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCPFObrigatório() {
		String mensagem = null;
		try {
			new Cliente("Fernando Gonsales", null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("CPF é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCPFInvalido() {
		String mensagem = null;
		try {
			new Cliente("Fernando Gonsales", "12345678");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("CPF inválido", mensagem);
	}

	@Test
	public void deveCriarUmaInstanciaDeCliente() {
		String mensagem = null;
		Cliente cliente = null;
		try {		
			cliente = new Cliente("Fernando", "12345678901");
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("Fernando", cliente.getNome());
		Assert.assertEquals("12345678901", cliente.getCpf());
	}
}