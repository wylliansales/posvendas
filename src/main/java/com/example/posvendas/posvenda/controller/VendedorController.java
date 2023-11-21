package com.example.posvendas.posvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.posvendas.posvenda.model.domain.Vendedor;
import com.example.posvendas.posvenda.model.services.VendedorService;


public class VendedorController {
     
    @Autowired
    private AppController appController;

    @Autowired
    VendedorService vendedorService;

    @GetMapping(value = "/vendedor/pesquisar")
	public String pesquisar(ModelMap model, String campoBusca) {

		Vendedor vendedor = vendedorService.pesquisar(campoBusca);
		
		if(vendedor != null) {
			model.addAttribute("objeto", vendedor);
			return appController.index(model);
		}
		return "redirect:/vendedor/lista";
	}

    @GetMapping(value = "/vendedor/{id}/excluir")
    public String excluir(Integer id) {
        vendedorService.excluir(id);

        return null;
    }
    
    public String obterLista(ModelMap model) {
        model.addAttribute("titulo", "Vendedores:");
        model.addAttribute("listagem", vendedorService.obterLista());

        return appController.index(model);
    }
}
