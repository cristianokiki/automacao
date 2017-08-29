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
import br.com.model.Venda;
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
public class VendaDAO extends GenericDAO {

    public void add(Venda venda) throws GenericSqlException {
        if (venda.getProduto().getProd_id() == null || venda.getQuantidade() == null) {
            throw new GenericSqlException("Venda(prod_id/quantidade) nulo.");
        }
        if (venda.getQuantidade() <= 0) {
            throw new GenericSqlException("Quantidade inválida.");
        }
        Integer saldo = saldoEstoque(venda);
        if (saldo < venda.getQuantidade()) {
            throw new GenericSqlException("Quantidade indisponível em estoque, faltam " + (venda.getQuantidade() - saldo) + " para que a venda seja concluída.");
        }
        String insert = "INSERT INTO movimentacao(prod_id, mov_quantidade, mov_data, mov_hora, mov_status) VALUES(?, ?, CURDATE(), CURTIME(), 'S')";
        try {
            insert(insert, venda.getProduto().getProd_id(), venda.getQuantidade());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
    }

    public boolean edit(Venda venda) throws GenericSqlException {
        if (venda.getProduto().getProd_id() == null || venda.getQuantidade() == null || venda.getMov_id() == null) {
            throw new GenericSqlException("Venda(mov_id/prod_id/quantidade) nulo.");
        }
        if (venda.getQuantidade() <= 0) {
            throw new GenericSqlException("Quantidade inválida.");
        }
        Integer saldo = saldoEstoque(venda);
        if (saldo < venda.getQuantidade()) {
            throw new GenericSqlException("Quantidade indisponível em estoque, faltam " + (venda.getQuantidade() - saldo) + " para que a venda seja concluída.");
        }
        String update = "UPDATE movimentacao SET prod_id = ?, mov_quantidade = ? WHERE mov_id = ?";
        try {
            update(update, venda.getMov_id(), venda.getProduto().getProd_id(), venda.getQuantidade());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        Integer venda_info = findVenda(venda);
        boolean resultadoUpdate = false;
        if (venda_info != null) {
            if (Objects.equals(venda_info, venda.getQuantidade())) {
                resultadoUpdate = true;
            }
        }
        return resultadoUpdate;
    }

    public boolean delete(Venda venda) throws GenericSqlException {
        if (venda.getMov_id() == null) {
            throw new GenericSqlException("Venda(mov_id) nulo.");
        }
        if (findVenda(venda) == null) {
            throw new GenericSqlException("Tentativa de exclusão falhou, venda inexistente.");
        }
        String delete = "DELETE FROM movimentacao WHERE mov_id = ?";
        try {
            delete(delete, venda.getMov_id());
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        }
        boolean resultadoDelete = false;
        if (findVenda(venda) == null) {
            resultadoDelete = true;
        }
        return resultadoDelete;
    }

    public List listFindTab(Venda venda) {
        Connection conexao = ConnectionFactory.getConecta();
        StringBuilder sb = new StringBuilder("SELECT mov_id, cat_descricao, cap_descricao, cor_descricao, mov_quantidade, DATE_FORMAT(mov_data , '%d/%c/%Y') AS data, mov_hora "
                + "FROM movimentacao NATURAL JOIN ((SELECT prod_id, cat_descricao, cap_descricao, cor_descricao "
                + "FROM produto NATURAL JOIN categoria NATURAL JOIN capacidade NATURAL JOIN cor) AS produto) WHERE mov_status = 'S'");
        if (venda.getData() != null && !venda.getData().isEmpty()) {
            sb.append(" AND mov_data = '").append(venda.getData()).append("'");
        }
        sb.append(" ORDER BY mov_data DESC, mov_hora DESC");
        List listaVenda = null;
        try (PreparedStatement ps = conexao.prepareStatement(sb.toString()); ResultSet rs = ps.executeQuery()) {
            listaVenda = new ArrayList();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setCat_descricao(rs.getString("cat_descricao"));

                Capacidade cap = new Capacidade();
                cap.setCap_descricao(rs.getInt("cap_descricao"));

                Cor cor = new Cor();
                cor.setCor_descricao(rs.getString("cor_descricao"));

                Produto prod = new Produto();
                prod.setCapacidade(cap);
                prod.setCategoria(cat);
                prod.setCor(cor);

                Venda vend = new Venda();
                vend.setMov_id(rs.getLong("mov_id"));
                vend.setProduto(prod);
                vend.setQuantidade(rs.getInt("mov_quantidade"));
                vend.setData(rs.getString("data"));
                vend.setHora(rs.getString("mov_hora"));

                Object[] linhaTab = {vend.getMov_id(), vend.getProduto(), vend.getQuantidade(), vend.getData(), vend.getHora()};
                listaVenda.add(linhaTab);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaVenda;
    }

    private Integer findVenda(Venda venda) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT mov_quantidade FROM movimentacao WHERE mov_id = ?";
        Integer venda_info = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setLong(1, venda.getMov_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    Venda vend = new Venda();
                    vend.setQuantidade(rs.getInt("mov_quantidade"));

                    venda_info = vend.getQuantidade();
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return venda_info;
    }

    private Integer saldoEstoque(Venda venda) {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT SUM(quantidade) AS saldo FROM(SELECT prod_id, SUM(mov_quantidade) AS quantidade "
                + "FROM movimentacao WHERE mov_status = 'E' GROUP BY prod_id UNION SELECT prod_id, -SUM(mov_quantidade) "
                + "AS quantidade FROM movimentacao WHERE mov_status = 'S' GROUP BY prod_id) AS estoque "
                + "WHERE prod_id = ?";
        Integer qtd = null;
        try (PreparedStatement ps = conexao.prepareStatement(select)) {
            ps.setInt(1, venda.getProduto().getProd_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    qtd = rs.getInt("saldo");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return qtd;
    }
}
