/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.controller.EstoqueCntrl;
import br.com.controller.Tabela;
import br.com.controller.ValidacaoCntrl;
import br.com.exception.GenericSqlException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristiano
 */
public class ListaRetornoDialogView extends javax.swing.JDialog {

    private final EstoqueCntrl ESTCNTRL = new EstoqueCntrl();

    /**
     * Creates new form ListaRetornoDialogView
     *
     * @param parent
     * @param modal
     */
    public ListaRetornoDialogView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.botoes(true, false, false, true);
        this.preencheRetorno(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLBTitulo = new javax.swing.JLabel();
        jBTAdicionar = new javax.swing.JButton();
        jBTAlterar = new javax.swing.JButton();
        jBTExcluir = new javax.swing.JButton();
        jBTListar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBRetorno = new javax.swing.JTable();
        jPPesquisa = new javax.swing.JPanel();
        jLBData = new javax.swing.JLabel();
        jFTFData = new javax.swing.JFormattedTextField();
        jBTBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLBTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLBTitulo.setText("REGISTRO RETORNO");

        jBTAdicionar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBTAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/if_Create_105261.png"))); // NOI18N
        jBTAdicionar.setText("ADICIONAR");
        jBTAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTAdicionarActionPerformed(evt);
            }
        });

        jBTAlterar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBTAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/if_Refresh_105225.png"))); // NOI18N
        jBTAlterar.setText("ALTERAR");
        jBTAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTAlterarActionPerformed(evt);
            }
        });

        jBTExcluir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBTExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/if_Close_105221.png"))); // NOI18N
        jBTExcluir.setText("EXCLUIR");
        jBTExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTExcluirActionPerformed(evt);
            }
        });

        jBTListar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBTListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/if_Renew_105218.png"))); // NOI18N
        jBTListar.setText("LISTAR");
        jBTListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTListarActionPerformed(evt);
            }
        });

        jTBRetorno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTBRetorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBRetornoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTBRetorno);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLBTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jBTAdicionar)
                .addGap(18, 18, 18)
                .addComponent(jBTAlterar)
                .addGap(18, 18, 18)
                .addComponent(jBTExcluir)
                .addGap(18, 18, 18)
                .addComponent(jBTListar)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLBTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBTAdicionar)
                    .addComponent(jBTAlterar)
                    .addComponent(jBTExcluir)
                    .addComponent(jBTListar))
                .addContainerGap())
        );

        jPPesquisa.setBackground(new java.awt.Color(255, 255, 255));

        jLBData.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLBData.setText("DATA:");

        try {
            jFTFData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFData.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        jBTBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBTBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/if_search_magnifying_glass_find_103857.png"))); // NOI18N
        jBTBuscar.setText("BUSCAR");
        jBTBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPPesquisaLayout = new javax.swing.GroupLayout(jPPesquisa);
        jPPesquisa.setLayout(jPPesquisaLayout);
        jPPesquisaLayout.setHorizontalGroup(
            jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPesquisaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jBTBuscar))
                    .addGroup(jPPesquisaLayout.createSequentialGroup()
                        .addComponent(jLBData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPPesquisaLayout.setVerticalGroup(
            jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPesquisaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBData)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jBTBuscar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBTAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTAdicionarActionPerformed
        AdicionarRetornoDialogView dialog = new AdicionarRetornoDialogView(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jBTAdicionarActionPerformed

    private void jBTAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTAlterarActionPerformed
        String[] dados = pegaDados();
        setAlterarRetorno(dados);
    }//GEN-LAST:event_jBTAlterarActionPerformed

    private void jTBRetornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBRetornoMouseClicked
        if (evt.getClickCount() == 1) {
            this.botoes(true, true, true, true);
        }
        if (evt.getClickCount() == 2) {

            String[] dados = pegaDados();
            setAlterarRetorno(dados);
        }
    }//GEN-LAST:event_jTBRetornoMouseClicked

    private void jBTBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTBuscarActionPerformed
        String data = this.jFTFData.getText();
        if (!data.equals("  -  -    ")) {
            this.preencheRetorno(ValidacaoCntrl.formataData(data));
        } else {
            this.preencheRetorno(null);
        }
        this.botoes(true, false, false, true);
    }//GEN-LAST:event_jBTBuscarActionPerformed

    private void jBTExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTExcluirActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o registro selecionado?");
        if (op == 0) {
            String[] dados = pegaDados();
            try {
                if (ESTCNTRL.apagar(Long.parseLong(dados[0]))) {
                    JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
                }
            } catch (GenericSqlException ex) {
                JOptionPane.showMessageDialog(null, "Formato de numero inválido!");
            }
        }
    }//GEN-LAST:event_jBTExcluirActionPerformed

    private void jBTListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTListarActionPerformed
        this.preencheRetorno(null);
        this.botoes(true, false, false, true);
    }//GEN-LAST:event_jBTListarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaRetornoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaRetornoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaRetornoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaRetornoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            ListaRetornoDialogView dialog = new ListaRetornoDialogView(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTAdicionar;
    private javax.swing.JButton jBTAlterar;
    private javax.swing.JButton jBTBuscar;
    private javax.swing.JButton jBTExcluir;
    private javax.swing.JButton jBTListar;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JLabel jLBData;
    private javax.swing.JLabel jLBTitulo;
    private javax.swing.JPanel jPPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTBRetorno;
    // End of variables declaration//GEN-END:variables

    private void botoes(boolean adicionar, boolean alterar, boolean excluir, boolean lista) {
        this.jBTAdicionar.setEnabled(adicionar);
        this.jBTAlterar.setEnabled(alterar);
        this.jBTExcluir.setEnabled(excluir);
        this.jBTListar.setEnabled(lista);
    }

    private void preencheRetorno(String data) {
        String[] coluna = {"CODIGO", "PRODUTO", "QUANTIDADE", "DATA", "HORA"};
        List linha = ESTCNTRL.listarRetornoTab(data);
        Tabela tab = new Tabela(linha, coluna);
        this.jTBRetorno.setModel(tab);
    }

    private String[] pegaDados() {
        int linha = this.jTBRetorno.getSelectedRow();
        String[] lista = {this.jTBRetorno.getValueAt(linha, 0).toString(), this.jTBRetorno.getValueAt(linha, 1).toString(), this.jTBRetorno.getValueAt(linha, 2).toString()};
        return lista;
    }

    private void setAlterarRetorno(String[] dados) {
        AlterarRetornoDialogView dialog = new AlterarRetornoDialogView(new javax.swing.JFrame(), true);
        dialog.setCodigoRetorno(dados[0]);
        dialog.setProduto(dados[1]);
        dialog.setQuantidade(dados[2]);
        dialog.setVisible(true);
    }
}