/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conexao.ConnectionFactory;
import br.com.exception.GenericSqlException;
import br.com.model.Capacidade;
import br.com.model.Categoria;
import br.com.model.Cor;
import br.com.model.Produto;
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
public class ProdutoDAO extends GenericDAO {

    public boolean add(Produto produto) throws GenericSqlException {
        if (produto.getCapacidade().getCap_id() == null || produto.getCategoria().getCat_id() == null || produto.getCor().getCor_id() == null) {
            throw new GenericSqlException("Produto(cap_id/cat_id/cor_id) nulo.");
        }
        if (findProduto(produto) != null) {
            throw new GenericSqlException("Produto já existente.");
        }
        String insert = "INSERT INTO produto(cap_id, cat_id, cor_id) VALUES(?, ?, ?)";
        try {
            insert(insert, produto.getCapacidade().getCap_id(), produto.getCategoria().getCat_id(), produto.getCor().getCor_id());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoInsert = false;
        if (findProduto(produto) != null) {
            resultadoInsert = true;
        }
        return resultadoInsert;
    }

    public boolean edit(Produto produto) throws GenericSqlException {
        if (produto.getProd_id() == null || produto.getCapacidade().getCap_id() == null || produto.getCategoria().getCat_id() == null || produto.getCor().getCor_id() == null) {
            throw new GenericSqlException("Produto(prod_id/cap_id/cat_id/cor_id) nulo.");
        }
        if (findProduto(produto) != null) {
            throw new GenericSqlException("Produto já existente.");
        }
        String update = "UPDATE produto SET cap_id = ?, cat_id = ?, cor_id = ? WHERE prod_id = ?";
        try {
            update(update, produto.getProd_id(), produto.getCapacidade().getCap_id(), produto.getCategoria().getCat_id(), produto.getCor().getCor_id());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoUpdate = false;
        Integer[] prod_descricao = findIdProduto(produto);
        if (prod_descricao != null) {
            if (Objects.equals(prod_descricao[0], produto.getCategoria().getCat_id())) {
                if (Objects.equals(prod_descricao[1], produto.getCapacidade().getCap_id())) {
                    if (Objects.equals(prod_descricao[2], produto.getCor().getCor_id())) {
                        resultadoUpdate = true;
                    }
                }

            }
        }
        return resultadoUpdate;
    }

    public boolean delete(Produto produto) throws GenericSqlException {
        if (produto.getProd_id() == null) {
            throw new GenericSqlException("Produto(id) nulo.");
        }
        if (findIdProduto(produto) == null) {
            throw new GenericSqlException("Tentativa de exclusão falhou, produto inexistente.");
        }
        Integer qtdProd = countProduto(produto);
        if (qtdProd > 0) {
            throw new GenericSqlException("Exclusão não permitida, esse produto foi usado " + qtdProd + " veses na tabela movimentação.");
        }
        String delete = "DELETE FROM produto WHERE prod_id = ?";
        try {
            delete(delete, produto.getProd_id());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoDelete = false;
        if (findIdProduto(produto) == null) {
            resultadoDelete = true;
        }
        return resultadoDelete;
    }

    public List listFindTab(Produto produto) {
        Connection conexao = ConnectionFactory.getConecta();
        StringBuilder sb = new StringBuilder("SELECT prod_id, cat_descricao, cap_descricao, cor_descricao FROM produto NATURAL JOIN capacidade NATURAL JOIN categoria NATURAL JOIN cor WHERE 0 = 0");

        Integer capacidade = produto.getCapacidade().getCap_descricao();
        String categoria = produto.getCategoria().getCat_descricao();

        if (capacidade != null) {
            sb.append(" AND cap_descricao = ").append(capacidade);
        }
        if (categoria != null && !categoria.isEmpty()) {
            sb.append(" AND cat_descricao LIKE \'").append(categoria).append("%\'");
        }
        sb.append(" ORDER BY cat_descricao, cap_descricao, cor_descricao");
        List listaProduto = null;
        try (PreparedStatement ps = conexao.prepareStatement(sb.toString()); ResultSet rs = ps.executeQuery()) {
            listaProduto = new ArrayList();
            while (rs.next()) {
                Capacidade cap = new Capacidade();
                cap.setCap_descricao(rs.getInt("cap_descricao"));

                Categoria cat = new Categoria();
                cat.setCat_descricao(rs.getString("cat_descricao"));

                Cor cor = new Cor();
                cor.setCor_descricao(rs.getString("cor_descricao"));

                Produto prod = new Produto();
                prod.setCapacidade(cap);
                prod.setCategoria(cat);
                prod.setCor(cor);
                prod.setProd_id(rs.getInt("prod_id"));

                Object[] linhaTab = {prod.getProd_id(), prod.getCategoria(), prod.getCapacidade(), prod.getCor()};
                listaProduto.add(linhaTab);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaProduto;
    }

    public Integer findProduto(Produto produto) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT prod_id FROM produto WHERE cap_id = ? AND cat_id = ? AND cor_id = ?";
        Integer prod_id = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, produto.getCapacidade().getCap_id());
            ps.setInt(2, produto.getCategoria().getCat_id());
            ps.setInt(3, produto.getCor().getCor_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    prod_id = rs.getInt("prod_id");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return prod_id;
    }

    public Integer[] findIdProduto(Produto produto) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cat_id, cap_id, cor_id FROM produto WHERE prod_id = ?";
        Integer[] prod_descricao = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, produto.getProd_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    Integer cat_id = rs.getInt("cat_id");
                    Integer cap_id = rs.getInt("cap_id");
                    Integer cor_id = rs.getInt("cor_id");
                    prod_descricao = new Integer[]{cat_id, cap_id, cor_id};
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return prod_descricao;
    }

    private Integer countProduto(Produto produto) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT COUNT(prod_id) AS total FROM movimentacao WHERE prod_id = ?";
        Integer qtdProd = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, produto.getProd_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    qtdProd = rs.getInt("total");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return qtdProd;
    }
}
