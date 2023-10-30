package com.example.posvendas.posvenda.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.posvendas.posvenda.model.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
    
    @Query("from Produto p where p.vendedor.id = :idVendedor")
    Collection<Produto> obterLista(Integer idVendedor);
}
