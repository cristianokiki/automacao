/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cristiano
 */
public class ValidacaoCntrl {

    public static Integer temCapacidade(Integer capacidade) {
        CapacidadeCntrl capcntrl = new CapacidadeCntrl();
        return capcntrl.buscarCapacidade(capacidade);
    }

    public static Integer temCategoria(String categoria) {
        CategoriaCntrl catCntrl = new CategoriaCntrl();
        return catCntrl.buscarCategoria(categoria);
    }

    public static Integer temCor(String cor) {
        CorCntrl corCntrl = new CorCntrl();
        return corCntrl.buscarCor(cor);
    }

    public static Integer temProduto(Integer cap_id, Integer cat_id, Integer cor_id) {
        ProdutoCntrl prodCntrl = new ProdutoCntrl();
        return prodCntrl.buscarProduto(cap_id, cat_id, cor_id);
    }

    public static String formataData(String data) {
        StringBuilder sb = new StringBuilder();
        if (data != null && !data.isEmpty()) {
            Pattern padrao = Pattern.compile("(\\d\\d)-(\\d\\d)-(\\d\\d\\d\\d)");
            Matcher corresponde = padrao.matcher(data);
            if (corresponde.find()) {
                String dt[] = data.split("-");
                sb.append(dt[2]);
                sb.append("-");
                sb.append(dt[1]);
                sb.append("-");
                sb.append(dt[0]);
            }
        }
        return sb.toString();
    }
}
