package com.db1.conta.contaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.conta.contaapi.adapter.CidadeAdapter;
import com.db1.conta.contaapi.domain.dto.CidadePersistDTO;
import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public CidadeResponseDTO save(CidadePersistDTO dto) {
		Cidade cidade = new Cidade(dto.getNome(), dto.getEstado());
		cidadeRepository.save(cidade);
		return CidadeAdapter.entityToResponse(cidade);
	}
	
	public CidadeResponseDTO update(Long cidadeId, CidadePersistDTO dto) {
		Optional<Cidade> opCidade = cidadeRepository.findById(cidadeId);
		if (opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			cidade.alterar(dto.getNome(), dto.getEstado());
			cidadeRepository.save(cidade);
			return CidadeAdapter.entityToResponse(cidade);
		}		
		throw new RuntimeException("Cidade de ID" + cidadeId + " não encontrada");
	}
	
	public List<CidadeResponseDTO> findAll() {
		List<Cidade> cidades = cidadeRepository.findAll();
		List<CidadeResponseDTO> response = CidadeAdapter.entityToResponse(cidades);
		return response;
	}
	
	public CidadeResponseDTO findByName(String nome) {
		Optional<Cidade> opCidade = cidadeRepository.findByNomeOptional(nome);
		if (opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			CidadeResponseDTO cidadeResponse = CidadeAdapter.entityToResponse(cidade);
			return cidadeResponse;
		}
		throw new RuntimeException("Cidade de nome " + nome + " não  encontrada"); 	
	}
	
	public CidadeResponseDTO findByNameJava8(String nome) {				
		return cidadeRepository
				.findByNomeOptional(nome)
				.map(CidadeAdapter::entityToResponse)
				.orElseThrow(() -> 
					new RuntimeException("Cidade de nome " + nome + " não  encontrada"));
	}
	
	public void delete(Long cidadeId) {
		Optional<Cidade> opCidade = cidadeRepository.findById(cidadeId);
		if (opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			cidadeRepository.delete(cidade);
		} else {
			throw new RuntimeException("Cidade de ID " + cidadeId + " não encontrada");
		}
	}
	
	public CidadeResponseDTO findById(Long cidadeId) {
		Optional<Cidade> opCidade = cidadeRepository.findById(cidadeId);
		if (opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			return CidadeAdapter.entityToResponse(cidade);
		}
		throw new RuntimeException("Cidade de ID " + cidadeId + " não encontrada");
	}
	
}
