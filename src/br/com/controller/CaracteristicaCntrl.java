/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.exception.GenericSqlException;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class CaracteristicaCntrl {

    private Caracteristica caract = null;
    private String descricao = null;
    private Integer id = null;

    public void setCaract(Caracteristica caract) {
        this.caract = caract;
    }

    public Caracteristica getCaract() {
        return caract;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean adicionar() throws GenericSqlException {
        return this.caract.salvar(descricao);
    }

    public boolean apagar() throws GenericSqlException {
        return this.caract.apagar(id);
    }

    public boolean alterar() throws GenericSqlException {
        return this.caract.alterar(id, descricao);
    }

    public List listar() {
        return this.caract.listar();
    }

    public List listarTab() {
        return this.caract.listarTabela();
    }

}
