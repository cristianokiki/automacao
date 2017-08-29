/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.CorDAO;
import br.com.exception.GenericSqlException;
import br.com.model.Cor;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class CorCntrl implements Caracteristica {

    private final CorDAO corDAO;

    public CorCntrl() {
        corDAO = new CorDAO();
    }

    @Override
    public boolean salvar(String cor) throws GenericSqlException {
        Cor c = new Cor();
        c.setCor_descricao(cor);
        return corDAO.add(c);
    }

    @Override
    public boolean alterar(Integer cor_id, String novaCor) throws GenericSqlException {
        Cor c = new Cor();
        c.setCor_descricao(novaCor);
        c.setCor_id(cor_id);
        return corDAO.edit(c);
    }

    @Override
    public boolean apagar(Integer cor_id) throws GenericSqlException {
        Cor c = new Cor();
        c.setCor_id(cor_id);
        return corDAO.delete(c);
    }

    @Override
    public List listar() {
        return corDAO.list();
    }

    public Integer buscarCor(String cor) {
        Cor c = new Cor();
        c.setCor_descricao(cor);
        return corDAO.findCor(c);
    }

    public String buscarIdCor(Integer cor_id) {
        Cor c = new Cor();
        c.setCor_id(cor_id);
        return corDAO.findIdCor(c);
    }

    @Override
    public List listarTabela() {
        return corDAO.listTab();
    }

    public String ultimaCor() {
        return corDAO.lastCor();
    }
}
