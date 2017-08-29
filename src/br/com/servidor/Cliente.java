/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Cristiano
 */
public class Cliente {

    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket("localhost", 27015);
        System.out.println(cliente.isConnected());
        PrintStream ps = new PrintStream(cliente.getOutputStream());
        
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String msg = scan.nextLine();
            ps.println(msg);
        }
    }
}
