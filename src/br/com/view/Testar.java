/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.controller.CapacidadeCntrl;
import br.com.controller.CategoriaCntrl;
import br.com.controller.CorCntrl;
import br.com.controller.EstoqueCntrl;
import br.com.controller.MaquinaCntrl;
import br.com.controller.ProducaoCntrl;
import br.com.controller.ProdutoCntrl;
import br.com.controller.VendaCntrl;
import br.com.exception.GenericSqlException;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class Testar {

    public static void main(String[] args) throws GenericSqlException {
        //  try {
        CapacidadeCntrl capc = new CapacidadeCntrl();
        // System.out.println("capacidade: " + capc.salvar(300));
        // System.out.println(capc.buscarCapacidade(400));
        // System.out.println(capc.buscarIdCapacidade(2));
        // System.out.println(capc.alterar(2, 12));
        // System.out.println(capc.apagar(2));
        // capc.listar().forEach(System.out::println);
        // System.out.println(capc.ultimaCapacidade());

        CategoriaCntrl catc = new CategoriaCntrl();
        /// System.out.println("categoria: " + catc.salvar("tampa"));
        // System.out.println(catc.buscarCategoria("tampas"));
        // System.out.println(catc.buscarIdCategoria(7));
        // System.out.println(catc.alterar(7, "tampa com furo"));
        // System.out.println(catc.ultimaCategoria());
        // System.out.println(catc.apagar(7));
        // catc.listar().forEach(System.out::println);

        CorCntrl cc = new CorCntrl();
        //System.out.println("cor: " + cc.salvar("transparente"));
        // System.out.println(cc.ultimaCor());
        // System.out.println(cc.buscarCor("preto"));
        // System.out.println(cc.buscarIdCor(3));
        // System.out.println(cc.alterar(3, "azul"));
        // System.out.println(cc.apagar(3));
        // cc.listar().forEach(System.out::println);

        MaquinaCntrl maqc = new MaquinaCntrl();
        //System.out.println("maquina: " + maqc.salvar("tf4"));
        // System.out.println(maqc.buscarIdMaquina(2));
        // System.out.println(maqc.buscarMaquina("tf2"));
        // System.out.println(maqc.alterar(3, "tf22"));
        // System.out.println(maqc.apagar(2));
        // System.out.println(maqc.listar());
        ProdutoCntrl pc = new ProdutoCntrl();
        pc.apagar(1);
        // System.out.println("Produto: " + pc.salvar(5, 1, 2));
        // System.out.println(Arrays.toString(pc.buscarIdProduto(1)));
        // System.out.println(pc.buscarProduto(100, 1, 1));
        // System.out.println(pc.listar());
        // System.out.println("Alterar: " + pc.alterar(2, 14, 1, 2));
        //  pc.listar().forEach(System.out::println);

        ProducaoCntrl pdc = new ProducaoCntrl();
        //pdc.salvar(8, 1);
        // pdc.apagar(1, 1);
        //List<Object[]> l = pdc.listarDet(null,null,null,null,null,null);
//        l.forEach(System.out::println);
//        for (int i = 0; i < l.size(); i++) {
//           System.out.println(l.get(i)[0] + " " + l.get(i)[1] + " " + l.get(i)[2] + " " + l.get(i)[3]);
//        }

        VendaCntrl vc = new VendaCntrl();
        // vc.salvar(6, 20);
        // System.out.println(vc.alterar(2, 1, 20));
        // System.out.println(vc.apagar(2));
//        List<Object[]> ll = vc.listaTab();
//        for (int i = 0; i < ll.size(); i++) {
//            System.out.println(ll.get(i)[0] + " " + ll.get(i)[1] + " " + ll.get(i)[2] + " " + ll.get(i)[3] + " " + ll.get(i)[4]);
//        }
        EstoqueCntrl estC = new EstoqueCntrl();
        //estC.listarTab(null, null).forEach(System.out::println);
        // List<Object[]> l = estC.listarTab(null, null);

        //  System.out.println(l.get(i)[0] + " " + l.get(i)[1]);
        //estC.salvar(6, 45);
        //System.out.println(estC.alterar(6, 51));
        // System.out.println(estC.apagar(6));
//        } catch (GenericSqlException ex) {
//            System.err.println(ex.getMessage());;
//        }
    }

}
