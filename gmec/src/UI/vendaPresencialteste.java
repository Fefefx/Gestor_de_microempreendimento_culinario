/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import Control.produtoControl;
import Control.vendaControl;
import Objects.produtosVenda;
import Objects.vendas;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Beth
 */
public class vendaPresencialteste extends javax.swing.JFrame {

    vendas venda = new vendas();
    private int codigoVenda = 0;
    ArrayList itens = new ArrayList();
    private boolean fechar = false;
    private String usuario;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Creates new form vendaPresencial
     */
    public vendaPresencialteste() {
        initComponents();
        desativaBTela();
    }

    public void aplicarMascara() {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.install(CT_dataVenda);
        } catch (ParseException ex) {
            Logger.getLogger(vendaPresencialteste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desativaBTela() {
        aplicarMascara();
        CT_total.setEditable(false);
        CT_dataVenda.requestFocus();
        CT_produto.setEditable(true);
        B_removerItem.setEnabled(false);
        B_salvar.setEnabled(false);
        B_alterar.setEnabled(false);
        B_excluir.setEnabled(false);
    }

    public void arrumaTela(vendas dados) {
        codigoVenda = dados.getCodigo();
        CT_dataVenda.setText("");
        CT_dataVenda.setText(dados.getDataVenda());
        arrumaTabela(dados.retornarItens());
    }

    public void arrumaTabela(ArrayList valores) {
        float valorTotal = 0;
        DefaultTableModel modelo = (DefaultTableModel) Tab_itens.getModel();
        while (modelo.getRowCount() != 0) {
            modelo.removeRow(0);
        }
        for (int i = 0; i < valores.size(); i++) {
            produtosVenda prodVenda = (produtosVenda) valores.get(i);
            String[] linha = new String[4];
            linha[0] = prodVenda.getNome();
            linha[1] = String.valueOf(prodVenda.getQuantidade());
            linha[2] = String.valueOf(prodVenda.getValorUnitario());
            linha[3] = String.valueOf(prodVenda.getTotalProduto());
            valorTotal += prodVenda.getTotalProduto();
            modelo.addRow(linha);
        }
        Tab_itens.setModel(modelo);
        itens = valores;
        BigDecimal arredondar = new BigDecimal(valorTotal).setScale(2, RoundingMode.HALF_UP);
        valorTotal = arredondar.floatValue();
        CT_total.setText(String.valueOf(valorTotal));
        if (modelo.getRowCount() != 0) {
            if (codigoVenda == 0) {
                B_salvar.setEnabled(true);
            } else {
                B_excluir.setEnabled(true);
                B_alterar.setEnabled(true);
            }
        } else {
            desativaBTela();
        }
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
        CT_produto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tab_itens = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        CT_total = new javax.swing.JTextField();
        B_salvar = new javax.swing.JButton();
        b_pesquisar = new javax.swing.JButton();
        B_alterar = new javax.swing.JButton();
        B_excluir = new javax.swing.JButton();
        CT_dataVenda = new javax.swing.JFormattedTextField();
        B_removerItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar venda ");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Produto:");

        CT_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CT_produtoActionPerformed(evt);
            }
        });

        jLabel3.setText("Data da Venda:");

        Tab_itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Valor Unitário", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tab_itens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tab_itensMouseClicked(evt);
            }
        });
        Tab_itens.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                Tab_itensCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                Tab_itensInputMethodTextChanged(evt);
            }
        });
        Tab_itens.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tab_itensKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Tab_itensKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Tab_itens);

        jLabel4.setText("Total da Venda:");

        B_salvar.setText("Salvar");
        B_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_salvarActionPerformed(evt);
            }
        });

        b_pesquisar.setText("Pesquisar");
        b_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_pesquisarActionPerformed(evt);
            }
        });

        B_alterar.setText("Alterar");

        B_excluir.setText("Excluir");

        CT_dataVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CT_dataVendaActionPerformed(evt);
            }
        });

        B_removerItem.setText("Remover Item");
        B_removerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_removerItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(CT_total, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(B_removerItem)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CT_dataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CT_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(b_pesquisar)
                        .addGap(44, 44, 44))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(B_salvar)
                .addGap(18, 18, 18)
                .addComponent(B_alterar)
                .addGap(17, 17, 17)
                .addComponent(B_excluir)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CT_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_pesquisar)
                    .addComponent(jLabel3)
                    .addComponent(CT_dataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CT_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_removerItem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_salvar)
                    .addComponent(B_alterar)
                    .addComponent(B_excluir))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CT_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CT_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CT_produtoActionPerformed

    private void b_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_pesquisarActionPerformed
        produtoControl validar = new produtoControl();
        constroiVenda();
        if (validar.validaProduto(CT_produto.getText())) {
            buscarProduto buscar = new buscarProduto();
            buscar.armazenarDados(venda);
            buscar.setUsuario(usuario);
            buscar.arrumaTabela(CT_produto.getText());
            buscar.setVisible(true);
            fechar = true;
            this.dispose();
        } else {
            CT_produto.requestFocus();
        }
    }//GEN-LAST:event_b_pesquisarActionPerformed

    private void CT_dataVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CT_dataVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CT_dataVendaActionPerformed

    private void B_removerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_removerItemActionPerformed
        int valor = Tab_itens.getSelectedRow();
        if (valor == -1) {
            B_removerItem.setEnabled(false);
        } else {
            itens.remove(valor);
            arrumaTabela(itens);
            B_removerItem.setEnabled(false);
        }
    }//GEN-LAST:event_B_removerItemActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void Tab_itensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_itensMouseClicked
        B_removerItem.setEnabled(true);
    }//GEN-LAST:event_Tab_itensMouseClicked

    private void Tab_itensCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Tab_itensCaretPositionChanged

    }//GEN-LAST:event_Tab_itensCaretPositionChanged

    private void Tab_itensInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Tab_itensInputMethodTextChanged

    }//GEN-LAST:event_Tab_itensInputMethodTextChanged

    private void Tab_itensKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tab_itensKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tab_itensKeyPressed

    private void Tab_itensKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tab_itensKeyReleased
        int posicao = Tab_itens.getSelectedRow();
        int unidade = Integer.parseInt(Tab_itens.getValueAt(posicao, 1).toString());
        if (unidade <= 0) {
            JOptionPane.showMessageDialog(null, "Unidade digitada inválida");
            unidade = 1;
        }
        produtosVenda prodVenda = (produtosVenda) itens.get(posicao);
        float total = prodVenda.getValorUnitario() * unidade;
        BigDecimal formatar = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        total = formatar.floatValue();
        prodVenda.setTotalProduto(total);
        prodVenda.setQuantidade(unidade);
        itens.remove(posicao);
        itens.add(posicao, prodVenda);
        arrumaTabela(itens);
    }//GEN-LAST:event_Tab_itensKeyReleased

    private void B_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_salvarActionPerformed
        vendaControl vendaControle = new vendaControl();
        constroiVenda();
        if (!vendaControle.verificarItens(venda)) {
            JOptionPane.showMessageDialog(null, "Insira algum produto na venda");
        } else {
            String data = formataData();
            constroiVenda(data);
            venda.adicionarItens(itens);
            if (vendaControle.salvarVenda(venda)) {
                telaInicial start = new telaInicial();
                start.arrumaTela(usuario);
                start.setVisible(true);
                fechar = true;
                this.dispose();
            }
        }
    }//GEN-LAST:event_B_salvarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (!fechar) {
            telaInicial start = new telaInicial();
            start.arrumaTela(usuario);
            start.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosed

    public void constroiVenda() {
        venda.setCodigo(codigoVenda);
        venda.setDataVenda(CT_dataVenda.getText());
        if (!CT_total.getText().isEmpty()) {
            venda.setTotal(Float.parseFloat(CT_total.getText()));
        }
        venda.adicionarItens(itens);
    }

    public void constroiVenda(String data) {
        venda.setCodigo(codigoVenda);
        venda.setDataVenda(data);
        if (!CT_total.getText().isEmpty()) {
            venda.setTotal(Float.parseFloat(CT_total.getText()));
        }
        venda.adicionarItens(itens);
    }

    public String formataData() {
        String formatar = CT_dataVenda.getText().replace("/", "-");
        formatar = formatar.substring(6) + "-" + formatar.substring(3, 5) + "-" + formatar.substring(0, 2);
        System.out.println(formatar);
        return formatar;
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
            java.util.logging.Logger.getLogger(vendaPresencialteste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vendaPresencialteste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vendaPresencialteste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vendaPresencialteste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vendaPresencialteste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_alterar;
    private javax.swing.JButton B_excluir;
    private javax.swing.JButton B_removerItem;
    private javax.swing.JButton B_salvar;
    private javax.swing.JFormattedTextField CT_dataVenda;
    private javax.swing.JTextField CT_produto;
    private javax.swing.JTextField CT_total;
    private javax.swing.JTable Tab_itens;
    private javax.swing.JButton b_pesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
