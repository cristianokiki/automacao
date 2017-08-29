/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conexao.ConnectionFactory;
import br.com.exception.GenericSqlException;
import br.com.model.Maquina;
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
public class MaquinaDAO extends GenericDAO {

    public boolean add(Maquina maquina) throws GenericSqlException {
        if (maquina.getMaq_descricao() == null || maquina.getMaq_descricao().isEmpty()) {
            throw new GenericSqlException("Máquina vazia ou nula.");
        }
        if (findMaquina(maquina) != null) {
            throw new GenericSqlException("Máquina já existente.");
        }
        String insert = "INSERT INTO maquina(maq_descricao) VALUES(?)";
        try {
            insert(insert, maquina.getMaq_descricao());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoInset = false;
        if (findMaquina(maquina) != null) {
            resultadoInset = true;
        }
        return resultadoInset;
    }

    public boolean edit(Maquina maquina) throws GenericSqlException {
        if (maquina.getMaq_descricao() == null || maquina.getMaq_descricao().isEmpty() || maquina.getMaq_id() == null) {
            throw new GenericSqlException("Máquina(descricao/id) vaio ou nulo.");
        }
        if (findMaquina(maquina) != null) {
            throw new GenericSqlException("Máquina já existente.");
        }
        String update = "UPDATE maquina SET maq_descricao = ? WHERE maq_id = ?";
        try {
            update(update, maquina.getMaq_id(), maquina.getMaq_descricao());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoUpdate = false;
        if (findIdMaquina(maquina).equals(maquina.getMaq_descricao())) {
            resultadoUpdate = true;
        }
        return resultadoUpdate;
    }

    public boolean delete(Maquina maquina) throws GenericSqlException {
        if (maquina.getMaq_id() == null) {
            throw new GenericSqlException("Máquina(id) nulo");
        }
        if (findIdMaquina(maquina) == null) {
            throw new GenericSqlException("Tentativa de exclusão falhou, máquina inexistente.");
        }
        Integer qtdMaq = this.countMaquina(maquina);
        if (qtdMaq > 0) {
            throw new GenericSqlException("Exclusão não permitida, essa máquina foi usada " + qtdMaq + " veses na tabela movimentação.");
        }
        String delete = "DELETE FROM maquina WHERE maq_id = ?";
        try {
            delete(delete, maquina.getMaq_id());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex);
        }
        boolean resultadoDelete = false;
        if (findIdMaquina(maquina) == null) {
            resultadoDelete = true;
        }
        return resultadoDelete;
    }

    public List list() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT maq_id, maq_descricao FROM maquina ORDER BY maq_descricao";
        List listaMaquina = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            listaMaquina = new ArrayList();
            while (rs.next()) {
                Maquina maq = new Maquina();
                maq.setMaq_descricao(rs.getString("maq_descricao"));
                maq.setMaq_id(rs.getInt("maq_id"));
                listaMaquina.add(maq);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaMaquina;
    }

    public Integer findMaquina(Maquina maquina) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT maq_id FROM maquina WHERE maq_descricao = ?";
        Integer maq_id = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setString(1, maquina.getMaq_descricao());
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                maq_id = rs.getInt("maq_id");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return maq_id;
    }

    public String findIdMaquina(Maquina maquina) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT maq_descricao FROM maquina WHERE maq_id = ?";
        String maq_descricao = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, maquina.getMaq_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    maq_descricao = rs.getString("maq_descricao");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return maq_descricao;
    }

    public List listTab() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT maq_id, maq_descricao FROM maquina ORDER BY maq_descricao";
        List listaTab = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            listaTab = new ArrayList();
            while (rs.next()) {
                Maquina maq = new Maquina();
                maq.setMaq_descricao(rs.getString("maq_descricao"));
                maq.setMaq_id(rs.getInt("maq_id"));

                Object[] linhaTab = {maq.getMaq_id(), maq.getMaq_descricao()};
                listaTab.add(linhaTab);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaTab;
    }

    private Integer countMaquina(Maquina maquina) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT COUNT(maq_id) AS total FROM movimentacao WHERE maq_id = ?";
        Integer qtdMaq = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, maquina.getMaq_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    qtdMaq = rs.getInt("total");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return qtdMaq;
    }
}
