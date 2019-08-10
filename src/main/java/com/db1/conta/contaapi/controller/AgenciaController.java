package com.db1.conta.contaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.db1.conta.contaapi.domain.dto.AgenciaPersistDTO;
import com.db1.conta.contaapi.domain.dto.AgenciaResponseDTO;
import com.db1.conta.contaapi.service.AgenciaService;

@RestController
@RequestMapping("api/agencia")
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;
	
	//LISTAR TODAS AGENCIAS
	@GetMapping("/all")
	public List<AgenciaResponseDTO> getAll() {
		return agenciaService.findAll();
	}
	
	//BUSCAR AGENCIA POR NUMERO
	@GetMapping
	public AgenciaResponseDTO agenciaPorNumero(@RequestParam("numero") String numero) {
		return agenciaService.findByNumero(numero);
	}
	
	//BUSCAR AGENCIA POR ID
	@GetMapping("/{id}")
	public AgenciaResponseDTO CidadePorId(@PathVariable("id") Long id) {
		return agenciaService.findById(id);
	}
	
	//SALVAR NOVA AGENCIA
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AgenciaResponseDTO saveAgencia(@RequestBody AgenciaPersistDTO dto) {
		return agenciaService.save(dto);
	}
	
	//DELETAR AGENCIA POR ID
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		agenciaService.delete(id);
	}
	
	//MODIFICAR AGENCIA POR ID
	@PutMapping("/{id}")
	public AgenciaResponseDTO updateAgencia(@PathVariable("id") Long id, @RequestBody AgenciaPersistDTO dto) {
		return agenciaService.update(id, dto);
	}
	
}