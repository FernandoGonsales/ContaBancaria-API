package com.db1.conta.contaapi.repository;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CidadeRepositoryTest {

	@Autowired
	private CidadeRepository cidadeRepository;

	@After
	public void afterTest() {
		cidadeRepository.deleteAll();
	}

	@Test
	public void deveSalvarUmaCidade() {
		Cidade cidade = new Cidade("Maringá", Estado.PR);

		Cidade cidadeSalva = cidadeRepository.save(cidade);

		Assert.assertNotNull(cidadeSalva.getId());
		Assert.assertEquals(cidade.getNome(), cidadeSalva.getNome());
		Assert.assertEquals(cidade.getEstado(), cidadeSalva.getEstado());
	}

	@Test
	public void deveBuscarCidadePorNome() {
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		cidadeRepository.save(cidade);

		Cidade cidadeBuscadaPorNome = cidadeRepository.findByNome("Maringá");

		Assert.assertNotNull(cidadeBuscadaPorNome);
		Assert.assertEquals(cidade.getNome(), cidadeBuscadaPorNome.getNome());
		Assert.assertEquals(cidade.getEstado(), cidadeBuscadaPorNome.getEstado());
	}

	@Test
	public void deveRetornarCidadesPorEstado() {
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		cidadeRepository.save(cidade);

		List<Cidade> cidades = cidadeRepository.findByEstado(Estado.PR);

		Assert.assertEquals(1, cidades.size());
	}

}