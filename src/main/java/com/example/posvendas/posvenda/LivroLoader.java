package com.example.posvendas.posvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.posvendas.posvenda.model.domain.Livro;
import com.example.posvendas.posvenda.model.domain.Vendedor;
import com.example.posvendas.posvenda.model.services.LivroService;

@Order(4)
@Component
public class LivroLoader implements ApplicationRunner {

	@Autowired
	private LivroService livroService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/livro.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		String[] campos = null;

		while (linha != null) {

			campos = linha.split(";");

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

			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[5]));
			livro.setVendedor(vendedor);

			livroService.incluir(livro);

			linha = leitura.readLine();
		}

		for (Livro livro : livroService.obterLista()) {
			System.out.println("[Livro] " + livro);
		}

		leitura.close();
	}
}
