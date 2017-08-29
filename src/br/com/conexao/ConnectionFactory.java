/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conexao;

import br.com.exception.GenericSqlException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cristiano
 */
public abstract class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost/automacaoindustrial";
    private static final String USUARIO = "root";
    private static final String SENHA = "cas95souza";

    public ConnectionFactory() {
    }

    public static Connection getConecta() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException ex) {
            try {
                throw new GenericSqlException(ex);
            } catch (GenericSqlException ex1) {
                System.out.println(ex1);
            }
        }
        return conexao;
    }

    public static void desconecta(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                try {
                    throw new GenericSqlException(ex);
                } catch (GenericSqlException ex1) {
                    System.err.println(ex1);
                }
            }
        }
    }
}
