package com.db1.conta.contaapi.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1.conta.contaapi.domain.dto.AgenciaResponseDTO;
import com.db1.conta.contaapi.domain.entity.Agencia;

public class AgenciaAdapter {

	public static AgenciaResponseDTO entityToResponse(Agencia agencia) {
		AgenciaResponseDTO responseDTO = new AgenciaResponseDTO();
		responseDTO.setId(agencia.getId());
		responseDTO.setNumero(agencia.getNumero());
		responseDTO.setDigito(agencia.getDigito());
		responseDTO.setCidadeId(agencia.getCidade().getId());
		return responseDTO;
	}

	public static List<AgenciaResponseDTO> entityToResponse(List<Agencia> agencias) {
		List<AgenciaResponseDTO> response = new ArrayList<AgenciaResponseDTO>();
		for (Agencia agencia : agencias) {
			response.add(entityToResponse(agencia));
		}
		return response;
	}

}