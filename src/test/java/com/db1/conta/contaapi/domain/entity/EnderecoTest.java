package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EnderecoTest {

	@Test
	public void deveRetornarClienteObrigatorio() {
		String mensagem = null;
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			new Endereco(null, cidade, "rua x", "123", "87033190", "casa", TipoEndereco.COBRANCA);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cliente é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCidadeObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		try {
			new Endereco(cliente, null, "rua x", "123", "87033190", "casa", TipoEndereco.COBRANCA);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cidade é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarLogradouroObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			new Endereco(cliente, cidade, null, "123", "87033190", "casa", TipoEndereco.COBRANCA);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Logradouro é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarNumeroObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			new Endereco(cliente, cidade, "rua x", null, "87033190", "casa", TipoEndereco.COBRANCA);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Número é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCEPObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			new Endereco(cliente, cidade, "rua x", "123", null, "casa", TipoEndereco.COBRANCA);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("CEP é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCEPInvalido() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			new Endereco(cliente, cidade, "rua x", "123", "87033", "casa", TipoEndereco.COBRANCA);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("CEP inválido", mensagem);
	}
	
	@Test
	public void deveRetornarTipoEnderecoObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			new Endereco(cliente, cidade, "rua x", "123", "87033190", "casa", null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Tipo de endereço é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaDeEndereco() {
		String mensagem = null;
		Endereco endereco = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {		
			endereco = new Endereco(cliente, cidade, "rua x", "123", "87033190", "casa", TipoEndereco.COBRANCA);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("rua x", endereco.getLogradouro());
		Assert.assertEquals("123", endereco.getNumero());
		Assert.assertEquals("87033190", endereco.getCep());
		Assert.assertEquals("casa", endereco.getComplemento());
		Assert.assertEquals(TipoEndereco.COBRANCA, endereco.getTipo());
	}
	
}