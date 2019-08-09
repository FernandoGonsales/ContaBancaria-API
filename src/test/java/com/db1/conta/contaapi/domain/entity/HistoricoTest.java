package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;

public class HistoricoTest {
	
	@Test
	public void deveRetornarTipoHistoricoObrigatorio() {
		String mensagem = null;
		try {
			new Historico(null, 0.0, 0.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Tipo histórico é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarValorObrigatorio() {
		String mensagem = null;
		try {
			new Historico(TipoHistorico.ENTRADA, null, 0.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarSaldoAtualObrigatorio() {
		String mensagem = null;
		try {
			new Historico(TipoHistorico.ENTRADA, 0.0, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Saldo atual é obrigatório", mensagem);
	}

	@Test
	public void deveCriarUmaInstanciaDeHistorico() {
		String mensagem = null;
		Historico historico = null;
		try {		
			historico = new Historico(TipoHistorico.ENTRADA, 10.0, 10.0);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals(TipoHistorico.ENTRADA, historico.getTipo());
		Assert.assertEquals(10.0, historico.getValor(), 0.0001);
		Assert.assertEquals(10.0, historico.getSaldoAtual(), 0.0001);
	}
	
}