package com.example.posvendas.posvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.posvendas.posvenda.model.domain.Brinquedo;
import com.example.posvendas.posvenda.model.domain.Vendedor;
import com.example.posvendas.posvenda.model.services.BrinquedoService;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

			brinquedo.setId(Integer.valueOf(campos[0]));
			brinquedo.setDescricao(campos[1]);
            brinquedo.setCodigo(Integer.valueOf(campos[2]));
            brinquedo.setPreco(Float.valueOf(campos[3]));
            brinquedo.setEstoque(Boolean.valueOf(campos[4]));
            
            brinquedo.setIdadeRecomendada(campos[6]);
            brinquedo.setGenero(campos[7]);
            brinquedo.setMarca(campos[8]);
            brinquedo.setTipoDeBrinquedo(campos[9]);

			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[5]));
			brinquedo.setVendedor(vendedor);

			brinquedoService.incluir(brinquedo);
			
			linha = leitura.readLine();
		}

		for(Brinquedo brinquedo: brinquedoService.obterLista()) {
			System.out.println("[Brinquedo] " + brinquedo);			
		}

		leitura.close();
	}
}
