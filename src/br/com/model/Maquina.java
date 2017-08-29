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
public class Maquina {

    private Integer maq_id;
    private String maq_descricao;

    public Maquina() {
    }

    public Integer getMaq_id() {
        return maq_id;
    }

    public void setMaq_id(Integer maq_id) {
        this.maq_id = maq_id;
    }

    public String getMaq_descricao() {
        return maq_descricao;
    }

    public void setMaq_descricao(String maq_descricao) {
        this.maq_descricao = maq_descricao;
    }

    @Override
    public String toString() {
        return maq_descricao;
    }
}
