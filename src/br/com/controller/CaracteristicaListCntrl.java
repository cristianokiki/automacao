/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristiano
 */
public class CaracteristicaListCntrl {

    private static final List CARACTERISTICA = new ArrayList();

    private CaracteristicaListCntrl() {
    }

    public static CaracteristicaListCntrl getInstance() {
        return new CaracteristicaListCntrl();
    }
    //flyweight
    public List<Caracteristica> getCaracteristica() {
        CARACTERISTICA.add(new CapacidadeCntrl());
        CARACTERISTICA.add(new CategoriaCntrl());
        CARACTERISTICA.add(new CorCntrl());
        return CARACTERISTICA;
    }

}
