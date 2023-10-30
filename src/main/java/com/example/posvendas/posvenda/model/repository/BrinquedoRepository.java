package com.example.posvendas.posvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.posvendas.posvenda.model.domain.Brinquedo;

@Repository
public interface BrinquedoRepository extends CrudRepository<Brinquedo, Integer>{
    
}
