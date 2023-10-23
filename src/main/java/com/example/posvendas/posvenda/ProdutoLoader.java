package com.example.posvendas.posvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.posvendas.posvenda.model.domain.Brinquedo;
import com.example.posvendas.posvenda.model.domain.Livro;
import com.example.posvendas.posvenda.model.domain.Produto;
import com.example.posvendas.posvenda.model.services.ProdutoService;



@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produtos.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			switch (campos[6]) {
			case "B":
				Brinquedo brinquedo = new Brinquedo();
				brinquedo.setCodigo(Integer.valueOf(campos[0]));
				brinquedo.setDescricao(campos[1]);
				brinquedo.setEstoque(Boolean.valueOf(campos[2]));
				brinquedo.setPreco(Float.valueOf(campos[3]));
				brinquedo.setIdadeRecomendada(Integer.valueOf(campos[4]));
				brinquedo.setGenero(campos[5]);
				brinquedo.setMarca(campos[6]);
				brinquedo.setTipoDeBrinquedo(campos[7]);
				
				produtoService.incluir(brinquedo);
				
				break;

			case "L":
				Livro livro = new Livro();
				livro.setCodigo(Integer.valueOf(campos[0]));
				livro.setDescricao(campos[1]);
				livro.setEstoque(Boolean.valueOf(campos[2]));
				livro.setPreco(Float.valueOf(campos[3]));
				livro.setTitulo(campos[4]);
				livro.setAutor(campos[5]);
				livro.setEditora(campos[6]);
				livro.setNumeroDePaginas(Integer.valueOf(campos[7]));
				livro.setAnoDePublicacao(Integer.valueOf(campos[8]));
				
				produtoService.incluir(livro);
				
				break;

			default:
				break;
			}
									
			linha = leitura.readLine();
		}

		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);			
		}
		
		leitura.close();
	}
}
