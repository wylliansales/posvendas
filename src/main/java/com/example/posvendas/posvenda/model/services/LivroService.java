package com.example.posvendas.posvenda.model.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.posvendas.posvenda.model.domain.Livro;
import com.example.posvendas.posvenda.model.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public void incluir(Livro livro) {
		livroRepository.save(livro);
	}
	
	public Collection<Livro> obterLista(){	
		return (Collection<Livro>) livroRepository.findAll();
	}
}
