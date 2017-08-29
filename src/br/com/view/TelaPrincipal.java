/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

/**
 *
 * @author Cristiano
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem8 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMIProduto = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMIEstoque = new javax.swing.JMenuItem();
        jMIMaquina = new javax.swing.JMenuItem();
        jMIProducao = new javax.swing.JMenuItem();
        jMIVenda = new javax.swing.JMenuItem();
        jMProduto = new javax.swing.JMenu();
        jMICadastrados = new javax.swing.JMenuItem();
        jMICaracteristica = new javax.swing.JMenuItem();

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setText("AUTOMAÇÃO INDUSTRIAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jLabel1)
                .addContainerGap(322, Short.MAX_VALUE))
        );

        jMenu1.setText("CADASTRO");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMIProduto.setText("Produto");
        jMIProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jMIProduto);

        jMenuItem2.setText("Usuário");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("EXIBIR");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMIEstoque.setText("Estoque");
        jMIEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEstoqueActionPerformed(evt);
            }
        });
        jMenu2.add(jMIEstoque);

        jMIMaquina.setText("Máquina");
        jMIMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIMaquinaActionPerformed(evt);
            }
        });
        jMenu2.add(jMIMaquina);

        jMIProducao.setText("Produção");
        jMIProducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIProducaoActionPerformed(evt);
            }
        });
        jMenu2.add(jMIProducao);

        jMIVenda.setText("Venda");
        jMIVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIVendaActionPerformed(evt);
            }
        });
        jMenu2.add(jMIVenda);

        jMProduto.setText("Produto");

        jMICadastrados.setText("Cadastrados");
        jMICadastrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICadastradosActionPerformed(evt);
            }
        });
        jMProduto.add(jMICadastrados);

        jMICaracteristica.setText("Características");
        jMICaracteristica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICaracteristicaActionPerformed(evt);
            }
        });
        jMProduto.add(jMICaracteristica);

        jMenu2.add(jMProduto);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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

    private void jMIEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEstoqueActionPerformed
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
        this.getContentPane().revalidate();
        this.setContentPane(new EstoqueView());

    }//GEN-LAST:event_jMIEstoqueActionPerformed

    private void jMIProducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIProducaoActionPerformed
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
        this.getContentPane().revalidate();
        this.setContentPane(new ProducaoView());
    }//GEN-LAST:event_jMIProducaoActionPerformed

    private void jMIVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIVendaActionPerformed
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
        this.getContentPane().revalidate();
        this.setContentPane(new VendaView());
    }//GEN-LAST:event_jMIVendaActionPerformed

    private void jMICadastradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICadastradosActionPerformed
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
        this.getContentPane().revalidate();
        this.setContentPane(new ProdutosView());
    }//GEN-LAST:event_jMICadastradosActionPerformed

    private void jMICaracteristicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICaracteristicaActionPerformed
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
        this.getContentPane().revalidate();
        this.setContentPane(new CaracteristicasProdutoView());
    }//GEN-LAST:event_jMICaracteristicaActionPerformed

    private void jMIMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIMaquinaActionPerformed
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
        this.getContentPane().revalidate();
        this.setContentPane(new MaquinaView());
    }//GEN-LAST:event_jMIMaquinaActionPerformed

    private void jMIProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIProdutoActionPerformed
        AdicionarProdutoDialogView dialog = new AdicionarProdutoDialogView(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMIProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMICadastrados;
    private javax.swing.JMenuItem jMICaracteristica;
    private javax.swing.JMenuItem jMIEstoque;
    private javax.swing.JMenuItem jMIMaquina;
    private javax.swing.JMenuItem jMIProducao;
    private javax.swing.JMenuItem jMIProduto;
    private javax.swing.JMenuItem jMIVenda;
    private javax.swing.JMenu jMProduto;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
