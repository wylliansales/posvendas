package com.example.posvendas.posvenda.model.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.posvendas.posvenda.model.domain.Brinquedo;
import com.example.posvendas.posvenda.model.repository.BrinquedoRepository;

@Service
public class BrinquedoService {

	@Autowired
	private BrinquedoRepository brinquedoRepository;

	public void incluir(Brinquedo brinquedo) {
		brinquedoRepository.save(brinquedo);
	}
	
	public Collection<Brinquedo> obterLista(){	
		return (Collection<Brinquedo>) brinquedoRepository.findAll();
	}

	public long obterQtde() {
		return brinquedoRepository.count();
	}
}
