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
public class Cor {

    private Integer cor_id;
    private String cor_descricao;

    public Cor() {
    }

    public Integer getCor_id() {
        return cor_id;
    }

    public void setCor_id(Integer cor_id) {
        this.cor_id = cor_id;
    }

    public String getCor_descricao() {
        return cor_descricao;
    }

    public void setCor_descricao(String cor_descricao) {
        this.cor_descricao = cor_descricao;
    }

    @Override
    public String toString() {
        return cor_descricao;
    }

}
