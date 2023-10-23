package com.example.posvendas.posvenda.model.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.posvendas.posvenda.model.domain.Livro;

@Service
public class LivroService {
    	private Map<Integer, Livro> mapaLivro = new HashMap<Integer, Livro>();

	public void incluir(Livro Livro) {
		mapaLivro.put(Livro.getCodigo(), Livro);
	}
	
	public Collection<Livro> obterLista(){	
		return mapaLivro.values();
	}
}
