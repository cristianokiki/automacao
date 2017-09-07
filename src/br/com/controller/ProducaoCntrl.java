/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.ProducaoDAO;
import br.com.exception.GenericSqlException;
import br.com.model.Capacidade;
import br.com.model.Categoria;
import br.com.model.Cor;
import br.com.model.Maquina;
import br.com.model.Producao;
import br.com.model.Produto;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class ProducaoCntrl {

    private final ProducaoDAO producDAO;

    public ProducaoCntrl() {
        producDAO = new ProducaoDAO();
    }

    public synchronized void salvar(Integer prod_id, Integer maq_id) throws GenericSqlException {
        Maquina maq = new Maquina();
        maq.setMaq_id(maq_id);

        Produto prod = new Produto();
        prod.setProd_id(prod_id);

        Producao produc = new Producao();
        produc.setMaquina(maq);
        produc.setProduto(prod);
        producDAO.add(produc);
    }

    public synchronized void apagar(Integer prod_id, Integer maq_id) throws GenericSqlException {
        Maquina maq = new Maquina();
        maq.setMaq_id(maq_id);

        Produto prod = new Produto();
        prod.setProd_id(prod_id);

        Producao produc = new Producao();
        produc.setMaquina(maq);
        produc.setProduto(prod);
        producDAO.delete(produc);
    }

    public List listarDet(String categoria, Integer capacidade, String cor, String maquina, String data, String hora) {
        Capacidade cap = new Capacidade();
        cap.setCap_descricao(capacidade);

        Categoria cat = new Categoria();
        cat.setCat_descricao(categoria);

        Cor c = new Cor();
        c.setCor_descricao(cor);

        Produto prod = new Produto();
        prod.setCapacidade(cap);
        prod.setCategoria(cat);
        prod.setCor(c);

        Maquina maq = new Maquina();
        maq.setMaq_descricao(maquina);

        Producao producao = new Producao();
        producao.setData(data);
        producao.setHora(hora);
        producao.setProduto(prod);
        producao.setMaquina(maq);
        return producDAO.listDetTab(producao);
    }

    public List listarBuscaMaq(String data) {
        Producao producao = new Producao();
        producao.setData(data);
        return producDAO.listFindTotalMaq(producao);
    }

//    public List listarBuscarDetMaq(String maquina, String data) {
//        Maquina maq = new Maquina();
//        maq.setMaq_descricao(maquina);
//        Producao producao = new Producao();
//        producao.setData(data);
//        producao.setMaquina(maq);
//        return producDAO.listDetMaq(producao);
//    }

    public List listarDiaTab(String data) {
        Producao produc = new Producao();
        produc.setData(data);
        return producDAO.listFindDay(produc);
    }

    public List listarSemanaTab() {
        return producDAO.listWeekTab();
    }

    public List listarMesTab() {
        return producDAO.listMonthTab();
    }

}
