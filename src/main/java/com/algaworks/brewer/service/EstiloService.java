package com.algaworks.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.repository.Estilos;
import com.algaworks.brewer.service.exception.NomeEstiloJaCadastradadoException;

@Service
public class EstiloService {
	
	@Autowired
	private Estilos estilos;
	
	@Transactional
	public Estilo salvar(Estilo estilo) {
		Optional<Estilo> estiloOptinal = estilos.findByNomeIgnoreCase(estilo.getNome());
		if(estiloOptinal.isPresent()) {
			throw new NomeEstiloJaCadastradadoException("O estilo já está cadastrado");
		}
		return estilos.saveAndFlush(estilo);
	}

}
