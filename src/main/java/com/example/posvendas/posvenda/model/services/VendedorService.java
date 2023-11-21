package com.example.posvendas.posvenda.model.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.posvendas.posvenda.clients.IEnderecoClient;
import com.example.posvendas.posvenda.model.domain.Endereco;
import com.example.posvendas.posvenda.model.domain.Vendedor;
import com.example.posvendas.posvenda.model.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository vendedorRepository;


	public Vendedor pesquisar(String cpf) {
		return vendedorRepository.findByCpf(cpf);
	}

	public void incluir(Vendedor vendedor) {
				
		Endereco endereco = new Endereco("77500000");
		
		vendedor.setEndereco(endereco);
		
		vendedorRepository.save(vendedor);
	}
	
	public Collection<Vendedor> obterLista() {
		return (Collection<Vendedor>) vendedorRepository.findAll();
	}
	
	public void excluir(Integer id) {
		vendedorRepository.deleteById(id);
	}
}
