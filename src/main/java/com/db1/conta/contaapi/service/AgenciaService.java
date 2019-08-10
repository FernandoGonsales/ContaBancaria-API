package com.db1.conta.contaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.conta.contaapi.adapter.AgenciaAdapter;
import com.db1.conta.contaapi.domain.dto.AgenciaPersistDTO;
import com.db1.conta.contaapi.domain.dto.AgenciaResponseDTO;
import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.repository.AgenciaRepository;
import com.db1.conta.contaapi.repository.CidadeRepository;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
		
	public AgenciaResponseDTO save(AgenciaPersistDTO dto) {
		Cidade cidade = cidadeRepository.findById(dto.getCidadeId())
				.orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
		Agencia agencia = new Agencia(dto.getNumero(), dto.getDigito(), cidade);
		agenciaRepository.save(agencia);
		return AgenciaAdapter.entityToResponse(agencia);
	}
	
	public AgenciaResponseDTO update(Long agenciaId, AgenciaPersistDTO dto) {
		Agencia agencia = agenciaRepository.findById(agenciaId)
				.orElseThrow(() -> new RuntimeException("Agência não encontrada"));
		Cidade cidade = cidadeRepository.findById(dto.getCidadeId())
				.orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
		agencia.alterar(dto.getNumero(), dto.getDigito(), cidade);
		agenciaRepository.save(agencia);
		return AgenciaAdapter.entityToResponse(agencia);
	}
	
	public List<AgenciaResponseDTO> findAll() {
		List<Agencia> agencias = agenciaRepository.findAll();
		List<AgenciaResponseDTO> response = AgenciaAdapter.entityToResponse(agencias);
		return response;
	}
	
	public AgenciaResponseDTO findByNumero(String numero) {
		Optional<Agencia> opAgencia = agenciaRepository.findByNumeroOptional(numero);
		if (opAgencia.isPresent()) {
			Agencia agencia = opAgencia.get();
			AgenciaResponseDTO agenciaResponse = AgenciaAdapter.entityToResponse(agencia);
			return agenciaResponse;
		}
		throw new RuntimeException("Agência de número " + numero + " não  encontrada"); 	
	}
	
	public void delete(Long agenciaId) {
		Optional<Agencia> opAgencia = agenciaRepository.findById(agenciaId);
		if (opAgencia.isPresent()) {
			Agencia agencia = opAgencia.get();
			agenciaRepository.delete(agencia);
		} else {
			throw new RuntimeException("Agência de ID " + agenciaId + " não encontrada");
		}
	}
	
	public AgenciaResponseDTO findById(Long agenciaId) {
		Optional<Agencia> opAgencia = agenciaRepository.findById(agenciaId);
		if (opAgencia.isPresent()) {
			Agencia agencia = opAgencia.get();
			return AgenciaAdapter.entityToResponse(agencia);
		}
		throw new RuntimeException("Agência de ID " + agenciaId + " não encontrada");
	}

}