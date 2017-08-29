/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conexao.ConnectionFactory;
import br.com.exception.GenericSqlException;
import br.com.model.Cor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class CorDAO extends GenericDAO {

    public boolean add(Cor cor) throws GenericSqlException {
        if (cor.getCor_descricao() == null || cor.getCor_descricao().isEmpty()) {
            throw new GenericSqlException("Cor vazia ou nula");
        }
        if (findCor(cor) != null) {
            throw new GenericSqlException("Cor já existente.");
        }
        String insert = "INSERT INTO cor(cor_descricao) VALUES(?)";
        try {
            insert(insert, cor.getCor_descricao());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoInsert = false;
        if (findCor(cor) != null) {
            resultadoInsert = true;
        }
        return resultadoInsert;
    }

    public boolean edit(Cor cor) throws GenericSqlException {
        if (cor.getCor_descricao() == null || cor.getCor_descricao().isEmpty() || cor.getCor_id() == null) {
            throw new GenericSqlException("Cor(descrição/id) vazio ou nulo.");
        }
        if (findCor(cor) != null) {
            throw new GenericSqlException("Cor já existente");
        }
        String update = "UPDATE cor SET cor_descricao = ? WHERE cor_id = ?";
        try {
            update(update, cor.getCor_id(), cor.getCor_descricao());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoUpdate = false;
        if (findIdCor(cor).equals(cor.getCor_descricao())) {
            resultadoUpdate = true;
        }
        return resultadoUpdate;
    }

    public boolean delete(Cor cor) throws GenericSqlException {
        if (cor.getCor_id() == null) {
            throw new GenericSqlException("Cor(id) nulo.");
        }
        if (findIdCor(cor) == null) {
            throw new GenericSqlException("Tentativa de exclusão falhou, cor inexistente.");
        }
        Integer qtdCor = this.countCor(cor);
        if (qtdCor > 0) {
            throw new GenericSqlException("Exclusão não permitida, essa cor foi usada " + qtdCor + " vezes na tabela produto.");
        }
        String delete = "DELETE FROM cor WHERE cor_id = ?";
        try {
            delete(delete, cor.getCor_id());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoDelete = false;
        if (findIdCor(cor) == null) {
            resultadoDelete = true;
        }
        return resultadoDelete;
    }

    public List list() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cor_id, cor_descricao FROM cor ORDER BY cor_descricao";
        List listaCor = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            listaCor = new ArrayList();
            while (rs.next()) {
                Cor c = new Cor();
                c.setCor_descricao(rs.getString("cor_descricao"));
                c.setCor_id(rs.getInt("cor_id"));
                listaCor.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaCor;
    }

    public Integer findCor(Cor cor) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cor_id FROM cor WHERE cor_descricao = ?";
        Integer cor_id = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setString(1, cor.getCor_descricao());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    cor_id = rs.getInt("cor_id");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return cor_id;
    }

    public String findIdCor(Cor cor) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cor_descricao FROM cor WHERE cor_id = ?";
        String cor_descricao = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, cor.getCor_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    cor_descricao = rs.getString("cor_descricao");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return cor_descricao;
    }

    public List listTab() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cor_id, cor_descricao FROM cor ORDER BY cor_descricao";
        List listaTab = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            listaTab = new ArrayList();
            while (rs.next()) {
                Cor cor = new Cor();
                cor.setCor_id(rs.getInt("cor_id"));
                cor.setCor_descricao(rs.getString("cor_descricao"));

                Object[] linhaTab = {cor.getCor_id(), cor.getCor_descricao()};
                listaTab.add(linhaTab);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaTab;
    }

    public String lastCor() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cor_descricao FROM cor WHERE cor_id = (SELECT MAX(cor_id) FROM cor)";
        String cor_descricao = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            if (rs.first()) {
                cor_descricao = rs.getString("cor_descricao");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return cor_descricao;
    }

    private Integer countCor(Cor cor) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT COUNT(cor_id) AS total FROM produto WHERE cor_id = ?";
        Integer qtdCor = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, cor.getCor_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    qtdCor = rs.getInt("total");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return qtdCor;
    }
}
