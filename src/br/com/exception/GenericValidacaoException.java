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
public class GenericValidacaoException extends Exception{

    public GenericValidacaoException(String string) {
        super(string);
    }

    public GenericValidacaoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public GenericValidacaoException(Throwable thrwbl) {
        super(thrwbl);
    }

}
