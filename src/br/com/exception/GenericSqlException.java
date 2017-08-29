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
public class GenericSqlException extends Exception {

    public GenericSqlException(String string) {
        super(string);
    }

    public GenericSqlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public GenericSqlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

}
