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
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Endereco;
import com.db1.conta.contaapi.domain.entity.Estado;
import com.db1.conta.contaapi.domain.entity.TipoEndereco;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnderecoRepositoryTest {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@After
	public void afterTest() {
		enderecoRepository.deleteAll();
		cidadeRepository.deleteAll();
		clienteRepository.deleteAll();
	}

	@Test
	public void deveSalvarUmEndereco() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Cliente cliente = clienteRepository.save(new Cliente("Cliente Nome", "99999999999"));
		
		Endereco endereco = new Endereco(cliente, cidade, "rua x", "123", "12345678", "casa", TipoEndereco.COBRANCA);

		Endereco enderecoSalvo = enderecoRepository.save(endereco);

		Assert.assertNotNull(enderecoSalvo.getId());
		Assert.assertEquals(endereco.getLogradouro(), enderecoSalvo.getLogradouro());
		Assert.assertEquals(endereco.getNumero(), enderecoSalvo.getNumero());
		Assert.assertEquals(endereco.getCep(), enderecoSalvo.getCep());
	}
	
	@Test
	public void deveBuscarTodosOsEnderecosDeClientesDeUmEstado() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Cliente cliente = clienteRepository.save(new Cliente("Cliente Nome", "99999999999"));
		
		Endereco endereco = new Endereco(cliente, cidade, "rua x", "123", "12345678", "casa", TipoEndereco.COBRANCA);
		
		enderecoRepository.save(endereco);
		
		List<Endereco> enderecos = enderecoRepository.findByCidadeEstado(Estado.PR);
		
		Assert.assertEquals(1, enderecos.size());
	}
}
