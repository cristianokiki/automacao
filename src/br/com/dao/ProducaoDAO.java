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
import br.com.model.Maquina;
import br.com.model.Producao;
import br.com.model.Produto;
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
public class ProducaoDAO {

    public void add(Producao producao) throws GenericSqlException {
        if (producao.getProduto().getProd_id() == null || producao.getMaquina().getMaq_id() == null) {
            throw new GenericSqlException("Produção(prod_id/maq_id) é nulo.");
        }
        Connection conexao = ConnectionFactory.getConecta();
        String insert = "INSERT INTO movimentacao(prod_id, mov_quantidade, mov_data, mov_hora, mov_status, maq_id) VALUES(?, 1, CURDATE(), CURTIME(), 'E', ?)";
        try (PreparedStatement ps = conexao.prepareStatement(insert)) {
            ps.setInt(1, producao.getProduto().getProd_id());
            ps.setInt(2, producao.getMaquina().getMaq_id());
            ps.execute();
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
    }

    public void delete(Producao producao) throws GenericSqlException {
        if (producao.getProduto().getProd_id() == null || producao.getMaquina().getMaq_id() == null) {
            throw new GenericSqlException("Produção(prod_id/maq_id) é nulo.");
        }
        Connection conexao = ConnectionFactory.getConecta();
        String delete = "DELETE FROM movimentacao WHERE mov_id = (SELECT id FROM(SELECT MAX(mov_id) AS id FROM movimentacao WHERE prod_id = ? AND maq_id = ?) AS mov)";
        try (PreparedStatement ps = conexao.prepareStatement(delete)) {
            ps.setInt(1, producao.getProduto().getProd_id());
            ps.setInt(2, producao.getMaquina().getMaq_id());
            ps.execute();
        } catch (SQLException ex) {
            throw new GenericSqlException(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
    }

    //producao detalhada 
    public List listDetTab(Producao producao) {
        Connection conexao = ConnectionFactory.getConecta();
        StringBuilder sb = new StringBuilder("SELECT cat_descricao, cap_descricao, cor_descricao, DATE_FORMAT(mov_data, '%d/%c/%Y') AS data, mov_hora, maq_descricao "
                + "FROM movimentacao NATURAL JOIN (SELECT prod_id, cat_descricao, cap_descricao, cor_descricao FROM produto NATURAL JOIN capacidade NATURAL JOIN categoria "
                + "NATURAL JOIN cor) AS prod NATURAL JOIN maquina WHERE 0 = 0");
        if (producao.getProduto().getCategoria().getCat_descricao() != null && !producao.getProduto().getCategoria().getCat_descricao().isEmpty()) {
            sb.append(" AND cat_descricao = '").append(producao.getProduto().getCategoria().getCat_descricao()).append("'");
            if (producao.getProduto().getCapacidade().getCap_descricao() != null) {
                sb.append(" AND cap_descricao = ").append(producao.getProduto().getCapacidade().getCap_descricao());
                if (producao.getProduto().getCor().getCor_descricao() != null && !producao.getProduto().getCor().getCor_descricao().isEmpty()) {
                    sb.append(" AND cor_descricao = '").append(producao.getProduto().getCor().getCor_descricao()).append("'");
                }
            }
        }
        if (producao.getMaquina().getMaq_descricao() != null && !producao.getMaquina().getMaq_descricao().isEmpty()) {
            sb.append(" AND maq_descricao = \'").append(producao.getMaquina().getMaq_descricao()).append("\'");
        } else {
            sb.append(" AND maq_id IS NOT NULL");
        }
        if (producao.getData() != null && !producao.getData().isEmpty()) {
            sb.append(" AND mov_data = \'").append(producao.getData()).append("\'");
        } else {
            sb.append(" AND mov_data = CURDATE()");
        }
        if (producao.getHora() != null && !producao.getHora().isEmpty()) {
            sb.append(" AND mov_hora BETWEEN '").append(producao.getHora()).append(":00:00' AND '").append(producao.getHora()).append(":59:59'");
        }
        sb.append(" ORDER BY mov_data DESC, mov_hora DESC");
        List listaProducao = null;
        try (PreparedStatement ps = conexao.prepareStatement(sb.toString()); ResultSet rs = ps.executeQuery()) {
            listaProducao = new ArrayList();
            while (rs.next()) {
                Producao produc = getProducaoDetalhada(rs);
                Object[] linhaProducao = {produc.getProduto(), produc.getData(), produc.getHora(), produc.getMaquina()};
                listaProducao.add(linhaProducao);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaProducao;
    }

    //producao detalhada por maquina
//    public List listDetMaq(Producao producao) {
//        Connection conexao = ConnectionFactory.getConecta();
//        StringBuilder sb = new StringBuilder("SELECT maq_descricao, cat_descricao, cap_descricao, cor_descricao, "
//                + "DATE_FORMAT(mov_data, '%d/%c/%Y') AS data, mov_hora FROM movimentacao NATURAL JOIN (SELECT prod_id, cat_descricao, cap_descricao, cor_descricao FROM produto NATURAL JOIN categoria "
//                + "NATURAL JOIN capacidade NATURAL JOIN cor) AS prod NATURAL JOIN maquina WHERE 0 = 0");
//        String data = producao.getData();
//        if (data == null || data.isEmpty()) {
//            sb.append(" AND mov_data = CURDATE()");
//        } else {
//            sb.append(" AND mov_data = '").append(data).append("'");
//        }
//        if (producao.getMaquina().getMaq_descricao() == null) {
//            sb.append(" AND maq_id IS NOT NULL");
//        } else {
//            sb.append(" AND maq_descricao = '").append(producao.getMaquina().getMaq_descricao()).append("'");
//        }
//        sb.append(" ORDER BY mov_hora DESC");
//        List listaProducao = null;
//        try (PreparedStatement ps = conexao.prepareStatement(sb.toString()); ResultSet rs = ps.executeQuery()) {
//            listaProducao = new ArrayList();
//            while (rs.next()) {
//                Producao produc = getProducaoDetalhada(rs);
//                Object[] linhaProducao = {produc.getMaquina(), produc.getProduto(), produc.getData(), produc.getHora()};
//                listaProducao.add(linhaProducao);
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        } finally {
//            ConnectionFactory.desconecta(conexao);
//        }
//        return listaProducao;
//    }

    //total produzido por maquina
    public List listFindTotalMaq(Producao producao) {
        Connection conexao = ConnectionFactory.getConecta();
        StringBuilder sb = new StringBuilder("SELECT maq_descricao, COUNT(mov_id) "
                + "AS quantidade, DATE_FORMAT(mov_data, '%d/%c/%Y') AS data "
                + "FROM movimentacao NATURAL JOIN maquina WHERE maq_id IS NOT NULL");
        String data = producao.getData();
        if (data == null || data.isEmpty()) {
            sb.append(" AND mov_data = CURDATE()");
        } else {
            sb.append(" AND mov_data = '").append(data).append("'");
        }
        sb.append(" GROUP BY maq_id ORDER BY maq_descricao");
        List listaProducao = null;
        try (PreparedStatement ps = conexao.prepareStatement(sb.toString()); ResultSet rs = ps.executeQuery()) {
            listaProducao = new ArrayList();
            while (rs.next()) {
                Maquina maq = new Maquina();
                maq.setMaq_descricao(rs.getString("maq_descricao"));

                Producao produc = new Producao();
                produc.setData(rs.getString("data"));
                produc.setMaquina(maq);
                produc.setQuantidade(rs.getInt("quantidade"));

                Object[] linhaProducao = {produc.getMaquina(), produc.getQuantidade(), produc.getData()};
                listaProducao.add(linhaProducao);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaProducao;
    }

    // producao total dia atual/especificado
    public List listFindDay(Producao producao) {
        Connection conexao = ConnectionFactory.getConecta();
        StringBuilder sb = new StringBuilder("SELECT cat_descricao, cap_descricao, cor_descricao, SUM(mov_quantidade) AS quantidade "
                + "FROM movimentacao NATURAL JOIN (SELECT prod_id, cat_descricao, cap_descricao, cor_descricao FROM produto NATURAL JOIN categoria "
                + "NATURAL JOIN capacidade NATURAL JOIN cor) AS prod WHERE maq_id IS NOT NULL");
        if (producao.getData() == null || producao.getData().isEmpty()) {
            sb.append(" AND mov_data = CURDATE()");
        } else {
            sb.append(" AND mov_data = \'").append(producao.getData()).append("\'");
        }
        sb.append(" GROUP BY cat_descricao, cap_descricao, cor_descricao ORDER BY cat_descricao, cap_descricao, cor_descricao");
        List listaProducao = null;
        try (PreparedStatement ps = conexao.prepareStatement(sb.toString()); ResultSet rs = ps.executeQuery()) {
            listaProducao = new ArrayList();
            while (rs.next()) {
                Producao produc = getProducaoTotal(rs);
                Object[] linhaProduc = {produc.getProduto(), produc.getQuantidade(), produc.getData()};
                listaProducao.add(linhaProduc);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaProducao;
    }

    // producao total semana
    public List listWeekTab() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cat_descricao, cap_descricao, cor_descricao, SUM(mov_quantidade) AS quantidade "
                + "FROM movimentacao NATURAL JOIN (SELECT prod_id, cat_descricao, cap_descricao, cor_descricao FROM produto NATURAL JOIN categoria "
                + "NATURAL JOIN capacidade NATURAL JOIN cor) AS prod WHERE maq_id IS NOT NULL AND WEEK(mov_data) = WEEK(CURDATE()) AND YEAR(mov_data) = YEAR(CURDATE()) "
                + "GROUP BY prod_id ORDER BY cat_descricao, cap_descricao, cor_descricao";
        List listaProducao = null;
        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            listaProducao = new ArrayList();
            while (rs.next()) {
                Producao produc = getProducaoTotal(rs);
                Object[] linhaProduc = {produc.getProduto(), produc.getQuantidade()};
                listaProducao.add(linhaProduc);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaProducao;
    }

    // producao total mes
    public List listMonthTab() {
        Connection conexao = ConnectionFactory.getConecta();
        String select = "SELECT cat_descricao, cap_descricao, cor_descricao, SUM(mov_quantidade) AS quantidade "
                + "FROM movimentacao NATURAL JOIN ((SELECT prod_id, cat_descricao, cap_descricao, cor_descricao FROM produto NATURAL JOIN categoria "
                + "NATURAL JOIN capacidade NATURAL JOIN cor) AS prod) WHERE maq_id IS NOT NULL AND MONTH(mov_data) = MONTH(CURDATE()) AND YEAR(mov_data) = YEAR(CURDATE()) "
                + "GROUP BY prod_id ORDER BY cat_descricao, cap_descricao, cor_descricao";
        List listaProducao = null;

        try (PreparedStatement ps = conexao.prepareStatement(select); ResultSet rs = ps.executeQuery()) {
            listaProducao = new ArrayList();
            while (rs.next()) {
                Producao produc = getProducaoTotal(rs);
                Object[] linhaProduc = {produc.getProduto(), produc.getQuantidade()};
                listaProducao.add(linhaProduc);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            ConnectionFactory.desconecta(conexao);
        }
        return listaProducao;
    }

    private Producao getProducaoDetalhada(ResultSet rs) throws SQLException {
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

        Maquina maq = new Maquina();
        maq.setMaq_descricao(rs.getString("maq_descricao"));

        Producao produc = new Producao();
        produc.setData(rs.getString("data"));
        produc.setHora(rs.getString("mov_hora"));
        produc.setProduto(prod);
        produc.setMaquina(maq);
        return produc;
    }

    private Producao getProducaoTotal(ResultSet rs) throws SQLException {
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

        Producao produc = new Producao();
        produc.setProduto(prod);
        produc.setQuantidade(rs.getInt("quantidade"));
        return produc;
    }
}
