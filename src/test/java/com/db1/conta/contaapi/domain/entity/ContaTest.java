package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ContaTest {
	
	@Test
	public void deveRetornarNumeroDaContaObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Agencia agencia = Mockito.mock(Agencia.class);
		try {
			new Conta(null, agencia, cliente, TipoConta.CORRENTE);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Número da conta é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarAgenciaObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		try {
			new Conta("1", null, cliente, TipoConta.CORRENTE);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Agência é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarClienteObrigatorio() {
		String mensagem = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		try {
			new Conta("1", agencia, null, TipoConta.CORRENTE);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cliente é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarTipoContaObrigatorio() {
		String mensagem = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		try {
			new Conta("1", agencia, cliente, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Tipo da conta é obrigatório", mensagem);
	}
	
	
	@Test
	public void deveCriarUmaInstanciaDeContaComSaldoZero() {
		String mensagem = null;
		Conta conta = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		try {
			conta = new Conta("1", agencia, cliente, TipoConta.CORRENTE);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("1", conta.getNumero());
		Assert.assertEquals(TipoConta.CORRENTE, conta.getTipo());
		Assert.assertEquals(0.0, conta.getSaldo(), 0.0001);
	}
	
}