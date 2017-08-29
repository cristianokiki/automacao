/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servidor;

import br.com.exception.ServerException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Cristiano
 */
public class Servidor {

    private ServerSocket server;
    private int porta;

    public Servidor() {
    }

    public void Ativar() throws ServerException {
        try {
            this.server = new ServerSocket(porta);

        } catch (IOException ex) {
            throw new ServerException(ex.getMessage());
        }
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
    
    public String getIp() {
        return this.server.getInetAddress().getHostAddress();
    }

    public void aguardaConexao() throws ServerException {
        try {
            while(true){
            System.out.println("Espera conexão...");
            Socket cliente = this.server.accept();
            System.out.println("Conexão estabelecida com " + cliente.getInetAddress().getHostAddress());
            TratamentoCliente tratar = new TratamentoCliente(cliente);
            Thread th = new Thread(tratar);
            th.start();
            }
        } catch (IOException ex) {
            throw new ServerException(ex.getMessage());
        }
    }

}
