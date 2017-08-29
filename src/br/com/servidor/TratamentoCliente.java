/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servidor;

import br.com.controller.ProducaoCntrl;
import br.com.exception.GenericSqlException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Cristiano
 */
public class TratamentoCliente implements Runnable {

    private final Socket cliente;
    private static final ProducaoCntrl PRODUCAO = new ProducaoCntrl();

    public TratamentoCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        this.trataCliente(cliente);
    }

    private void trataCliente(Socket cliente) {

        try (Scanner scan = new Scanner(cliente.getInputStream())) {
            while (scan.hasNextLine()) {
                String[] info_producao = scan.nextLine().split(";");
                Integer prod_id = Integer.parseInt(info_producao[0]);
                Integer maq_id = Integer.parseInt(info_producao[1]);

                System.out.println("produto id " + prod_id);
                System.out.println("maquina id " + maq_id);

                if (prod_id > 0) {
                    PRODUCAO.salvar(prod_id, maq_id);
                } else {
                    prod_id = prod_id * (-1);
                    PRODUCAO.apagar(prod_id, maq_id);
                }
            }
            cliente.close();
            System.out.println("Cliente ip: " + cliente.getInetAddress().getHostAddress() + " foi desconectado.");
        } catch (IOException | GenericSqlException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
