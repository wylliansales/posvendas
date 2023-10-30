package com.example.posvendas.posvenda.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBrinquedo")
public class Brinquedo extends Produto{
    private String idadeRecomendada;
    private String genero;
    private String marca;
    private String tipoDeBrinquedo;

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s - %s", super.toString(), idadeRecomendada, genero, marca, tipoDeBrinquedo);
    }

    public String getIdadeRecomendada() {
        return this.idadeRecomendada;
    }

    public void setIdadeRecomendada(String idadeRecomendada) {
        this.idadeRecomendada = idadeRecomendada;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoDeBrinquedo() {
        return this.tipoDeBrinquedo;
    }

    public void setTipoDeBrinquedo(String tipoDeBrinquedo) {
        this.tipoDeBrinquedo = tipoDeBrinquedo;
    }

}
