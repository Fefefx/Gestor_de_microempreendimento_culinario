/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Services.data;
import Services.notificacao;

/**
 *
 * @author felipe
 */
public class telaInicial extends javax.swing.JFrame {

    data time = new data();

    /**
     * Creates new form telaInicial
     */
    public telaInicial() {
        initComponents();
        CT_data.setText(time.obterData());
        CT_data.setEditable(false);
        CT_usuario.setEditable(false);
    }

    public void arrumaTela(String usuario) {
        CT_usuario.setText(usuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CT_data = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CT_usuario = new javax.swing.JTextField();
        B_encomendas = new javax.swing.JButton();
        B_usuarios = new javax.swing.JButton();
        B_produtos = new javax.swing.JButton();
        B_vendas = new javax.swing.JButton();
        B_clientes = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        B_relatorios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela inicial");

        jLabel1.setText("Data:");

        CT_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CT_dataActionPerformed(evt);
            }
        });

        jLabel2.setText("Usuário:");

        CT_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CT_usuarioActionPerformed(evt);
            }
        });

        B_encomendas.setText("Encomendas");
        B_encomendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_encomendasActionPerformed(evt);
            }
        });

        B_usuarios.setText("Usuários");
        B_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_usuariosActionPerformed(evt);
            }
        });

        B_produtos.setText("Produtos");
        B_produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_produtosActionPerformed(evt);
            }
        });

        B_vendas.setText("Vendas");
        B_vendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_vendasActionPerformed(evt);
            }
        });

        B_clientes.setText("Clientes");
        B_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_clientesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setText("Bem-vindo");

        B_relatorios.setText("Relatórios");
        B_relatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_relatoriosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B_produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_encomendas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_vendas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(B_usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B_relatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 86, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(CT_usuario)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(CT_data, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CT_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(CT_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_vendas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_encomendas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_relatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CT_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CT_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CT_dataActionPerformed

    private void B_encomendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_encomendasActionPerformed
        visualizarEncomendas visu = new visualizarEncomendas();
        visu.setUser(CT_usuario.getText());
        this.setVisible(false);
        visu.setVisible(true);
    }//GEN-LAST:event_B_encomendasActionPerformed

    private void B_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_clientesActionPerformed
        visualizarClientes visu = new visualizarClientes();
        visu.setUser(CT_usuario.getText());
        this.setVisible(false);
        visu.setVisible(true);
    }//GEN-LAST:event_B_clientesActionPerformed

    private void CT_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CT_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CT_usuarioActionPerformed

    private void B_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_produtosActionPerformed
        this.setVisible(false);
        visualizarProdutos visua = new visualizarProdutos();
        visua.setUser(CT_usuario.getText());
        visua.setVisible(true);
    }//GEN-LAST:event_B_produtosActionPerformed

    private void B_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_usuariosActionPerformed
        visualizarUsuarios usuarios = new visualizarUsuarios();
        usuarios.setUser(CT_usuario.getText());
        this.setVisible(false);
        usuarios.setVisible(true);
    }//GEN-LAST:event_B_usuariosActionPerformed

    private void B_vendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_vendasActionPerformed
        visualizarVenda venda= new visualizarVenda();
        this.dispose();
        venda.setVisible(true);
        venda.setUser(CT_usuario.getText());
    }//GEN-LAST:event_B_vendasActionPerformed

    private void B_relatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_relatoriosActionPerformed
        telaRelatorios relat = new telaRelatorios();
        this.dispose();
        relat.setVisible(true);
        relat.setUser(CT_usuario.getText());
    }//GEN-LAST:event_B_relatoriosActionPerformed

    public void dipararServico(){
        notificacao servico = new notificacao();
        if(servico.dispararNotificacao(CT_usuario.getText())){
            this.dispose();
        }
    }
    
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
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_clientes;
    private javax.swing.JButton B_encomendas;
    private javax.swing.JButton B_produtos;
    private javax.swing.JButton B_relatorios;
    private javax.swing.JButton B_usuarios;
    private javax.swing.JButton B_vendas;
    private javax.swing.JTextField CT_data;
    private javax.swing.JTextField CT_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
