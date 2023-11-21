package com.example.posvendas.posvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.posvendas.posvenda.model.services.BrinquedoService;
import com.example.posvendas.posvenda.model.services.LivroService;
import com.example.posvendas.posvenda.model.services.ProdutoService;
import com.example.posvendas.posvenda.model.services.VendedorService;

@Controller
public class AppController {

    @Autowired
    private VendedorService vendedorService;
    
    @Autowired
    private BrinquedoService brinquedoService;

    @Autowired
    private LivroService livroService;

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/index")
    public String index(ModelMap model) {
        model.addAttribute("vendedores", vendedorService.obterLista());
        model.addAttribute("brinquedos", brinquedoService.obterLista());
        model.addAttribute("livros", livroService.obterLista());

        return "index";
    }
    
    @GetMapping(value = "/produto/lista")
    public String obterListaProduto(ModelMap model) {

        model.addAttribute("titulo", "Produtos:");
        model.addAttribute("listagem", produtoService.obterLista());

        return index(model);
    }

    @GetMapping(value = "/livro/lista")
    public String obterListaLivro(ModelMap model) {

        model.addAttribute("titulo", "Produtos Livro:");
        model.addAttribute("listagem", livroService.obterLista());

        return index(model);
    }

    @GetMapping(value = "/brinquedo/lista")
    public String obterListaEletronico(ModelMap model) {

        model.addAttribute("titulo", "Produtos Brinquedos:");
        model.addAttribute("listagem", brinquedoService.obterLista());

        return index(model);
    }
}
