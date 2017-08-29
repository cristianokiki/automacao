/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Cristiano
 */
public abstract class GenericDAO {
    
    public GenericDAO() {
    }
    
    public void insert(String insert, Object... atributo) throws SQLException {
        Connection conexao = ConnectionFactory.getConecta();
        try (PreparedStatement ps = conexao.prepareStatement(insert)) {
            for (int i = 0; i < atributo.length; i++) {
                ps.setObject(i + 1, atributo[i]);
            }
            ps.execute();
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        
    }
    
    public void update(String update, Object id, Object... atributo) throws SQLException {
        Connection conexao = ConnectionFactory.getConecta();
        try (PreparedStatement ps = conexao.prepareStatement(update)) {
            for (int i = 0; i < atributo.length; i++) {
                ps.setObject(i + 1, atributo[i]);
            }
            ps.setObject(atributo.length + 1, id);
            ps.execute();
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
    }
    
    public void delete(String delete, Object... atributo) throws SQLException {
        Connection conexao = ConnectionFactory.getConecta();
        try (PreparedStatement ps = conexao.prepareStatement(delete)) {
            for (int i = 0; i < atributo.length; i++) {
                ps.setObject(i + 1, atributo[i]);
            }
            ps.execute();
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
    }
}
