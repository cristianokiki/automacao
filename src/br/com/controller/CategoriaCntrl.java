/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.CategoriaDAO;
import br.com.exception.GenericSqlException;
import br.com.model.Categoria;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class CategoriaCntrl implements Caracteristica {

    private final CategoriaDAO catDAO;

    public CategoriaCntrl() {
        catDAO = new CategoriaDAO();
    }

    @Override
    public boolean salvar(String categoria) throws GenericSqlException {
        Categoria cat = new Categoria();
        cat.setCat_descricao(categoria);
        return catDAO.add(cat);
    }

    @Override
    public boolean alterar(Integer cat_id, String novaCategoria) throws GenericSqlException {
        Categoria cat = new Categoria();
        cat.setCat_descricao(novaCategoria);
        cat.setCat_id(cat_id);
        return catDAO.edit(cat);
    }

    @Override
    public boolean apagar(Integer cat_id) throws GenericSqlException {
        Categoria cat = new Categoria();
        cat.setCat_id(cat_id);
        return catDAO.delete(cat);
    }

    @Override
    public List listar() {
        return catDAO.list();
    }

    public Integer buscarCategoria(String categoria) {
        Categoria cat = new Categoria();
        cat.setCat_descricao(categoria);
        return catDAO.findCategoria(cat);
    }

    public String buscarIdCategoria(Integer cat_id) {
        Categoria cat = new Categoria();
        cat.setCat_id(cat_id);
        return catDAO.findIdCategoria(cat);
    }

    @Override
    public List listarTabela() {
        return catDAO.listTab();
    }

    public String ultimaCategoria() {
        return catDAO.lastCategoria();
    }
}
