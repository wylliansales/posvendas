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
import com.example.posvendas.posvenda.model.domain.Vendedor;
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

		while (linha != null) {

			campos = linha.split(";");

			Vendedor vendedor = new Vendedor();

			switch (campos[10]) {
				case "B":
					Brinquedo brinquedo = new Brinquedo();
					brinquedo.setId(Integer.valueOf(campos[0]));
					brinquedo.setDescricao(campos[1]);
					brinquedo.setCodigo(Integer.valueOf(campos[2]));
					brinquedo.setPreco(Float.valueOf(campos[3]));
					brinquedo.setEstoque(Boolean.valueOf(campos[4]));

					brinquedo.setIdadeRecomendada(campos[6]);
					brinquedo.setGenero(campos[7]);
					brinquedo.setMarca(campos[8]);
					brinquedo.setTipoDeBrinquedo(campos[9]);

					vendedor.setId(Integer.valueOf(campos[5]));
					brinquedo.setVendedor(vendedor);

					produtoService.incluir(brinquedo);

					break;

				case "L":
					Livro livro = new Livro();
					livro.setCodigo(Integer.valueOf(campos[0]));
					livro.setId(Integer.valueOf(campos[0]));
					livro.setDescricao(campos[1]);
					livro.setCodigo(Integer.valueOf(campos[2]));
					livro.setPreco(Float.valueOf(campos[3]));
					livro.setEstoque(Boolean.valueOf(campos[4]));

					livro.setTitulo(campos[6]);
					livro.setAutor(campos[7]);
					livro.setEditora(campos[8]);
					livro.setNumeroDePaginas(Integer.valueOf(campos[9]));

					vendedor.setId(Integer.valueOf(campos[5]));
					livro.setVendedor(vendedor);

					produtoService.incluir(livro);

					break;

				default:
					break;
			}

			linha = leitura.readLine();
		}

		for (Produto produto : produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);
		}

		leitura.close();
	}
}
