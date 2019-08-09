package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AgenciaTest {

	@Test
	public void deveRetornarNumeroObrigatorio() {
		String mensagem = null;
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			new Agencia(null, "1", cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Número da conta é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarDigitoObrigatorio() {
		String mensagem = null;
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			new Agencia("123456", null, cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Dígito da conta é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCidadeObrigatorio() {
		String mensagem = null;
		try {		
			new Agencia("123456", "1", null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cidade é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaDeAgencia() {
		String mensagem = null;
		Agencia agencia = null;
		Cidade cidade = Mockito.mock(Cidade.class);
		try {		
			agencia = new Agencia("123456", "1", cidade);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("123456", agencia.getNumero());
		Assert.assertEquals("1", agencia.getDigito());
	}
}