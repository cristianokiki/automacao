/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servidor;

import br.com.exception.ServerException;

/**
 *
 * @author Cristiano
 */
public class testaServidor {
    public static void main(String[] args) throws ServerException {
        Servidor servidor = new Servidor();
        servidor.setPorta(27015);
        servidor.Ativar();
        servidor.aguardaConexao();
        
    }
   
}
