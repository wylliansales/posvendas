package com.example.posvendas.posvenda.model.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.posvendas.posvenda.model.domain.Vendedor;

@Service
public class VendedorService {

	private Map<String, Vendedor> mapaVendedor = new HashMap<String, Vendedor>();

	public void incluir(Vendedor vendedor) {
		mapaVendedor.put(vendedor.getCpf(), vendedor);
	}
	
	public Collection<Vendedor> obterLista(){	
		return mapaVendedor.values();
	}
}
