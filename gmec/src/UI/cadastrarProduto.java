/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Objects.produto;
import Control.produtoControl;

/**
 *
 * @author felipe   
 */
public class cadastrarProduto extends javax.swing.JDialog {

    private int idprod = 0;

    /**
     * Creates new form cadastrarProduto
     */
    public cadastrarProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        arrumarTela();
    }

    public void arrumarTela() {
        CT_nome.setText("");
        CT_rendimento.setText("");
        CT_valorCusto.setText("");
        CT_valorUnitario.setText("");
        CT_descricao.setText("");
        CT_ingredientes.setText("");
        CT_nome.setEditable(true);
        CT_nome.requestFocus();
        CT_rendimento.setEditable(true);
        CT_valorCusto.setEditable(true);
        CT_valorUnitario.setEditable(true);
        CT_descricao.setEditable(true);
        CT_ingredientes.setEditable(true);
        B_salvar.setEnabled(true);
        B_alterar.setEnabled(false);
        B_excluir.setEnabled(false);
        idprod = 0;
    }

    public void arrumarTela(produto prod) {
        CT_nome.setText(prod.getNome());
        CT_nome.setEditable(false);
        CT_rendimento.setText(String.valueOf(prod.getRendimento()));
        CT_rendimento.setEditable(false);
        CT_valorCusto.setText(String.valueOf(prod.getValorCusto()));
        CT_valorCusto.setEditable(false);
        CT_valorUnitario.setText(String.valueOf(prod.getValorUnitario()));
        CT_valorUnitario.setEditable(false);
        CT_descricao.setText(prod.getDescricao());
        CT_descricao.setEditable(false);
        CT_ingredientes.setText(prod.getIngredientes());
        CT_ingredientes.setEditable(false);
        B_salvar.setEnabled(false);
        B_excluir.setEnabled(true);
        B_alterar.setEnabled(true);
        idprod = prod.getCodigo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        CT_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CT_rendimento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CT_valorCusto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CT_valorUnitario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CT_ingredientes = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CT_descricao = new javax.swing.JTextField();
        B_salvar = new javax.swing.JButton();
        B_excluir = new javax.swing.JButton();
        B_alterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Produto");

        jLabel1.setText("Nome:");

        jLabel2.setText("Rendimento:");

        jLabel3.setText("Valor de Custo:");

        jLabel4.setText("Valor Unitário:");

        jLabel5.setText("Ingredientes:");

        CT_ingredientes.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        CT_ingredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CT_ingredientesActionPerformed(evt);
            }
        });

        jLabel6.setText("Descrição:");

        CT_descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CT_descricaoActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(B_salvar)
                        .addGap(29, 29, 29)
                        .addComponent(B_alterar)
                        .addGap(34, 34, 34)
                        .addComponent(B_excluir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(CT_ingredientes))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(CT_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 32, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(CT_valorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(CT_valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(CT_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(CT_rendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CT_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(CT_rendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CT_valorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(CT_valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CT_ingredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CT_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_salvar)
                    .addComponent(B_alterar)
                    .addComponent(B_excluir))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CT_ingredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CT_ingredientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CT_ingredientesActionPerformed

    private void CT_descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CT_descricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CT_descricaoActionPerformed

    private void B_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_salvarActionPerformed
        produtoControl prodControl = new produtoControl();
        if (prodControl.validarRendimento(CT_rendimento.getText())) {
            String[] valores;
            valores = prodControl.validarValores(CT_valorCusto.getText(), CT_valorUnitario.getText(),Integer.parseInt(CT_rendimento.getText()));
            String validar = valores[1];
            if ("NULO".equals(validar)) {
                System.out.println("\nRetorno vazio");
            } else {
                produto prod = new produto();
                prod.setCodigo(idprod);
                prod.setNome(CT_nome.getText());
                prod.setDescricao(CT_descricao.getText());
                prod.setIngredientes(CT_ingredientes.getText());
                prod.setRendimento(Integer.parseInt(CT_rendimento.getText()));
                prod.setValorCusto(Float.parseFloat(valores[0]));
                prod.setValorUnitario(Float.parseFloat(valores[1])); 
                System.out.println("\nProduto instanciado");
                boolean val = prodControl.validarCamposTexto(prod);
                if(val)
                    this.dispose();
            }
        }
    }//GEN-LAST:event_B_salvarActionPerformed

    private void B_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_alterarActionPerformed
        CT_nome.setEditable(true);
        CT_descricao.setEditable(true);
        CT_ingredientes.setEditable(true);
        CT_rendimento.setEditable(true);
        CT_valorCusto.setEditable(true);
        CT_valorUnitario.setEditable(true);
        B_salvar.setEnabled(true);
        B_excluir.setEnabled(false);
        B_alterar.setEnabled(false);
    }//GEN-LAST:event_B_alterarActionPerformed

    private void B_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_excluirActionPerformed
        produtoControl prodControl= new produtoControl();
        int valor=prodControl.excluir(idprod);
        if(valor==0)
            this.dispose();
    }//GEN-LAST:event_B_excluirActionPerformed

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
            java.util.logging.Logger.getLogger(cadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                cadastrarProduto dialog = new cadastrarProduto(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField CT_descricao;
    private javax.swing.JTextField CT_ingredientes;
    private javax.swing.JTextField CT_nome;
    private javax.swing.JTextField CT_rendimento;
    private javax.swing.JTextField CT_valorCusto;
    private javax.swing.JTextField CT_valorUnitario;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
