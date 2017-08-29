/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author Cristiano
 */
public class Produto {

    private Integer prod_id;
    private Capacidade capacidade;
    private Categoria categoria;
    private Cor cor;

    public Produto() {
    }

    public Integer getProd_id() {
        return prod_id;
    }

    public void setProd_id(Integer prod_id) {
        this.prod_id = prod_id;
    }

    public Capacidade getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Capacidade capacidade) {
        this.capacidade = capacidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return categoria + " " + capacidade + " " + cor;
    }

}
