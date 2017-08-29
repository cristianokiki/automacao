/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.EstoqueDAO;
import br.com.exception.GenericSqlException;
import br.com.model.Capacidade;
import br.com.model.Categoria;
import br.com.model.Estoque;
import br.com.model.Produto;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class EstoqueCntrl {

    private final EstoqueDAO estDAO;

    public EstoqueCntrl() {
        estDAO = new EstoqueDAO();
    }

    public void salvar(Integer prod_id, Integer quantidade) throws GenericSqlException {
        Produto prod = new Produto();
        prod.setProd_id(prod_id);

        Estoque estoque = new Estoque();
        estoque.setProduto(prod);
        estoque.setQuantidade(quantidade);
        estDAO.add(estoque);
    }

    public boolean alterar(Long mov_id, Integer quantidade) throws GenericSqlException {
        Estoque estoque = new Estoque();
        estoque.setMov_id(mov_id);
        estoque.setQuantidade(quantidade);
        return estDAO.edit(estoque);
    }

    public boolean apagar(Long mov_id) throws GenericSqlException {
        Estoque estoque = new Estoque();
        estoque.setMov_id(mov_id);
        return estDAO.delete(estoque);
    }

    public List listarTab(Integer capacidade, String categoria) {
        Capacidade cap = new Capacidade();
        cap.setCap_descricao(capacidade);

        Categoria cat = new Categoria();
        cat.setCat_descricao(categoria);

        Produto prod = new Produto();
        prod.setCapacidade(cap);
        prod.setCategoria(cat);

        Estoque est = new Estoque();
        est.setProduto(prod);
        return estDAO.listTab(est);
    }

    public List listarRetornoTab(String data) {
        Estoque est = new Estoque();
        est.setData(data);
        return estDAO.listRetornoTab(est);
    }
}
