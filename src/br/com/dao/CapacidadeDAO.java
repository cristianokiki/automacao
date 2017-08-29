/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conexao.ConnectionFactory;
import br.com.exception.GenericSqlException;
import br.com.model.Capacidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Cristiano
 */
public class CapacidadeDAO extends GenericDAO {

    public boolean add(Capacidade capacidade) throws GenericSqlException {
        if (capacidade.getCap_descricao() == null) {
            throw new GenericSqlException("Capacidade nula.");
        }
        if (findCapacidade(capacidade) != null) {
            throw new GenericSqlException("Capacidade já existente.");
        }
        String insert = "INSERT INTO capacidade(cap_descricao) VALUES(?)";
        try {
            this.insert(insert, capacidade.getCap_descricao());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoInsert = false;
        if (findCapacidade(capacidade) != null) {
            resultadoInsert = true;
        }
        return resultadoInsert;
    }

    public boolean edit(Capacidade capacidade) throws GenericSqlException {
        if (capacidade.getCap_descricao() == null || capacidade.getCap_id() == null) {
            throw new GenericSqlException("Capacidade(descrição/id) nulo.");
        }
        if (findCapacidade(capacidade) != null) {
            throw new GenericSqlException("Capacidade já existente.");
        }
        String update = "UPDATE capacidade SET cap_descricao = ? WHERE cap_id = ?";
        try {
            this.update(update, capacidade.getCap_id(), capacidade.getCap_descricao());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoUpdate = false;
        if (Objects.equals(findIdCapacidade(capacidade), capacidade.getCap_descricao())) {
            resultadoUpdate = true;
        }
        return resultadoUpdate;
    }

    public boolean delete(Capacidade capacidade) throws GenericSqlException {
        if (capacidade.getCap_id() == null) {
            throw new GenericSqlException("Capacidade(id) nulo.");
        }
        if (findIdCapacidade(capacidade) == null) {
            throw new GenericSqlException("Tentativa de exclusão falhou, capacidade inexistente.");
        }
        Integer qtdCap = this.countCapacidade(capacidade);
        if (qtdCap > 0) {
            throw new GenericSqlException("Exclusão não permitida, essa capacidade foi usada " + qtdCap + " vezes na tabela produto.");
        }
        String delete = "DELETE FROM capacidade WHERE cap_id = ?";
        try {
            delete(delete, capacidade.getCap_id());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoDelete = false;
        if (findIdCapacidade(capacidade) == null) {
            resultadoDelete = true;
        }
        return resultadoDelete;
    }

    public List list() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cap_id, cap_descricao FROM capacidade ORDER BY cap_descricao";
        List listaCap = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            listaCap = new ArrayList();
            while (rs.next()) {
                Capacidade cap = new Capacidade();
                cap.setCap_descricao(rs.getInt("cap_descricao"));
                cap.setCap_id(rs.getInt("cap_id"));
                listaCap.add(cap);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaCap;
    }

    public Integer findCapacidade(Capacidade capacidade) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cap_id FROM capacidade WHERE cap_descricao = ?";
        Integer cap_id = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, capacidade.getCap_descricao());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    cap_id = rs.getInt("cap_id");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return cap_id;
    }

    public Integer findIdCapacidade(Capacidade capacidade) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cap_descricao FROM capacidade WHERE cap_id = ?";
        Integer cap_descricao = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, capacidade.getCap_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    cap_descricao = rs.getInt("cap_descricao");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return cap_descricao;
    }

    public List listTab() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cap_id, cap_descricao FROM capacidade ORDER BY cap_descricao";
        List listaCap = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            listaCap = new ArrayList();
            while (rs.next()) {
                Capacidade cap = new Capacidade();
                cap.setCap_descricao(rs.getInt("cap_descricao"));
                cap.setCap_id(rs.getInt("cap_id"));

                Object[] linhaTab = {cap.getCap_id(), cap.getCap_descricao()};
                listaCap.add(linhaTab);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaCap;
    }

    public Integer lastCapacidade() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cap_descricao FROM capacidade WHERE cap_id = (SELECT MAX(cap_id) FROM capacidade)";
        Integer cap_descricao = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            if (rs.first()) {
                cap_descricao = rs.getInt("cap_descricao");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return cap_descricao;
    }

    private Integer countCapacidade(Capacidade capacidade) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT COUNT(cap_id) AS total FROM produto WHERE cap_id = ?";
        Integer qtdCap = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, capacidade.getCap_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    qtdCap = rs.getInt("total");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return qtdCap;
    }
}
