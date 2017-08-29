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
import br.com.controller.ValidacaoCntrl;
import br.com.exception.GenericSqlException;
import br.com.exception.GenericValidacaoException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristiano
 */
public class AdicionarRetornoDialogView extends javax.swing.JDialog {

    /**
     * Creates new form AdicionarRetornoDialogView
     */
    public AdicionarRetornoDialogView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.preencheComboBoxCap();
        this.preencheComboBoxCat();
        this.preencheComboboxCor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLBRetorno = new javax.swing.JLabel();
        jBTSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLBQuantidade = new javax.swing.JLabel();
        jFTFQuantidade = new javax.swing.JFormattedTextField();
        jCBCategoria = new javax.swing.JComboBox<>();
        jLBCategoria = new javax.swing.JLabel();
        jLBCapacidade = new javax.swing.JLabel();
        jCBCapacidade = new javax.swing.JComboBox<>();
        jCBCor = new javax.swing.JComboBox<>();
        jLBCor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLBRetorno.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLBRetorno.setText("RETORNO");

        jBTSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBTSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/if_floppy_disk_save_103863.png"))); // NOI18N
        jBTSalvar.setText("SALVAR");
        jBTSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTSalvarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/copoeprato.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLBQuantidade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLBQuantidade.setText("QUANTIDADE:");

        try {
            jFTFQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFTFQuantidade.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        jCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLBCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLBCategoria.setText("CATEGORIA:");

        jLBCapacidade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLBCapacidade.setText("CAPACIDADE:");

        jCBCapacidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCBCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLBCor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLBCor.setText("COR:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("PRODUTO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLBQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLBCor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCBCor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLBCapacidade)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCBCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLBCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLBCategoria, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBCapacidade)
                    .addComponent(jCBCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBCor)
                    .addComponent(jCBCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBQuantidade)
                    .addComponent(jFTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLBRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTSalvar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLBRetorno)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBTSalvar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBTSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTSalvarActionPerformed
        try {
            if (validaCampos()) {
                Integer cap_id = ValidacaoCntrl.temCapacidade(Integer.parseInt(this.jCBCapacidade.getSelectedItem().toString()));
                Integer cat_id = ValidacaoCntrl.temCategoria(this.jCBCategoria.getSelectedItem().toString());
                Integer cor_id = ValidacaoCntrl.temCor(this.jCBCor.getSelectedItem().toString());
                Integer prod_id = ValidacaoCntrl.temProduto(cap_id, cat_id, cor_id);
                if(prod_id!=null){
                EstoqueCntrl estCntrl = new EstoqueCntrl();
                estCntrl.salvar(prod_id, Integer.parseInt(this.jFTFQuantidade.getText().trim()));
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Não possui o produto com as características selecionada cadastrado no sistema.");
                }
            }
        } catch (GenericValidacaoException | GenericSqlException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jBTSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(AdicionarRetornoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarRetornoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarRetornoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarRetornoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            AdicionarRetornoDialogView dialog = new AdicionarRetornoDialogView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBTSalvar;
    private javax.swing.JComboBox<String> jCBCapacidade;
    private javax.swing.JComboBox<String> jCBCategoria;
    private javax.swing.JComboBox<String> jCBCor;
    private javax.swing.JFormattedTextField jFTFQuantidade;
    private javax.swing.JLabel jLBCapacidade;
    private javax.swing.JLabel jLBCategoria;
    private javax.swing.JLabel jLBCor;
    private javax.swing.JLabel jLBQuantidade;
    private javax.swing.JLabel jLBRetorno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    private void preencheComboBoxCap() {
        CapacidadeCntrl capCntrl = new CapacidadeCntrl();
        List listaCap = capCntrl.listar();
        this.jCBCapacidade.removeAllItems();
        this.jCBCapacidade.addItem("");
        for (int i = 0; i < listaCap.size(); i++) {
            this.jCBCapacidade.addItem(listaCap.get(i).toString());
        }
    }

    private void preencheComboBoxCat() {
        CategoriaCntrl catCntrl = new CategoriaCntrl();
        List listaCat = catCntrl.listar();
        this.jCBCategoria.removeAllItems();
        this.jCBCategoria.addItem("");
        for (int i = 0; i < listaCat.size(); i++) {
            this.jCBCategoria.addItem(listaCat.get(i).toString());
        }
    }

    private void preencheComboboxCor() {
        CorCntrl corCntrl = new CorCntrl();
        List listaCor = corCntrl.listar();
        this.jCBCor.removeAllItems();
        this.jCBCor.addItem("");
        for (int i = 0; i < listaCor.size(); i++) {
            this.jCBCor.addItem(listaCor.get(i).toString());
        }
    }

    private boolean validaCampos() throws GenericValidacaoException {
        if (this.jCBCapacidade.getSelectedIndex() == 0 || this.jCBCategoria.getSelectedIndex() == 0 || this.jCBCor.getSelectedIndex() == 0) {
            throw new GenericValidacaoException("Um produto deve conter uma categoria, capacidade e cor.");
        }
        if (this.jFTFQuantidade.getText().trim().isEmpty()) {
            throw new GenericValidacaoException("Quantidade não pode ser vazia.");
        }
        return true;
    }

}
