/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.CapacidadeDAO;
import br.com.exception.GenericSqlException;
import br.com.model.Capacidade;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class CapacidadeCntrl implements Caracteristica {

    private final CapacidadeDAO capDAO;

    public CapacidadeCntrl() {
        capDAO = new CapacidadeDAO();
    }

    @Override
    public boolean salvar(String capacidade) throws GenericSqlException {
        Capacidade cap = new Capacidade();
        try {
            Integer capacit = Integer.parseInt(capacidade);
            cap.setCap_descricao(capacit);
        } catch (NumberFormatException ex) {
            throw new GenericSqlException("Formato de número inválido!\n" + ex.getMessage());
        }
        return capDAO.add(cap);
    }

    @Override
    public boolean alterar(Integer cap_id, String novaCapacidade) throws GenericSqlException {
        Capacidade cap = new Capacidade();
        cap.setCap_id(cap_id);
        try {
            Integer novaCap = Integer.parseInt(novaCapacidade);
            cap.setCap_descricao(novaCap);
        } catch (NumberFormatException ex) {
            throw new GenericSqlException("Formato de número inválido!\n" + ex.getMessage());
        }
        return capDAO.edit(cap);
    }

    @Override
    public boolean apagar(Integer cap_id) throws GenericSqlException {
        Capacidade cap = new Capacidade();
        cap.setCap_id(cap_id);
        return capDAO.delete(cap);
    }

    @Override
    public List listar() {
        return capDAO.list();
    }

    public Integer buscarCapacidade(Integer capacidade) {
        Capacidade cap = new Capacidade();
        cap.setCap_descricao(capacidade);
        return capDAO.findCapacidade(cap);
    }

    public Integer buscarIdCapacidade(Integer capacidade) {
        Capacidade cap = new Capacidade();
        cap.setCap_id(capacidade);
        return this.capDAO.findIdCapacidade(cap);
    }

    @Override
    public List listarTabela() {
        return capDAO.listTab();
    }

    public Integer ultimaCapacidade() {
        return capDAO.lastCapacidade();
    }

}
