package com.example.posvendas.posvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.posvendas.posvenda.model.domain.Vendedor;
import com.example.posvendas.posvenda.model.services.VendedorService;


@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {
	
	@Autowired
	private VendedorService vendedorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/vendedor.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			Vendedor vendedor = new Vendedor();
			
			vendedor.setId(Integer.parseInt(campos[0]));
			vendedor.setNome(campos[1]);
			vendedor.setCpf(campos[2]);
			vendedor.setEmail(campos[3]);
			
			vendedorService.incluir(vendedor);
									
			linha = leitura.readLine();
		}

		for(Vendedor vendedor: vendedorService.obterLista()) {
			System.out.println("[Vendedor] " + vendedor);			
		}
		
		leitura.close();
	}
}