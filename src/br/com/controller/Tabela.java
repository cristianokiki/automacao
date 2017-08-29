/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cristiano
 */
public class Tabela extends AbstractTableModel {

    List<Object[]> linha = null;
    String[] coluna = null;

    public Tabela(List<Object[]> linha, String[] coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    @Override
    public int getRowCount() {
        return this.linha.size();
    }

    @Override
    public int getColumnCount() {
        return this.coluna.length;
    }

    @Override
    public String getColumnName(int num) {
        return this.coluna[num];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object[] obj = linha.get(row);
        return obj[column];
    }

}
