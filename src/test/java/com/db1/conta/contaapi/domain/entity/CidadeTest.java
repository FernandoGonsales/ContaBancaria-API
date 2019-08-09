package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;

public class CidadeTest {
	
	@Test
	public void deveRetornarNomeObrigatorio() {
		String mensagem = null;
		try {		
			new Cidade(null, Estado.AC);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Nome é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarEstadoObrigatorio() {
		String mensagem = null;
		try {		
			new Cidade("Maringá", null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Estado é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaDeCidade() {
		String mensagem = null;
		Cidade cidade = null;
		try {		
			cidade = new Cidade("Maringá", Estado.PR);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("Maringá", cidade.getNome());
		Assert.assertEquals(Estado.PR, cidade.getEstado());
	}

}