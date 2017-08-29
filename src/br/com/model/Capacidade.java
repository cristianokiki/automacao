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
public class Capacidade {

    private Integer cap_id;
    private Integer cap_descricao;

    public Capacidade() {
    }

    public Integer getCap_id() {
        return cap_id;
    }

    public void setCap_id(Integer cap_id) {
        this.cap_id = cap_id;
    }

    public Integer getCap_descricao() {
        return cap_descricao;
    }

    public void setCap_descricao(Integer cap_descricao) {
        this.cap_descricao = cap_descricao;
    }

    @Override
    public String toString() {
        return cap_descricao.toString();
    }

}
