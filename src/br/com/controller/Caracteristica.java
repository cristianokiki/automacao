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
public interface Caracteristica {

    public boolean salvar(String descricao) throws GenericSqlException;

    public boolean alterar(Integer id, String descricao) throws GenericSqlException;

    public boolean apagar(Integer id) throws GenericSqlException;

    public List listar();

    public abstract List listarTabela();

}
