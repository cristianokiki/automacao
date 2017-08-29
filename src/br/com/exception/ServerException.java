/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exception;

/**
 *
 * @author Cristiano
 */
public class ServerException extends Exception{

    public ServerException(String string) {
        super(string);
    }

    public ServerException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ServerException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
