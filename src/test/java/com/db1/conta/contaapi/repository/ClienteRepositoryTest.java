package com.db1.conta.contaapi.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.TipoEndereco;
import com.db1.conta.contaapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@After
	public void afterTest() {
		clienteRepository.deleteAll();
		this.cidadeRepository.deleteAll();
	}

	@Test
	public void deveSalvarUmNovoCliente() {
		Cliente cliente = new Cliente("Nome Do Cliente", "99999999999");

		Cliente clienteSalvo = clienteRepository.save(cliente);

		Assert.assertNotNull(clienteSalvo.getId());
		Assert.assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
		Assert.assertEquals(cliente.getNome(), clienteSalvo.getNome());
	}

	@Test
	public void deveSalvarClienteComEndereco() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Cliente cliente = new Cliente("Nome Do Cliente", "99999999999");

		cliente.addEndereco(cidade, "Rua A", "99", "99999999", "Casa", TipoEndereco.RESIDENCIAL);

		Cliente clienteSalvo = clienteRepository.save(cliente);

		Assert.assertNotNull(clienteSalvo.getId());
		Assert.assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
		Assert.assertEquals(cliente.getNome(), clienteSalvo.getNome());
		Assert.assertEquals(1, clienteSalvo.getEnderecos().size());
		Assert.assertNotNull(clienteSalvo.getEnderecos().get(0).getId());
	}

}
