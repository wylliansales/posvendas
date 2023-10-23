package com.example.posvendas.posvenda.model.domain;

public class Brinquedo extends Produto{
    private int idadeRecomendada;
    private String genero;
    private String marca;
    private String tipoDeBrinquedo;

    public int getIdadeRecomendada() {
        return this.idadeRecomendada;
    }

    public void setIdadeRecomendada(int idadeRecomendada) {
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
