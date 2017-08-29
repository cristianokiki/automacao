/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.VendaDAO;
import br.com.exception.GenericSqlException;
import br.com.model.Produto;
import br.com.model.Venda;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class VendaCntrl {
    
    private final VendaDAO vendaDAO;
    
    public VendaCntrl() {
        vendaDAO = new VendaDAO();
    }
    
    public void salvar(Integer prod_id, Integer quantidade) throws GenericSqlException {
        Produto prod = new Produto();
        prod.setProd_id(prod_id);
        
        Venda venda = new Venda();
        venda.setProduto(prod);
        venda.setQuantidade(quantidade);
        vendaDAO.add(venda);
    }
    
    public boolean alterar(Long mov_id, Integer prod_id, Integer quantidade) throws GenericSqlException {
        Produto prod = new Produto();
        prod.setProd_id(prod_id);
        Venda venda = new Venda();
        venda.setMov_id(mov_id);
        venda.setProduto(prod);
        venda.setQuantidade(quantidade);
        return vendaDAO.edit(venda);
    }
    
    public boolean apagar(Long mov_id) throws GenericSqlException {
        Venda venda = new Venda();
        venda.setMov_id(mov_id);
        
        return vendaDAO.delete(venda);
    }
    
    public List buscaListaTabela(String data) {
        Venda venda = new Venda();
        venda.setData(data);
        return vendaDAO.listFindTab(venda);
    }
}
