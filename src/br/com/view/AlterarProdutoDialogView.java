/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.controller.CapacidadeCntrl;
import br.com.controller.CategoriaCntrl;
import br.com.controller.CorCntrl;
import br.com.controller.ProdutoCntrl;
import br.com.controller.ValidacaoCntrl;
import br.com.exception.GenericSqlException;
import br.com.exception.GenericValidacaoException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristiano
 */
public class AlterarProdutoDialogView extends javax.swing.JDialog {

    /**
     * Creates new form AtualizarProdutoDialogView
     *
     * @param parent
     * @param modal
     */
    public AlterarProdutoDialogView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.preencheComboBoxCap();
        this.preencheComboBoxCat();
        this.preencheComboBoxCor();
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
        JLBAtualizar = new javax.swing.JLabel();
        jBTSalvar = new javax.swing.JButton();
        jPImagem = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jCBCor = new javax.swing.JComboBox<>();
        jLBCor = new javax.swing.JLabel();
        jLBCapacidade = new javax.swing.JLabel();
        jCBCapacidade = new javax.swing.JComboBox<>();
        jCBCategoria = new javax.swing.JComboBox<>();
        jLBCategoria = new javax.swing.JLabel();
        jLBCodigo = new javax.swing.JLabel();
        jTFCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JLBAtualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JLBAtualizar.setForeground(new java.awt.Color(0, 51, 255));
        JLBAtualizar.setText("PRODUTO");
        JLBAtualizar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ATUALIZAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jBTSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBTSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/if_floppy_disk_save_103863.png"))); // NOI18N
        jBTSalvar.setText("SALVAR");
        jBTSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTSalvarActionPerformed(evt);
            }
        });

        jPImagem.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/copoeprato.png"))); // NOI18N

        javax.swing.GroupLayout jPImagemLayout = new javax.swing.GroupLayout(jPImagem);
        jPImagem.setLayout(jPImagemLayout);
        jPImagemLayout.setHorizontalGroup(
            jPImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPImagemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        jPImagemLayout.setVerticalGroup(
            jPImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPImagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jCBCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLBCor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLBCor.setText("COR:");

        jLBCapacidade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLBCapacidade.setText("CAPACIDADE:");

        jCBCapacidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLBCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLBCategoria.setText("CATEGORIA:");

        jLBCodigo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLBCodigo.setText("CÓDIGO:");

        jTFCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTFCodigo.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLBCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLBCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLBCor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCBCor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLBCapacidade)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCBCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBCodigo)
                    .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBCategoria)
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBCapacidade)
                    .addComponent(jCBCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBCor)
                    .addComponent(jCBCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLBAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTSalvar))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLBAtualizar)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBTSalvar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            if (validaProduto()) {
                ProdutoCntrl prodCntrl = new ProdutoCntrl();
                Integer prod_id = Integer.parseInt(this.jTFCodigo.getText().trim());
                Integer cap_id = ValidacaoCntrl.temCapacidade(Integer.parseInt(this.jCBCapacidade.getSelectedItem().toString()));
                Integer cat_id = ValidacaoCntrl.temCategoria(this.jCBCategoria.getSelectedItem().toString());
                Integer cor_id = ValidacaoCntrl.temCor(this.jCBCor.getSelectedItem().toString());

                if (prodCntrl.alterar(prod_id, cap_id, cat_id, cor_id)) {
                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                }
            }
        } catch (GenericSqlException | GenericValidacaoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NumberFormatException ex1) {
            JOptionPane.showMessageDialog(null, "Formato de número inválido!\n" + ex1.getMessage());
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
            java.util.logging.Logger.getLogger(AlterarProdutoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarProdutoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarProdutoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarProdutoDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlterarProdutoDialogView dialog = new AlterarProdutoDialogView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLBAtualizar;
    private javax.swing.JButton jBTSalvar;
    private javax.swing.JComboBox<String> jCBCapacidade;
    private javax.swing.JComboBox<String> jCBCategoria;
    private javax.swing.JComboBox<String> jCBCor;
    private javax.swing.JLabel jLBCapacidade;
    private javax.swing.JLabel jLBCategoria;
    private javax.swing.JLabel jLBCodigo;
    private javax.swing.JLabel jLBCor;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFCodigo;
    // End of variables declaration//GEN-END:variables

    public void setCodigoProduto(String codigo) {
        this.jTFCodigo.setText(codigo);
    }

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

    private void preencheComboBoxCor() {
        CorCntrl corCntrl = new CorCntrl();
        List listaCor = corCntrl.listar();
        this.jCBCor.removeAllItems();
        this.jCBCor.addItem("");
        for (int i = 0; i < listaCor.size(); i++) {
            this.jCBCor.addItem(listaCor.get(i).toString());
        }
    }

    private boolean validaProduto() throws GenericValidacaoException {
        if (this.jCBCapacidade.getSelectedIndex() == 0 || this.jCBCategoria.getSelectedIndex() == 0 || this.jCBCor.getSelectedIndex() == 0) {
            throw new GenericValidacaoException("Falha os campos devem ser preenchidos!\nUm produto contém categoria, capacidade e cor.");
        }
        return true;
    }
}