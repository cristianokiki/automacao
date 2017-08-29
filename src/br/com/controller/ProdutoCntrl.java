/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.ProdutoDAO;
import br.com.exception.GenericSqlException;
import br.com.model.Capacidade;
import br.com.model.Categoria;
import br.com.model.Cor;
import br.com.model.Produto;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class ProdutoCntrl {

    private final ProdutoDAO prodDAO;

    public ProdutoCntrl() {
        prodDAO = new ProdutoDAO();
    }

    public boolean salvar(Integer cap_id, Integer cat_id, Integer cor_id) throws GenericSqlException {
        Capacidade cap = new Capacidade();
        cap.setCap_id(cap_id);

        Categoria cat = new Categoria();
        cat.setCat_id(cat_id);

        Cor cor = new Cor();
        cor.setCor_id(cor_id);

        Produto prod = new Produto();
        prod.setCapacidade(cap);
        prod.setCategoria(cat);
        prod.setCor(cor);
        return prodDAO.add(prod);
    }

    public boolean alterar(Integer prod_id, Integer cap_id, Integer cat_id, Integer cor_id) throws GenericSqlException {
        Capacidade cap = new Capacidade();
        cap.setCap_id(cap_id);

        Categoria cat = new Categoria();
        cat.setCat_id(cat_id);

        Cor cor = new Cor();
        cor.setCor_id(cor_id);

        Produto prod = new Produto();
        prod.setCapacidade(cap);
        prod.setCategoria(cat);
        prod.setCor(cor);
        prod.setProd_id(prod_id);
        return prodDAO.edit(prod);
    }

    public boolean apagar(Integer prod_id) throws GenericSqlException {
        Produto prod = new Produto();
        prod.setProd_id(prod_id);
        return prodDAO.delete(prod);
    }

    public Integer buscarProduto(Integer cap_id, Integer cat_id, Integer cor_id) {
        Capacidade cap = new Capacidade();
        cap.setCap_id(cap_id);

        Categoria cat = new Categoria();
        cat.setCat_id(cat_id);

        Cor cor = new Cor();
        cor.setCor_id(cor_id);

        Produto prod = new Produto();
        prod.setCapacidade(cap);
        prod.setCategoria(cat);
        prod.setCor(cor);
        return prodDAO.findProduto(prod);
    }

    public Integer[] buscarIdProduto(Integer prod_id) {
        Produto prod = new Produto();
        prod.setProd_id(prod_id);
        return prodDAO.findIdProduto(prod);
    }

    public List listarBuscaTabela(String categoria, Integer capacidade) {
        Categoria cat = new Categoria();
        cat.setCat_descricao(categoria);

        Capacidade cap = new Capacidade();
        cap.setCap_descricao(capacidade);

        Produto prod = new Produto();
        prod.setCapacidade(cap);
        prod.setCategoria(cat);
        return prodDAO.listFindTab(prod);
    }
}
