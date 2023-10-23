package com.example.posvendas.posvenda.model.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.posvendas.posvenda.model.domain.Brinquedo;

@Service
public class BrinquedoService {
    private Map<Integer, Brinquedo> mapaBrinquedo = new HashMap<Integer, Brinquedo>();

	public void incluir(Brinquedo Brinquedo) {
		mapaBrinquedo.put(Brinquedo.getCodigo(), Brinquedo);
	}
	
	public Collection<Brinquedo> obterLista(){	
		return mapaBrinquedo.values();
	}
}
