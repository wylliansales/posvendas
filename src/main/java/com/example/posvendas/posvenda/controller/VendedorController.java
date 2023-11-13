package com.example.posvendas.posvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.posvendas.posvenda.model.services.VendedorService;


public class VendedorController {
     
    @Autowired
    private AppController appController;

    @Autowired
    VendedorService vendedorService;

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
