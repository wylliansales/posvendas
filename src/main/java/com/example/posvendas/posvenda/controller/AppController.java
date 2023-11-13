package com.example.posvendas.posvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.posvendas.posvenda.model.services.BrinquedoService;
import com.example.posvendas.posvenda.model.services.LivroService;
import com.example.posvendas.posvenda.model.services.VendedorService;

@Controller
public class AppController {

    @Autowired
    private VendedorService vendedorService;
    
    @Autowired
    private BrinquedoService brinquedoService;

    @Autowired
    private LivroService livroService;

    @RequestMapping(value = "/index")
    public String index(ModelMap model) {
        model.addAttribute("vendedores", vendedorService.obterLista());
        model.addAttribute("brinquedos", brinquedoService.obterLista());
        model.addAttribute("livros", livroService.obterLista());

        return "index";
    } 
}
