/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conexao.ConnectionFactory;
import br.com.exception.GenericSqlException;
import br.com.model.Categoria;
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
public class CategoriaDAO extends GenericDAO {

    public boolean add(Categoria categoria) throws GenericSqlException {
        if (categoria.getCat_descricao() == null || categoria.getCat_descricao().isEmpty()) {
            throw new GenericSqlException("Categoria vazia ou nula.");
        }
        if (findCategoria(categoria) != null) {
            throw new GenericSqlException("Categoria já existente.");
        }
        String insert = "INSERT INTO categoria(cat_descricao) VALUES(?)";
        try {
            insert(insert, categoria.getCat_descricao());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoInsert = false;
        if (findCategoria(categoria) != null) {
            resultadoInsert = true;
        }
        return resultadoInsert;
    }

    public boolean edit(Categoria categoria) throws GenericSqlException {
        if (categoria.getCat_descricao() == null || categoria.getCat_descricao().isEmpty() || categoria.getCat_id() == null) {
            throw new GenericSqlException("Categoria(descrição/id) vazia ou nula.");
        }
        if (findCategoria(categoria) != null) {
            throw new GenericSqlException("Categoria já existente.");
        }
        String update = "UPDATE categoria SET cat_descricao = ? WHERE cat_id = ?";
        try {
            update(update, categoria.getCat_id(), categoria.getCat_descricao());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoUpdate = false;
        if (findIdCategoria(categoria).equals(categoria.getCat_descricao())) {
            resultadoUpdate = true;
        }
        return resultadoUpdate;
    }

    public boolean delete(Categoria categoria) throws GenericSqlException {
        if (categoria.getCat_id() == null) {
            throw new GenericSqlException("Categoria(id) nulo");
        }
        if (findIdCategoria(categoria) == null) {
            throw new GenericSqlException("Tentativa de exclusão falhou, categoria inexistente.");
        }
        Integer qtdCat = this.countCategoria(categoria);
        if (qtdCat > 0) {
            throw new GenericSqlException("Exclusão não permitida, essa categoria foi usada " + qtdCat + " vezes na tabela produto.");
        }
        String delete = "DELETE FROM categoria WHERE cat_id = ?";
        try {
            delete(delete, categoria.getCat_id());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoDelete = false;
        if (findIdCategoria(categoria) == null) {
            resultadoDelete = true;
        }
        return resultadoDelete;
    }

    public List list() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cat_id, cat_descricao FROM categoria ORDER BY cat_descricao";
        List listaCategoria = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            listaCategoria = new ArrayList();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setCat_descricao(rs.getString("cat_descricao"));
                cat.setCat_id(rs.getInt("cat_id"));
                listaCategoria.add(cat);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaCategoria;
    }

    public Integer findCategoria(Categoria categoria) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cat_id FROM categoria WHERE cat_descricao = ?";
        Integer cat_id = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setString(1, categoria.getCat_descricao());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    cat_id = rs.getInt("cat_id");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return cat_id;
    }

    public String findIdCategoria(Categoria categoria) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cat_descricao FROM categoria WHERE cat_id = ?";
        String cat_descricao = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, categoria.getCat_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    cat_descricao = rs.getString("cat_descricao");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return cat_descricao;
    }

    public List listTab() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cat_id, cat_descricao FROM categoria ORDER BY cat_descricao";
        List listaTab = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            listaTab = new ArrayList();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setCat_descricao(rs.getString("cat_descricao"));
                cat.setCat_id(rs.getInt("cat_id"));

                Object[] linhaTab = {cat.getCat_id(), cat.getCat_descricao()};
                listaTab.add(linhaTab);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaTab;
    }

    public String lastCategoria() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cat_descricao FROM categoria WHERE cat_id = (SELECT MAX(cat_id) FROM categoria)";
        String cat_descricao = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            if (rs.first()) {
                cat_descricao = rs.getString("cat_descricao");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return cat_descricao;
    }

    private Integer countCategoria(Categoria categoria) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT COUNT(cat_id) AS total FROM produto WHERE cat_id = ?";
        Integer qtdCat = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, categoria.getCat_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    qtdCat = rs.getInt("total");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return qtdCat;
    }
}
