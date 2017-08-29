/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.MaquinaDAO;
import br.com.exception.GenericSqlException;
import br.com.model.Maquina;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class MaquinaCntrl {

    private final MaquinaDAO maqDAO;

    public MaquinaCntrl() {
        maqDAO = new MaquinaDAO();
    }

    public boolean salvar(String maquina) throws GenericSqlException {
        Maquina maq = new Maquina();
        maq.setMaq_descricao(maquina);
        return maqDAO.add(maq);
    }

    public boolean alterar(Integer maq_id, String novaMaquina) throws GenericSqlException {
        Maquina maq = new Maquina();
        maq.setMaq_descricao(novaMaquina);
        maq.setMaq_id(maq_id);
        return maqDAO.edit(maq);
    }

    public boolean apagar(Integer maq_id) throws GenericSqlException {
        Maquina maq = new Maquina();
        maq.setMaq_id(maq_id);
        return maqDAO.delete(maq);
    }

    public List listar() {
        return maqDAO.list();
    }

    public Integer buscarMaquina(String maquina) {
        Maquina maq = new Maquina();
        maq.setMaq_descricao(maquina);
        return maqDAO.findMaquina(maq);
    }

    public String buscarIdMaquina(Integer maq_id) {
        Maquina maq = new Maquina();
        maq.setMaq_id(maq_id);
        return maqDAO.findIdMaquina(maq);
    }
    
    public List listarTabela() {
        return maqDAO.listTab();
    }
}
