package com.example.posvendas.posvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.posvendas.posvenda.model.domain.Brinquedo;
import com.example.posvendas.posvenda.model.services.BrinquedoService;

@Order(3)
@Component
public class BrinquedoLoader implements ApplicationRunner{

    @Autowired
	private BrinquedoService brinquedoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/brinquedo.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Brinquedo brinquedo = new Brinquedo();

			brinquedo.setCodigo(Integer.valueOf(campos[0]));
            brinquedo.setCodigo(Integer.valueOf(campos[0]));
            brinquedo.setDescricao(campos[1]);
            brinquedo.setEstoque(Boolean.valueOf(campos[2]));
            brinquedo.setPreco(Float.valueOf(campos[3]));
            brinquedo.setIdadeRecomendada(Integer.valueOf(campos[4]));
            brinquedo.setGenero(campos[5]);
            brinquedo.setMarca(campos[6]);
            brinquedo.setTipoDeBrinquedo(campos[7]);
			
			brinquedoService.incluir(brinquedo);
			
			linha = leitura.readLine();
		}

		for(Brinquedo brinquedo: brinquedoService.obterLista()) {
			System.out.println("[Brinquedo] " + brinquedo);			
		}

		leitura.close();
	}
}
