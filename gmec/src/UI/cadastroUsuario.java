/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Control.usuarioControl;
import Objects.usuario;

/**
 *
 * @author natty
 */
public class cadastroUsuario extends javax.swing.JDialog {

    private boolean inserir = false;

    public void setInserir(boolean inserir) {
        this.inserir = inserir;
    }

    /**
     * Creates new form cadastroUsuario
     */
    public cadastroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        arrumarTela();
    }

    public void arrumarTela() {
        CT_nomeUsuario.setText("");
        PF_senhaUsuario.setText("");
        B_salvar.setEnabled(true);
        B_excluir.setEnabled(false);
        B_alterar.setEnabled(false);
    }

    public void arrumarTela(usuario user) {
        CT_nomeUsuario.setText(user.getUser());
        PF_senhaUsuario.setText(user.getSenha());
        CT_nomeUsuario.setEditable(false);
        PF_senhaUsuario.setEditable(false);
        B_excluir.setEnabled(true);
        B_alterar.setEnabled(true);
        B_salvar.setEnabled(false);
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
        CT_nomeUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        B_salvar = new javax.swing.JButton();
        B_excluir = new javax.swing.JButton();
        B_alterar = new javax.swing.JButton();
        PF_senhaUsuario = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Usuário");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Usuário:");

        jLabel2.setText("Senha:");

        B_salvar.setText("Salvar");
        B_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_salvarActionPerformed(evt);
            }
        });

        B_excluir.setText("Excluir");
        B_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_excluirActionPerformed(evt);
            }
        });

        B_alterar.setText("Alterar");
        B_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_alterarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Cadastrar Usuário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(B_salvar)
                .addGap(28, 28, 28)
                .addComponent(B_alterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(B_excluir)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PF_senhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CT_nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PF_senhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_salvar)
                    .addComponent(B_alterar)
                    .addComponent(B_excluir))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void B_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_salvarActionPerformed
        // TODO add your handling code here:
        usuarioControl validar = new usuarioControl();
        usuario user = new usuario();
        user.setUser(CT_nomeUsuario.getText());
        user.setSenha(PF_senhaUsuario.getText());
        if (!inserir) {
            if (validar.atualizarUsuario(user)) {
                arrumarTela();
                this.dispose();
            }
        } else {
            if (!validar.pesquisarUsuario(user.getUser())) {
                if (validar.validarCampos(user)) {
                    arrumarTela();
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_B_salvarActionPerformed

    private void B_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_excluirActionPerformed
        usuarioControl validar = new usuarioControl();
        int valor = validar.excluir(CT_nomeUsuario.getText());
        if (valor == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_B_excluirActionPerformed

    private void B_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_alterarActionPerformed
        CT_nomeUsuario.setEditable(false);
        PF_senhaUsuario.setEditable(true);
        B_salvar.setEnabled(true);
        B_alterar.setEnabled(false);
        B_excluir.setEnabled(false);
        PF_senhaUsuario.requestFocus();
    }//GEN-LAST:event_B_alterarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(cadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                cadastroUsuario dialog = new cadastroUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton B_alterar;
    private javax.swing.JButton B_excluir;
    private javax.swing.JButton B_salvar;
    private javax.swing.JTextField CT_nomeUsuario;
    private javax.swing.JPasswordField PF_senhaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
