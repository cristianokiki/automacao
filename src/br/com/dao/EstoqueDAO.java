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
import br.com.model.Estoque;
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
public class EstoqueDAO extends GenericDAO {

    public void add(Estoque estoque) throws GenericSqlException {
        if (estoque.getProduto().getProd_id() == null || estoque.getQuantidade() == null) {
            throw new GenericSqlException("Estoque(prod_id/quantidade) nulo.");
        }
        if (estoque.getQuantidade() <= 0) {
            throw new GenericSqlException("Quantidade inválida.");
        }
        String insert = "INSERT INTO movimentacao(prod_id, mov_quantidade, mov_data, mov_hora, mov_status) VALUES(?, ?, CURDATE(), CURTIME(), 'E')";
        try {
            insert(insert, estoque.getProduto().getProd_id(), estoque.getQuantidade());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
    }

    public boolean edit(Estoque estoque) throws GenericSqlException {
        if (estoque.getMov_id() == null || estoque.getQuantidade() == null) {
            throw new GenericSqlException("Estoque(mov_id/prod_id/quantidade) nulo.");
        }
        if (estoque.getQuantidade() <= 0) {
            throw new GenericSqlException("Quantidade inválida.");
        }
        String update = "UPDATE movimentacao set mov_quantidade = ? WHERE mov_id = ?";
        try {
            update(update, estoque.getMov_id(), estoque.getQuantidade());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        Integer[] estoque_info = findEstoque(estoque);
        boolean resultadoUpdate = false;
        if (estoque_info != null) {
            if (Objects.equals(estoque_info[1], estoque.getQuantidade())) {
                resultadoUpdate = true;
            }
        }
        return resultadoUpdate;
    }

    public boolean delete(Estoque estoque) throws GenericSqlException {
        if (estoque.getMov_id() == null) {
            throw new GenericSqlException("Estoque(mov_id) nulo.");
        }
        if (findEstoque(estoque) == null) {
            throw new GenericSqlException("Tentativa de exclusão falhou, retorno inexistente.");
        }
        String delete = "DELETE FROM movimentacao WHERE mov_id = ?";
        try {
            delete(delete, estoque.getMov_id());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoDelete = false;
        if (findEstoque(estoque) == null) {
            resultadoDelete = true;
        }
        return resultadoDelete;
    }

    private Integer[] findEstoque(Estoque estoque) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT prod_id, mov_quantidade FROM movimentacao WHERE mov_id = ?";
        Integer[] estoque_info = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setLong(1, estoque.getMov_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    estoque_info = new Integer[]{rs.getInt("prod_id"), rs.getInt("mov_quantidade")};
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return estoque_info;
    }

    public List listTab(Estoque estoque) {
        Connection conexao = ConnectionFactory.getConecta();
        StringBuilder sb = new StringBuilder("SELECT prod_id, cat_descricao, cap_descricao, cor_descricao, SUM(quantidade) AS total "
                + "FROM (SELECT prod_id, cat_descricao, cap_descricao, cor_descricao, SUM(mov_quantidade) AS quantidade "
                + "FROM movimentacao NATURAL JOIN (SELECT prod_id, cat_descricao, cap_descricao, cor_descricao "
                + "FROM produto NATURAL JOIN capacidade NATURAL JOIN categoria NATURAL JOIN cor) AS prod WHERE mov_status = 'E' "
                + "GROUP BY prod_id UNION SELECT prod_id, cat_descricao, cap_descricao, cor_descricao, -SUM(mov_quantidade) AS quantidade "
                + "FROM movimentacao NATURAL JOIN (SELECT prod_id, cat_descricao, cap_descricao, cor_descricao "
                + "FROM produto NATURAL JOIN capacidade NATURAL JOIN categoria NATURAL JOIN cor) AS prod WHERE mov_status = 'S' "
                + "GROUP BY prod_id) AS produc WHERE 0 = 0");

        if (estoque.getProduto().getCategoria().getCat_descricao() != null && !estoque.getProduto().getCategoria().getCat_descricao().isEmpty()) {
            sb.append(" AND cat_descricao LIKE \'").append(estoque.getProduto().getCategoria().getCat_descricao()).append("%\'");
        }
        if (estoque.getProduto().getCapacidade().getCap_descricao() != null) {
            sb.append("  AND cap_descricao = ").append(estoque.getProduto().getCapacidade());
        }
        sb.append(" GROUP BY prod_id, cat_descricao, cap_descricao, cor_descricao ORDER BY cat_descricao, cap_descricao, cor_descricao");
        List listaEstoque = null;
        try (PreparedStatement ps = conexao.prepareStatement(sb.toString()); ResultSet rs = ps.executeQuery()) {
            listaEstoque = new ArrayList();
            while (rs.next()) {
                Capacidade cap = new Capacidade();
                cap.setCap_descricao(rs.getInt("cap_descricao"));

                Categoria cat = new Categoria();
                cat.setCat_descricao(rs.getString("cat_descricao"));

                Cor cor = new Cor();
                cor.setCor_descricao(rs.getString("cor_descricao"));

                Produto prod = new Produto();
                prod.setProd_id(rs.getInt("prod_id"));
                prod.setCapacidade(cap);
                prod.setCategoria(cat);
                prod.setCor(cor);

                Estoque est = new Estoque();
                est.setQuantidade(rs.getInt("total"));
                est.setProduto(prod);
                Object[] linhaEstoque = {est.getProduto().getProd_id(), est.getProduto(), est.getQuantidade()};
                listaEstoque.add(linhaEstoque);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listaEstoque;
    }

    public List listRetornoTab(Estoque estoque) {
        Connection conexao = ConnectionFactory.getConecta();
        StringBuilder sb = new StringBuilder("SELECT mov_id, cat_descricao, cap_descricao, cor_descricao, mov_quantidade, DATE_FORMAT(mov_data, '%d/%c/%Y') AS dat, mov_hora "
                + "FROM movimentacao NATURAL JOIN(SELECT prod_id, cat_descricao, cap_descricao, cor_descricao FROM produto NATURAL JOIN capacidade "
                + "NATURAL JOIN categoria NATURAL JOIN cor)AS prod WHERE maq_id IS NULL AND mov_status = 'E'");

        if (estoque.getData() != null && !estoque.getData().isEmpty()) {
            sb.append(" AND mov_data = '").append(estoque.getData()).append("'");
        }
        sb.append(" ORDER BY mov_data DESC, mov_hora DESC");
        List listaRetorno = null;
        try (PreparedStatement ps = conexao.prepareStatement(sb.toString()); ResultSet rs = ps.executeQuery()) {
            listaRetorno = new ArrayList();
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

                Estoque est = new Estoque();
                est.setData(rs.getString("dat"));
                est.setHora(rs.getString("mov_hora"));
                est.setMov_id(rs.getLong("mov_id"));
                est.setProduto(prod);
                est.setQuantidade(rs.getInt("mov_quantidade"));

                Object[] linhaRetorno = {est.getMov_id(), est.getProduto(), est.getQuantidade(), est.getData(), est.getHora()};
                listaRetorno.add(linhaRetorno);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaRetorno;
    }
}
